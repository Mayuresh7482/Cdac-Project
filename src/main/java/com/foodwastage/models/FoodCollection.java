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
public class FoodCollection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="agentid")
	private Agent agent;
	private LocalDate collectdate;
	private LocalTime collecttime;
	private String orphan;
	private String address;
	@ManyToOne
	@JoinColumn(name="donorid")
	private Donor donor;
	
	public Donor getDonor() {
		return donor;
	}
	public void setDonor(Donor donor) {
		this.donor = donor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public LocalDate getCollectdate() {
		return collectdate;
	}
	public void setCollectdate(LocalDate collectdate) {
		this.collectdate = collectdate;
	}
	public LocalTime getCollecttime() {
		return collecttime;
	}
	public void setCollecttime(LocalTime collecttime) {
		this.collecttime = collecttime;
	}
	public String getOrphan() {
		return orphan;
	}
	public void setOrphan(String orphan) {
		this.orphan = orphan;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "FoodCollection [id=" + id + ", agent=" + agent + ", collectdate=" + collectdate + ", collecttime="
				+ collecttime + ", orphan=" + orphan + ", address=" + address + "]";
	}
	
	
}
