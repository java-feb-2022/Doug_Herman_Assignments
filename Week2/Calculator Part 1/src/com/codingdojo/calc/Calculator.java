package com.codingdojo.calc;

public class Calculator {
	
	private double operandOne;
	private double operandTwo;
	private char operation;
	private double result;
	
	public Calculator() {
		this(0, 0, '+');
	}
	
	public Calculator(double operandOne, double operandTwo, char operator) {
		this.operandOne = operandOne;
		this.operandTwo = operandTwo;
		this.operation = operator;
	}
	
	public double getOperandOne() {
		return operandOne;
	}
	
	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}
	
	public double getOperandTwo() {
		return operandTwo;
	}
	
	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}
	
	public char getOperation() {
		return operation;
	}
	
	public void setOperation(char operation) {
		this.operation = operation;
	}
	
	public void preformOperation() {
		if(operation == '+')
			result = operandOne + operandTwo;
		else if (operation == '-')
			result = operandOne - operandTwo;
	}

	public double getResult() {
		return result;
	}
	
	
}
