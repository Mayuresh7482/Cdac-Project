package com.foodwastage.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.foodwastage.models.Agent;
import com.foodwastage.models.Donation;
import com.foodwastage.models.FoodCollection;
import com.foodwastage.models.User;
import com.foodwastage.service.AgentService;
import com.foodwastage.service.DonorService;
import com.foodwastage.service.UserService;

@Controller
public class AgentController {

	@Autowired HttpSession session;
	@Autowired AgentService aservice;
	@Autowired DonorService dservice;
	@Autowired UserService uservice;
	
	@GetMapping("/aprofile")
	public String dashboard(Model model) {
		User user=(User)session.getAttribute("user");
		model.addAttribute("p", aservice.findById(user.getId()));
		return "aprofile";
	}
	
	@GetMapping("/notifications")
	public String notifications(Model model) {
		User user=(User)session.getAttribute("user");
		Agent agent=aservice.findById(user.getId());
		model.addAttribute("list", aservice.getMyDonations(agent));
		return "notifications";
	}
	
	@GetMapping("/collect/{id}")
	public String collectFood(@PathVariable("id") int id,Model model) {
		model.addAttribute("d", aservice.getDonationsDetails(id));
		return "collect";
	}
	
	@PostMapping("/collectfood")
	public String collectFoodProcess(FoodCollection fc,int donationid,int donorid,String cdate,String ctime,RedirectAttributes ra) {
		Agent agent=aservice.findById(((User)session.getAttribute("user")).getId());
		//update status 
		aservice.updateStatus(donationid);
		//create collection
		fc.setCollectdate(LocalDate.parse(cdate));
		fc.setCollecttime(LocalTime.parse(ctime));
		fc.setAgent(agent);
		fc.setDonor(dservice.findById(donorid));
		aservice.collectFood(fc);
		
		ra.addFlashAttribute("msg", "Food collected successfully");
		session.setAttribute("count", aservice.getMyDonations(agent).size());
		return "redirect:/history";
	}
	
	@GetMapping("/history")
	public String history(Model model) {
		int id=((User)session.getAttribute("user")).getId();
		model.addAttribute("list", aservice.getHistory(id));
		return "history";
	}	

}
