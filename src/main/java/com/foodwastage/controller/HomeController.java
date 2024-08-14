package com.foodwastage.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.foodwastage.models.Agent;
import com.foodwastage.models.Donor;
import com.foodwastage.models.User;
import com.foodwastage.service.AgentService;
import com.foodwastage.service.DonorService;
import com.foodwastage.service.EmailService;
import com.foodwastage.service.UserService;

@Controller
public class HomeController {
	
	@Autowired HttpSession session;
	@Autowired DonorService dservice;
	@Autowired AgentService aservice;
	@Autowired UserService uservice;
	@Autowired EmailService email;
	@Autowired
    private ServletContext ctx;
	
	@GetMapping("/")
	public String homePage() {
		return "index";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	
	@GetMapping("/mission")
	public String mission() {
		return "mission";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@PostMapping("/login")
	public String validate(String userid,String pwd) {
		User user=uservice.validate(userid, pwd);
		if(user!=null) {
			session.setAttribute("user", user);
			switch(user.getRole()) {
				case "Admin":
					return "redirect:/dashboard";
				case "Donor":
					return "redirect:/dprofile";
				case "Agent":
					Agent agent=aservice.findById(user.getId());
					session.setAttribute("count", aservice.getMyDonations(agent).size());
					return "redirect:/aprofile";
			}
		}
		return "redirect:/login";
	}
	
	@GetMapping("/register")
	public String donorRegisterPage() {
		return "register";
	}
	
	@PostMapping("/register")
	public String registerDonor(Donor donor,String pwd,RedirectAttributes ra) {
		if(dservice.checkEmail(donor.getEmail())) {
			dservice.saveDonor(donor, pwd);
			String message=String.format(mailcontent(), donor.getName(),donor.getEmail(),donor.getPwd());
			email.sendSimpleMessage(donor.getEmail(), "Registered success - Food Wastage", 
					message	);
			ra.addFlashAttribute("msg", "Donor registered successfully");
			return "redirect:/login";
		}
		else {
			ra.addFlashAttribute("error", "Email already exists");
			return "redirect:/register";
		}
	}
	
	@GetMapping("/aregister")
	public String agentRegisterPage() {
		return "aregister";
	}
	
	@PostMapping("/aregister")
	public String registerAgent(Agent agent,String pwd,RedirectAttributes ra) {
		if(aservice.checkEmail(agent.getEmail())) {
			aservice.saveAgent(agent, pwd);
			email.sendSimpleMessage(agent.getEmail(), "Registered success - Food Wastage", 
					"Dear "+agent.getName()+",<br>You have been registered successfully as Agent.");
			ra.addFlashAttribute("msg", "Agent registered successfully");
			return "redirect:/login";
		}else {
			ra.addFlashAttribute("error", "Email already exists");
			return "redirect:/register";
		}
	}
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
	
	@SuppressWarnings("resource")
	public String mailcontent() {
		InputStream inputStream;
		String result="";
		try {
			inputStream = new FileInputStream(ctx.getRealPath("/")+"mailtemplate.html");
			result = new BufferedReader(new InputStreamReader(inputStream))
					.lines().collect(Collectors.joining("\n"));		
		} catch (IOException e) {
			System.out.println("Error "+e.getMessage());
		}
        return result;
	}
}
