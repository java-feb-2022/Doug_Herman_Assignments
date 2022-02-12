package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser {
	
	private String role;
	private ArrayList<String> securityIncidents;

	public AdminUser(int id, String role) {
		super(id);
		this.role = role;
		securityIncidents = new ArrayList<String>();
	}

	@Override
	public boolean assignPin(int pin) {
		if (pin > 99999) {
			this.pin = pin;
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(this.id == confirmedAuthID)
			return true;
		else {
			authIncident();
			return false;
		}
	}

	@Override
	public ArrayList<String> reportSecurityIncidents() {
		return securityIncidents;
	}

	public void newIncident(String notes) {
		String report = String.format("Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
				new Date(), this.id, notes);
		securityIncidents.add(report);
	}
	
	public void authIncident() {
		String report = String.format("Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
				new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER");
		securityIncidents.add(report);
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
