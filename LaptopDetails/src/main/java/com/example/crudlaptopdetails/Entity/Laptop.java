package com.example.crudlaptopdetails.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
@Entity
@Table(name="Laptops")
public class Laptop {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@NotNull(message="id can't be null")
    private int id;
	
	@Column(name="Name",nullable=false)
	@NotEmpty(message="name is mandatory")
	@Pattern(regexp=("[A-Za-z]*"),message="special characters not allowed")
	@Size(min=3,message="length of name should be minimum 3")
    private String name;
	
	@Column(name="Location",nullable=false)
	@Size(min=4)
	@Pattern(regexp=("[A-Za-z]*"),message="special characters are not allowed")
    private String location;
	
	@NotNull(message="phone number should not be null")
	@NotBlank(message="phone number should not be blank")
	@Pattern(regexp="[0-9]{10}",message="please enter valid number")
    private String phone;
	
	@NotNull(message="enter the valid zipcode")
	
    private int zipcode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public Laptop(@NotNull(message = "id can't be null") int id,
			@NotEmpty(message = "name is mandatory") @Pattern(regexp = "[A-Za-z]*", message = "special characters not allowed") @Size(min = 3, message = "length of name should be minimum 3") String name,
			@Size(min = 4) @Pattern(regexp = "[A-Za-z]*", message = "special characters are not allowed") String location,
			@NotNull(message = "phone number should not be null") @NotBlank(message = "phone number should not be blank") @Pattern(regexp = "[0-9]{10}", message = "please enter valid number") String phone,
			@NotNull(message = "enter the valid zipcode") int zipcode) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.phone = phone;
		this.zipcode = zipcode;
	}

	public Laptop() {
		super();
	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", name=" + name + ", location=" + location + ", phone=" + phone + ", zipcode="
				+ zipcode + "]";
	}

	
	
}



