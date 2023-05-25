package com.example.crudlaptopdetails.Service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudlaptopdetails.Entity.Laptop;
import com.example.crudlaptopdetails.Exception.LaptopaAlreadyExistsException;
import com.example.crudlaptopdetails.Exception.NoSuchLaptopExistsException;
import com.example.crudlaptopdetails.Repository.LaptopRepository;


@Service
public class LaptopServiceImp  {

	private static final Iterable<? extends Integer> Id = null;
	@Autowired
	private LaptopRepository laptoprepository;
	
	

	// NoSuchElementException for invalid Id
	public Laptop getLaptop(int id)
	{
		
		return laptoprepository.findById(id).orElseThrow(
			()-> new NoSuchElementException("NO LAPTOP PRESENT WITH ID = " + id));
	}

	// Method to add new customer details to database.Throws
	// CustomerAlreadyExistsException when customer detail
	// already exist
	public String addLaptop(Laptop laptop)
	{
		
		Laptop existingLaptop= laptoprepository.findById(laptop.getId()).orElse(null);
		if (existingLaptop!=null) {
			throw new LaptopaAlreadyExistsException("Laptop already exists");
//			laptoprepository.save(laptop);
//			return "Laptop added successfully";
		}
		else
//			throw new LaptopaAlreadyExistsException("Laptop already exists");
			laptoprepository.save(laptop);
		return "Laptop added successfully";
	}
	

	// Method to update customer details to database.Throws
	// NoSuchCustomerExistsException when customer doesn't
	// already exist in database
	public String updateLaptop(Laptop laptop)
	{
		
		Laptop existingLaptop=laptoprepository.findById(laptop.getId()).orElse(null);
		if (existingLaptop == null)
			throw new NoSuchLaptopExistsException("No Such Laptop exists!!");
		else {
			existingLaptop.setName(laptop.getName());
			existingLaptop.setLocation(laptop.getLocation());
			existingLaptop.setPhone(laptop.getPhone());
			existingLaptop.setZipcode(laptop.getZipcode());
			laptoprepository.save(existingLaptop);
			return "Record updated Successfully";
		}
	}
	
		
	public String deleteLaptop(int id) {
		
		Laptop existingLaptop=laptoprepository.findById(id).orElse(null);
		if(existingLaptop!=null) {
			laptoprepository.deleteById(id);
			return "deleted succefully";
		}
		
		else {
				throw new NoSuchLaptopExistsException("No Such Laptop exists!!");
			}
		}
	
	
	}
	


	
	