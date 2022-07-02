package com.pizza.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.pizza.enums.Crust;
import com.pizza.enums.Sides;
import com.pizza.enums.Type;
import com.pizza.model.Order;
import com.pizza.model.Pizza;
import com.pizza.model.PizzaTypes;
import com.pizza.service.PizzaOrder;


@RestController
public class PizzaController {
	
	@Autowired
   PizzaOrder pizzaOrder ;
	
	
	@GetMapping(value = "/Check")
	public String getMessage(){
			
		return "Hi vaishnavi here";	
		
	}
	
	
	//Shows placed order
	@GetMapping(value = "/ShowOrder")
	public  void ShowOrder()
	{
		pizzaOrder.getOrder();
	}
	
	//Calculating Total order cost by OrderId
	@GetMapping(value = "/calculateTotalOrderCost/{pqr}")
	public  void calculateTotalOrderCost(@PathVariable("pqr") String OrderId){
	pizzaOrder.calculateTotalOrderCost(OrderId);
		
		
	}
	
	

	


}
