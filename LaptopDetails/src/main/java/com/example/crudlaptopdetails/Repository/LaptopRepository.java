package com.example.crudlaptopdetails.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crudlaptopdetails.Entity.Laptop;

	@Repository
	public interface LaptopRepository extends JpaRepository<Laptop,Integer> {

		
	
}

