package com.pizza.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Vendor {
	
	static Map<String,Integer>  PizzaCount= new HashMap<>();{
		PizzaCount.put("Deluxe Veggie+Regular" , 15);
		PizzaCount.put("Deluxe Veggie+Medium" , 17);
		PizzaCount.put("Cheese and corn+Regular" , 15);
		PizzaCount.put("Nonveg_Supreme+Regular" , 15);
		PizzaCount.put("Nonveg_Supreme+Medium" , 7);
		
		

	
	Scanner input = new Scanner(System.in);
	String name = input.nextLine();
	String size = input.nextLine();
	String count = input.nextLine();
	
	 System.out.println("Enter Pizza name " +name);
	 System.out.println("Enter Pizza size " +size);
	 System.out.println("Enter Pizza count" +count);
	 
	 //Adding to Hashmap
}
	
}
