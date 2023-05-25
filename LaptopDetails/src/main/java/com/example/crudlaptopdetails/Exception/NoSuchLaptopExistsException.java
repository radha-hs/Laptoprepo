package com.example.crudlaptopdetails.Exception;

public class NoSuchLaptopExistsException extends RuntimeException {

		private String message;

		public NoSuchLaptopExistsException() {}

		public NoSuchLaptopExistsException(String msg)
		{
			super(msg);
			this.message = msg;
		}
	}


