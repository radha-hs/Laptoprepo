package com.example.crudlaptopdetails;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.crudlaptopdetails.Entity.Laptop;
import com.example.crudlaptopdetails.Repository.LaptopRepository;
import com.example.crudlaptopdetails.Service.LaptopServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(SpringRunner.class)
@SpringBootTest
class LaptopDetailsApplicationTests {
	
	@Autowired
	private LaptopServiceImp laptopserviceimp;
	@MockBean
	private LaptopRepository laptoprepository;
	
//	@Order(1)
//	@Test
//	public void addlaptoptest() {
//		Laptop addedlaptop=new Laptop (45,"ramya","bangalore","4343434342",561209);
//		when(laptoprepository.save(addedlaptop)).thenReturn(addedlaptop);
//		assertEquals(addedlaptop,laptopserviceimp.addLaptop(addedlaptop));
//	}
//	
//	//	public void getlaptoptest() {
////		
////		when(laptoprepository.findAll()).thenReturn(Stream.of(new Laptop(45,"ramya","bangalore","4343434342",561209)).collect(Collectors.toList()));
////		//assertEquals(1,laptopserviceimp.getLaptop(45).size());
////		
////	}
//	@Order(2)
//	@Test
//
//	public void getlaptoptest() {
//		
//		Laptop getlaptops=laptopserviceimp.getLaptop(3);
//		assertEquals(3, getlaptops.getName());
//	}
//	
//	@Order(4)
//	@Test
//	public void deletelaptoptest() {
//		Laptop deletedlaptop=new Laptop(222,"pranavi","hyderabad","7896542345",786543);
//		laptopserviceimp.deleteLaptop(deletedlaptop);
////		verify(laptoprepository,times(1)).delete(deletedlaptop);
//		
//	}
//	
//	
//	@Order(3)
//	@Test
//	public void testupdatelaptop() {
//		Laptop updatedlaptop=new Laptop(222,"pranavi","hyderabad","7896542345",786543);
//		Laptop updatinglaptop=new Laptop(222,"pranavi","delhi","7896542345",786543);
//	
//		when(laptoprepository.findById(updatinglaptop.getId()));		
//				assertNotEquals("radha",laptoprepository.findById(222).get().getName());
//		}
	@Order(1)
	@Test
	public void addlaptoptest() {
		Laptop addedlaptop =new Laptop(33,"prathima","Chennai","2345678891",345678);
//		addedlaptop.setId(33);
//		addedlaptop.setName("prathima");
//		addedlaptop.setLocation("arunachalpradesh");
//		addedlaptop.setPhone("2345678124");
//		addedlaptop.setZipcode(345678)
		when(laptoprepository.findById(33)).thenReturn(Optional.of(addedlaptop));
		when(laptoprepository.save(addedlaptop)).thenReturn(addedlaptop);
		assertEquals("Laptop added successfully",laptopserviceimp.addLaptop(addedlaptop));
		}
	@Order(2)
	@Test
	public void getlaptoptest() {
		Laptop getlaptopbyid=new Laptop();
		getlaptopbyid.setId(33);
		getlaptopbyid.setName("prathima");
		getlaptopbyid.setLocation("arunachalpradesh");
		getlaptopbyid.setPhone("2345678124");
		getlaptopbyid.setZipcode(345678);
		when(laptoprepository.findById(33)).thenReturn(Optional.of(getlaptopbyid));
		assertEquals(getlaptopbyid,laptopserviceimp.getLaptop(33));
	}
	@Order(3)
	@Test
	public void updatelaptotest() {
		Laptop updatedlaptop=new Laptop();
		updatedlaptop.setId(33);
		updatedlaptop.setName("prathima");
		updatedlaptop.setLocation("arunachalpradesh");
		updatedlaptop.setPhone("2345678124");
		updatedlaptop.setZipcode(345678);
		when(laptoprepository.findById(33)).thenReturn(Optional.of(updatedlaptop));
		updatedlaptop.setLocation("bangalore");
		when(laptoprepository.save(updatedlaptop)).thenReturn(updatedlaptop);
		assertEquals("Record updated Successfully",laptopserviceimp.updateLaptop(updatedlaptop));
	}
	
	@Order(4)
	@Test
	public void deletelaptotest() {
		Laptop deletedlaptop=new Laptop();
		deletedlaptop.setId(33);
		deletedlaptop.setName("prathima");
		deletedlaptop.setLocation("arunachalpradesh");
		deletedlaptop.setPhone("2345678124");
		deletedlaptop.setZipcode(345678);
		when(laptoprepository.getOne(33)).thenReturn(deletedlaptop);
		when(laptoprepository.existsById(deletedlaptop.getId())).thenReturn(false);
		assertFalse(laptoprepository.existsById(deletedlaptop.getId()));
	}
		
	
	}
	
	

