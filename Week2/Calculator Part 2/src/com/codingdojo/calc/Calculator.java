package com.codingdojo.calc;

import java.util.ArrayList;

public class Calculator {

	private ArrayList<String> operations;
	private double result;
	
	public Calculator() {
		operations = new ArrayList<String>();
		result = 0.0;
	}
	
	public void performOperation(double operation) {
		this.performOperation(Double.toString(operation));
	}
	
	public void performOperation(String operation) {
		if (!operation.equals("=")) {
			operations.add(operation);
		}
		else {
			while(operations.size() > 1) {
				if(operations.indexOf("*") != -1) {
					int x = operations.indexOf("*");
					operations.set((x-1), Double.toString(Double.parseDouble(operations.get(x-1)) * Double.parseDouble(operations.get(x+1))));
					operations.remove(x+1);
					operations.remove(x);
				}
				else if(operations.indexOf("/") != -1) {
					int x = operations.indexOf("/");
					operations.set((x-1), Double.toString(Double.parseDouble(operations.get(x-1)) / Double.parseDouble(operations.get(x+1))));
					operations.remove(x+1);
					operations.remove(x);
				}
				else if(operations.indexOf("+") != -1) {
					int x = operations.indexOf("+");
					operations.set((x-1), Double.toString(Double.parseDouble(operations.get(x-1)) + Double.parseDouble(operations.get(x+1))));
					operations.remove(x+1);
					operations.remove(x);
				}
				else if(operations.indexOf("-") != -1) {
					int x = operations.indexOf("-");
					operations.set((x-1), Double.toString(Double.parseDouble(operations.get(x-1)) - Double.parseDouble(operations.get(x+1))));
					operations.remove(x+1);
					operations.remove(x);
				}
			}
			result = Double.parseDouble(operations.get(0));
		}
	}

	public double getResults() {
		return result;
	}
}
