package com.pizza.model;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.context.annotation.Configuration;

import com.pizza.enums.Sides;

@Configuration
public class Order {
	
	private ArrayList<Pizza> pizzas;
	private ArrayList<String> sides;
	private boolean isConfirmOrder;
	private String OrderId;
	public Order(ArrayList<Pizza> pizzas, ArrayList<String> sides, boolean isConfirmOrder, String orderId) {
		super();
		this.pizzas = pizzas;
		this.sides = sides;
		this.isConfirmOrder = isConfirmOrder;
		OrderId = orderId;
	}
	
	
	
	public Order() {
		super();
	}



	public ArrayList<Pizza> getPizzas() {
		return pizzas;
	}
	public void setPizzas(ArrayList<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	public ArrayList<String> getSides() {
		return sides;
	}
	public void setSides(ArrayList<String> sides) {
		this.sides = sides;
	}
	public boolean isConfirmOrder() {
		return isConfirmOrder;
	}
	public void setConfirmOrder(boolean isConfirmOrder) {
		this.isConfirmOrder = isConfirmOrder;
	}
	public String getOrderId() {
		return OrderId;
	}
	public void setOrderId(String orderId) {
		OrderId = orderId;
	}
	@Override
	public String toString() {
		return "Order [pizzas=" + pizzas + ", sides=" + sides + ", isConfirmOrder=" + isConfirmOrder + ", OrderId="
				+ OrderId + "]";
	}
	
	
	
	
	

}
