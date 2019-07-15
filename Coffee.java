package com.practice.tavisca.coffeeBuilder;

public enum Coffee {
	LATTE("Latte", 60), CAPPUCINO("Cappucino", 70), ESPRESSO("Espresso", 50);
	
	private String name;
	private int price;
	
	private Coffee(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
	
	public static int getPrice(String selectedCoffee) {
		int price=0;
		for (Coffee c : Coffee.values()) {
			if (selectedCoffee.equalsIgnoreCase(c.getName())) {
				price =  c.getPrice();
			}
		}
		return price;
	}
	
	public static boolean isCoffeTypePresent(String selectedCoffee) {
		for (Coffee c : Coffee.values()) {
			if (selectedCoffee.equalsIgnoreCase(c.getName())) {
				return true;
			}
		}
		return false;
	}

}
