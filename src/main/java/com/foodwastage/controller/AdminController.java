package com.foodwastage.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.foodwastage.models.Agent;
import com.foodwastage.service.AgentService;
import com.foodwastage.service.UserService;

@Controller
public class AdminController {
	
	@Autowired HttpSession session;
	@Autowired UserService uservice;
	@Autowired AgentService aservice;

	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("agents", uservice.listAgents().size());
		model.addAttribute("donors", uservice.listDonors().size());
		model.addAttribute("collects", uservice.listCollections().size());
		return "dashboard";
	}
	
	
	
	@GetMapping("/donations")
	public String donations(Model model) {
		model.addAttribute("list", uservice.allDonations());
		return "donations";
	}
	
	@GetMapping("/process/{id}")
	public String process(@PathVariable("id") int id,Model model) {
		model.addAttribute("d", uservice.findById(id));
		model.addAttribute("list", uservice.listAgents());
		return "processdonation";
	}
	
	@GetMapping("/updatestatus")
	public String updateStatus(String status,int id,RedirectAttributes ra) {
		uservice.updateStatus(id, status);
		ra.addFlashAttribute("msg", "Donation status updated successfully");
		return "redirect:/process/"+id;
	}
	
	@PostMapping("/movetoagent")
	public String moveToAgent(int id,int agentid,String remarks,RedirectAttributes ra) {
		Agent agent=aservice.findById(agentid);
		uservice.moveToAgent(id, agent, remarks);
		ra.addFlashAttribute("msg", "Donation moved to Agent");
		return "redirect:/donations";
	}
	
	@GetMapping("/agents")
	public String agents(Model model) {
		model.addAttribute("list", uservice.listAgents());
		return "agents";
	}
	
	@GetMapping("/donors")
	public String donors(Model model) {
		model.addAttribute("list", uservice.listDonors());
		return "donors";
	}
}
