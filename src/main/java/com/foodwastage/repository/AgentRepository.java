package com.foodwastage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodwastage.models.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Integer> {
	Agent findByEmail(String email);
}
