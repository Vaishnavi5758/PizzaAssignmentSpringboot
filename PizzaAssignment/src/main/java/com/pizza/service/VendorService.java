package com.pizza.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.pizza.enums.Toppings;
import com.pizza.model.Pizza;
import com.pizza.model.Vendor;

@Component
public class VendorService {
	
	 
	 //Adding Pizzas to Hashmap
	static Map<String,Integer>  PizzaNameAndCount= new HashMap<>();{
		PizzaNameAndCount.put("Deluxe Veggie+Regular" , 15);
		PizzaNameAndCount.put("Deluxe Veggie+Medium" , 20);
		PizzaNameAndCount.put("Cheese and corn+Regular" , 15);
		PizzaNameAndCount.put("Nonveg_Supreme+Regular" , 15);
		PizzaNameAndCount.put("Nonveg_Supreme+Medium" , 7);
		
	}
	//Adding Toppings to Hashmap
	static Map<String,Integer>  ToppingNameAndCount= new HashMap<>();{
		
		ToppingNameAndCount.put((Toppings.BLACK_OLIVE).name() , 2);
		ToppingNameAndCount.put((Toppings.CAPSICUM).name(), 2);
		ToppingNameAndCount.put((Toppings.PANEER).name(), 3);
		ToppingNameAndCount.put((Toppings.MUSHROOM).name(), 3);
		ToppingNameAndCount.put((Toppings.FRESH_TOMATO).name(), 1);
		ToppingNameAndCount.put((Toppings.CHIKEN_TIKKA).name() , 5);
		ToppingNameAndCount.put((Toppings.BARBEQUE_CHICKEN).name(), 5);
		}

	
	
	//Add Pizzas to hashmap By Vendor
	public void AddPizzasByVendor(Pizza pizza) {
		String pizzaName = pizza.getPizzatypes().getName();
		String pizzaSize = pizza.getPizzatypes().getSize();
       int PizzaCountGivenByVendor = pizza.getPizzatypes().getCount();
     
       
       String pizzaNameAndSize = pizzaName+"+"+pizzaSize ;
       System.out.println("pizzaNameSize: " +pizzaNameAndSize);
		
       if(PizzaNameAndCount.containsKey(pizzaNameAndSize)) {
       	int TotalCount = PizzaNameAndCount.get(pizzaNameAndSize) + PizzaCountGivenByVendor ;
     
       	 System.out.println("Pizzas are added and inventory is updated : Current Pizza Count is :" +TotalCount);
       	PizzaNameAndCount.put(pizzaNameAndSize, TotalCount);
       	System.out.println("Pizzas are added and inventory is updated : Current Pizza Count is :" +PizzaNameAndCount.get(pizzaNameAndSize));
       	 
	}
       
	}

        
	}
	

