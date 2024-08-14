package com.foodwastage.models;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Donation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String foodtype;
	private LocalDate cookdate;
	private LocalTime cooktime;
	private String qty;
	private String status;
	private String address;
	private String adminremarks;
	private String agentremarks;
	
	@ManyToOne
	@JoinColumn(name="donorid")
	private Donor donor;
	
	@ManyToOne
	@JoinColumn(name="agentid")
	private Agent agent;
	
	
	
	public String getAdminremarks() {
		return adminremarks;
	}
	public void setAdminremarks(String adminremarks) {
		this.adminremarks = adminremarks;
	}
	public String getAgentremarks() {
		return agentremarks;
	}
	public void setAgentremarks(String agentremarks) {
		this.agentremarks = agentremarks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFoodtype() {
		return foodtype;
	}
	public void setFoodtype(String foodtype) {
		this.foodtype = foodtype;
	}
	public LocalDate getCookdate() {
		return cookdate;
	}
	public void setCookdate(LocalDate cookdate) {
		this.cookdate = cookdate;
	}
	public LocalTime getCooktime() {
		return cooktime;
	}
	public void setCooktime(LocalTime cooktime) {
		this.cooktime = cooktime;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Donor getDonor() {
		return donor;
	}
	public void setDonor(Donor donar) {
		this.donor = donar;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Donation [id=" + id + ", foodtype=" + foodtype + ", cookdate=" + cookdate + ", cooktime=" + cooktime
				+ ", qty=" + qty + ", address=" + address + ", donor=" + donor + ", agent=" + agent + ", status="
				+ status + "]";
	}
	
	
}
