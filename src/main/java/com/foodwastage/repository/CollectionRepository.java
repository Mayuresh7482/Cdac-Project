package com.foodwastage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodwastage.models.Agent;
import com.foodwastage.models.FoodCollection;

@Repository
public interface CollectionRepository extends JpaRepository<FoodCollection, Integer> {

	List<FoodCollection> findByAgent(Agent agent);
}
