package com.practice.tavisca.coffeeBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeBillUtility {
	//Discount and Tax are in % at 10 and 5 respectively
	private static final double  DISCOUNT=0.1;
	private static final double  TAX=0.05;
	
	BufferedReader reader;
	
	public CoffeBillUtility() {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	protected String displayMenu() throws IOException {
		System.out.println("Kindly enter your name.");
		String customerName = reader.readLine();
		System.out.println("Thank you "+customerName+ " . The available coffes are:");
		for (Coffee c : Coffee.values()) {
			System.out.println(c.getName() + " for " + c.getPrice() + " .");
		}
		return customerName;
	}
	
	protected String selectCoffee() throws IOException {
		System.out.println("Please select the Coffee.");
		String coffeType = reader.readLine();
		//As the max no of Retry is not defined keeping it to 0.
		if(!Coffee.isCoffeTypePresent(coffeType)) {
			System.out.println("You have entered a wrong Coffee Type. Please build a new order.");
			System.exit(-1);
		}
		System.out.println(coffeType);
		return coffeType;
		
	}
	
	protected  int selectQuantity() throws IOException {
		System.out.println("Please select quantity.");
		int quantity = 0;
		//As the max no of Retry is not defined keeping it to 0.
		try {
			quantity = Integer.parseInt(reader.readLine());
		} catch (NumberFormatException e) {
			//e.printStackTrace();
			System.out.println("You have entered a wrong quantity. Please build a new order.");
			System.exit(-1);
		}
		System.out.println(quantity);
		return quantity;
	}
	
	protected double calculateCost(String selectedCoffe, int selectedQuantity) {
		double pricePerUnit = Coffee.getPrice(selectedCoffe);
		return selectedQuantity*pricePerUnit;
	}

	protected  double calculateDiscount(double cost) {
		System.out.println("A discout of 10% will be applied for you.");
		return  (cost*DISCOUNT);
	}
	
	protected  double calculateTax(double cost, double discount) {
		return ((cost-discount)*TAX);
	}

	protected double calculateFinalBill(double cost, double discount, double tax) {
		return cost-discount+tax;
	}

}
