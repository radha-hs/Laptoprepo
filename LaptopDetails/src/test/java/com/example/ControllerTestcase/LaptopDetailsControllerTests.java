package com.example.ControllerTestcase;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.crudlaptopdetails.Controller.LaptopController;
import com.example.crudlaptopdetails.Entity.Laptop;
import com.example.crudlaptopdetails.Service.LaptopServiceImp;

import jakarta.websocket.server.ServerApplicationConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes= {ServerApplicationConfig.class})
public class LaptopDetailsControllerTests {
 
	private MockMvc mockMvc;
  
  @InjectMocks
  
  private LaptopController laptopcontroller;
  @Mock 
  private LaptopServiceImp laptopService;

	
  
  @Test
  public void addlaptopdetailstest() throws Exception {
	  mockMvc = MockMvcBuilders.standaloneSetup(laptopcontroller).build();
	  when(laptopService.addLaptop(any(Laptop.class))).thenReturn("added laptop details");
	  mockMvc.perform(post("/laptop/addlaptop").contentType(MediaType.APPLICATION_JSON)
			  .content( "{\"id\":\"1\" ,\"name\":\"maha\" ,\"location\":\"delhi\",\"phone\":\"9876543256\",\"zipcode\":\"456789\"}"))
	  .andExpect(status().isCreated());
 }
  @Test
  public void getlaptopdetailstest() throws Exception {
	  mockMvc = MockMvcBuilders.standaloneSetup(laptopcontroller).build();
	  Laptop laptop = new Laptop();
	  laptop.setId(90);
	  when(laptopService.getLaptop(90)).thenReturn(new Laptop());
	  mockMvc.perform(get("/laptop/getlaptop/{id}", 90)).andExpect(status().isOk());
	  }
  
  @Test
  public void updatelaptopdetailstest() throws Exception {
	  mockMvc = MockMvcBuilders.standaloneSetup(laptopcontroller).build();
	  when(laptopService.updateLaptop(new Laptop())).thenReturn("updated ");
	  mockMvc.perform(MockMvcRequestBuilders.put("/laptop/updatelaptop/{id}", 1).contentType(MediaType.APPLICATION_JSON)
			  .content("{\"name\":\"maha\" ,\"location\":\"delhi\",\"phone\":\"9876543256\",\"zipcode\":\"456789\"}"))
	  .andExpect(status().isOk());
	  }
  

@Test
public void deletelaptopdetailstest() throws Exception {
	mockMvc = MockMvcBuilders.standaloneSetup(laptopcontroller).build();
	int id = 90;
	when(laptopService.deleteLaptop(id)).thenReturn("deleted");
	mockMvc.perform(delete("/laptop/deletelaptop/{id}", id)).andExpect(status().isOk());
}
}
	
