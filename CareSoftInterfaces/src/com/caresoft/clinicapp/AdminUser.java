package com.caresoft.clinicapp;

import java.util.Date;
import java.util.ArrayList;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin{

//... imports class definition...
    
    // Inside class:
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    
    // TO DO: Implement a constructor that takes an ID and a role
    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!
    
    public AdminUser(Integer id, String role) {
    	super.id = id;
    	this.role = role;
    	securityIncidents = new ArrayList<String>();
    }
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
    public ArrayList<String> reportSecurityIncidents() {
    	return securityIncidents;
    }
    
    // TO DO: Setters & Getters
    public boolean assignPin(int pin) {
    	if(pin > 100000) {
    		System.out.println("pin must be atleast 6 digits");
    		return false;
    	}
    	this.pin = pin;
    	return true;
    }
    
    public boolean accessAuthorized(Integer confirmedAuthID) {
    	if(this.pin == confirmedAuthID) {
    	return true;
    	}
    	authIncident();
    	return false;
    }
    
    public Integer getEmployeeID() {
    	return employeeID;
    }
    
    public void setEmployeeID(Integer employeeID) {
    	this.employeeID = employeeID;
    }

}
