package com.codingdojo.calc;

public class TestCalculator {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		
		calc.setOperandOne(10.5);
		calc.setOperation('+');
		calc.setOperandTwo(5.2);
		calc.preformOperation();
		System.out.println(calc.getResult());
	}

}
