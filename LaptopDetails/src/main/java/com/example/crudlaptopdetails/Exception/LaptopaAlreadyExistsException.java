package com.example.crudlaptopdetails.Exception;

public class LaptopaAlreadyExistsException extends RuntimeException {

	
	
		private String errorMessage;
		public LaptopaAlreadyExistsException() {
			
		}
		public LaptopaAlreadyExistsException(String errorMessage) {
			super(errorMessage);
			this.errorMessage = errorMessage;
			}
	}


