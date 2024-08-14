package com.foodwastage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.foodwastage.models.Agent;
import com.foodwastage.models.Donation;
import com.foodwastage.models.Donor;
import com.foodwastage.models.FoodCollection;
import com.foodwastage.models.User;
import com.foodwastage.repository.CollectionRepository;
import com.foodwastage.repository.DonationRepository;
import com.foodwastage.repository.UserRepository;

@Service
public class UserService {
	@Autowired UserRepository urepo;
	@Autowired AgentService aservice;
	@Autowired DonorService dservice;
	@Autowired DonationRepository drepo;
	@Autowired CollectionRepository crepo;
	
	public void saveUser(User user) {
		urepo.save(user);
	}
	
	public List<Agent> listAgents(){
		return aservice.listAgents();
	}
	
	public List<FoodCollection> listCollections(){
		return crepo.findAll();
	}
	
	public List<Donor> listDonors(){
		return dservice.listDonors();
	}
	
	public List<Donation> allDonations(){
		return drepo.findAll(Sort.by(Direction.DESC, "id"));
	}
	
	public void updateStatus(int id,String status) {
		Donation don=drepo.getById(id);
		don.setStatus(status);
		drepo.save(don);
	}
	
	public void moveToAgent(int id,Agent agent,String remarks) {
		System.out.println("i am here "+id+" "+agent.getName()+" "+remarks);
		Donation don=drepo.getById(id);
		don.setStatus("In Process");
		don.setAgent(agent);
		don.setAdminremarks(remarks);
		drepo.save(don);
	}
	
	public Donation findById(int id) {
		return drepo.getById(id);
	}
	
	public User findUser(String userid) {
		return urepo.getById(userid);
	}
	
	public User validate(String userid,String pwd) {
		Optional<User> user=urepo.findById(userid);
		if(user.isPresent()) {
			if(user.get().getPwd().equals(pwd)) {
				return user.get();
			}else
				return null;
		}
		else
			return null;
	}
	
}
