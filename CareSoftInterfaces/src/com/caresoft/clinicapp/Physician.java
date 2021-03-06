package com.caresoft.clinicapp;
import java.sql.Date;
import java.util.ArrayList;

public class Physician extends User implements HIPAACompliantUser {
    
    // Inside class:    
    private ArrayList<String> patientNotes;
	
    public Physician(int id) {
    	super.id = id;
    }
    
    
    // TO DO: Constructor that takes an ID
    // TO DO: Implement HIPAACompliantUser!
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
    
    public boolean assignPin(int pin) {
    	if (pin < 1000 && pin > 9999) {
    		System.out.println("pin must be 4 digits");
    		return false;
    	}
    	this.pin = pin;
    	return true;
    	
    }
    
    public boolean accessAuthorized(Integer confirmedAuthID) {
    	if(this.pin == confirmedAuthID) {
    		return true;
    	}
    	return false;
    }
	
    // TO DO: Setters & Getters

}
