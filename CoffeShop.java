package com.practice.tavisca.coffeeBuilder;

import java.io.IOException;

public class CoffeShop {

	public static void main(String[] args) throws IOException {
		CoffeBillUtility coffeBillUtility = new CoffeBillUtility();

		System.out.println("Welcome to Coffee");

		String customerName = coffeBillUtility.displayMenu();

		String selectedCoffe = coffeBillUtility.selectCoffee();

		int selectedQuantity = coffeBillUtility.selectQuantity();

		double cost = coffeBillUtility.calculateCost(selectedCoffe, selectedQuantity);

		double discount = coffeBillUtility.calculateDiscount(cost);

		double tax = coffeBillUtility.calculateTax(cost, discount);

		double finalAmount = coffeBillUtility.calculateFinalBill(cost, discount, tax);

		System.out.println("Cost is Rs " + cost);
		System.out.println("Discount on bill is " + discount );
		System.out.println("Tax on the purchase is " + tax);
		System.out.println("Thank you " + customerName + " your final Bill is Rs " + finalAmount);

	}

}
