package com.example.PizzaAssignment.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.pizza.controller.PizzaController;
import com.pizza.model.Order;
import com.pizza.service.PizzaOrder;

@SpringBootApplication(scanBasePackages={
"com.example.PizzaAssignment.com", "com.pizza"})
public class PizzaAssignmentApplication {

	@Autowired
	PizzaController pizzaController;
	
	public static void main(String[] args) {
		SpringApplication.run(PizzaAssignmentApplication.class, args);
		//PizzaOrder.calculateTotalOrderCost(pizzaController.getOrder());
	}

	

}
