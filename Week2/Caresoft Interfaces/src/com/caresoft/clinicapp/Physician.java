package com.caresoft.clinicapp;

import java.sql.Date;
import java.util.ArrayList;

public class Physician extends User implements HIPAACompliantUser {
	
	private ArrayList<String> patientNotes;
	
	public Physician(int id) {
		super(id);
	}

	@Override
	public boolean assignPin(int pin) {
		if (pin > 999 && pin < 10000) {
			this.pin = pin;
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if (this.id == confirmedAuthID)
			return true;
		else
			return false;
	}
	
	public void newPatientNotes(String notes, String patientName, Date date) {
		String report = String.format("Datetime Submitted: %s \n", date);
		report += String.format("Reported By: %s \n", this.id);
		report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
	}

}
