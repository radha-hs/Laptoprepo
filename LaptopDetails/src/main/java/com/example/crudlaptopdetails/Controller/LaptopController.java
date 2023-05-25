package com.example.crudlaptopdetails.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudlaptopdetails.Entity.Laptop;
import com.example.crudlaptopdetails.Service.LaptopServiceImp;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/laptop")
	public class LaptopController {

		@Autowired 
		private LaptopServiceImp laptopservice;
		//private static final Logger LOGGER=LoggerFactory.getLogger(LaptopController.class);

		// Get laptop by Id
		@GetMapping("/getlaptop/{id}")
		public ResponseEntity<Laptop> getLaptop(@PathVariable(required=true)int id ) {
//			LOGGER.info("Inside class LaptopController!!!! method: getlaptop by id",id);
//			LOGGER.warn("please enter details properly");
//			LOGGER.debug("it's for debugging");
			Laptop LaptopDetails=laptopservice.getLaptop(id);
			return new ResponseEntity<Laptop>(LaptopDetails,HttpStatus.OK);
			
		}
		// Add new laptop
		@PostMapping("/addlaptop")
		public ResponseEntity<String>addLapatop(@Valid @RequestBody Laptop laptop){//return the status of object
			//LOGGER.info("Inside class LaptopController method: addlaptop");
			laptopservice.addLaptop(laptop);
				return new ResponseEntity<String>("added laptop details",HttpStatus.CREATED);
			}

		// Update laptops details
		@PutMapping("/updatelaptop/{id}")
		public ResponseEntity<String> updateLaptop(@PathVariable("id") int id, @RequestBody Laptop laptop){
			//LOGGER.info("Inside class LaptopController method:updatelaptop",id);
			laptopservice.updateLaptop(laptop);
			laptop.setId(id);
			return new ResponseEntity<String>("updated",HttpStatus.OK);
		}
		
			//delete laptop by id
		@DeleteMapping("/deletelaptop/{id}")
		public ResponseEntity<String> deleteLaptop(@PathVariable("id") int id){
			//LOGGER.info("Inside class LaptopController method: deletelaptop",id);
			laptopservice.deleteLaptop(id);
			//laptop.setId(id);
				return new ResponseEntity<String>("deleted",HttpStatus.OK);
		}
}
	



