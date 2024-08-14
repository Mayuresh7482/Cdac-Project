package com.foodwastage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodwastage.models.Agent;
import com.foodwastage.models.Donation;
import com.foodwastage.models.Donor;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Integer> {
	List<Donation> findByDonorOrderByIdDesc(Donor donor);
	List<Donation> findByAgentOrderByIdDesc(Agent agent);
	List<Donation> findByAgentAndStatus(Agent agent,String status);
}
