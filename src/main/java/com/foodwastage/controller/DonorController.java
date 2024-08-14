package com.foodwastage.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.foodwastage.models.Donation;
import com.foodwastage.models.Donor;
import com.foodwastage.models.User;
import com.foodwastage.service.DonorService;
import com.foodwastage.service.EmailService;

@Controller
public class DonorController {

	@Autowired HttpSession session;
	@Autowired DonorService dservice;
	
	
	@GetMapping("/dprofile")
	public String dprofile(Model model) {
		User user=(User)session.getAttribute("user");
		Donor donor=dservice.findById(user.getId());
		model.addAttribute("p", donor);
		return "dprofile";
	}
	
	@GetMapping("/donate")
	public String donate() {
		return "donate";
	}
	
	@PostMapping("/donate")
	public String savedonate(Donation don,String cookingdate,String cookingtime,RedirectAttributes ra) {
		User user=(User)session.getAttribute("user");
		Donor donor=dservice.findById(user.getId());
		don.setDonor(donor);
		don.setCookdate(LocalDate.parse(cookingdate));
		don.setCooktime(LocalTime.parse(cookingtime));
		dservice.donate(don);
		ra.addFlashAttribute("msg", "Donate successfully");
		return "redirect:/donate";
	}
	
	@GetMapping("/mydonations")
	public String mydonations(Model model) {
		User user=(User)session.getAttribute("user");
		Donor donor=dservice.findById(user.getId());
		model.addAttribute("list", dservice.getMyDonations(donor));
		return "mydonations";
	}
	
}
