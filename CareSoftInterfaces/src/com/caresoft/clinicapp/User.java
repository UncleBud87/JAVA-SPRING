package com.caresoft.clinicapp;

public class User{
    protected Integer id;
    protected int pin;
    

    // TO DO: Getters and setters
	// Implement a constructor that takes an ID
    
    public int getPin() {
    	return pin;
    }
        
    public void setPin(int pin) {
    	this.pin = pin;
    }
    
    public Integer getId() {
    	return id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }

}
