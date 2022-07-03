package com.pizza.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.pizza.enums.Crust;
import com.pizza.enums.Toppings;
import com.pizza.enums.Type;
import com.pizza.model.Order;
import com.pizza.model.Pizza;
import com.pizza.model.PizzaTypes;
import com.pizza.model.Vendor;

@Component
@Service
public class ShowPlacedOrderService {
	
	
public Order getOrder(){
		
		//Dummy data for Toppings
		ArrayList<String> nameExtraToppings=new ArrayList<>();
		nameExtraToppings.add("CAPSICUM");
		nameExtraToppings.add("PANEER");
		
		//Dummy data for Sides
		ArrayList<String> nameSides=new ArrayList<>();
		nameSides.add("COLD_DRINK");	
		
		
		//Adding dummy data to constructor
		ArrayList<String> listofsides = new ArrayList<String>();
		listofsides.add("COLD_DRINK");
		
		
		//Adding data to PizzaType class
		PizzaTypes pizzatype1 = new PizzaTypes("Cheese and corn", "Regular",150, Type.VEG, 15);
		PizzaTypes pizzatype2 = new PizzaTypes("Deluxe Veggie", "Medium",170, Type.VEG, 20);
		//Adding data to pizza class
		
		
		Pizza pizza1 = new Pizza(pizzatype1,nameExtraToppings,Crust.FRESH_PAN_PIZZA, 1,listofsides);
		Pizza pizza2 = new Pizza(pizzatype2,nameExtraToppings,Crust.FRESH_PAN_PIZZA, 1,listofsides);
		
		
		//Adding Pizza to PizzaList
		ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
		pizzaList.add(pizza1);
		pizzaList.add(pizza2);
	
		
	//	System.out.print("pizzaList is" +pizzaList);
		//Upcoming Order with data
		Order order = new Order( pizzaList, listofsides,true, "pqr");
		
		System.out.print("order is" +order);
		//System.out.print("order is" +order );
		
		return order;
}
	
}
