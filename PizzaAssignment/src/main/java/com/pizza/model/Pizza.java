package com.pizza.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.pizza.enums.Crust;
import com.pizza.enums.Sides;
import com.pizza.enums.Toppings;
import com.pizza.enums.Type;
@Configuration
public class Pizza {
	
private PizzaTypes pizzatypes;
private ArrayList<String> extraToppings;
private Crust crust;
private int cheeseCount;
private ArrayList<String> Sides;




public Pizza() {
	super();
}




public Pizza(PizzaTypes pizzatypes, ArrayList<String> extraToppings, Crust crust, int cheeseCount,
		ArrayList<String> sides) {
	super();
	this.pizzatypes = pizzatypes;
	this.extraToppings = extraToppings;
	this.crust = crust;
	this.cheeseCount = cheeseCount;
	Sides = sides;
}




public PizzaTypes getPizzatypes() {
	return pizzatypes;
}




public void setPizzatypes(PizzaTypes pizzatypes) {
	this.pizzatypes = pizzatypes;
}




public ArrayList<String> getExtraToppings() {
	return extraToppings;
}




public void setExtraToppings(ArrayList<String> extraToppings) {
	this.extraToppings = extraToppings;
}




public Crust getCrust() {
	return crust;
}




public void setCrust(Crust crust) {
	this.crust = crust;
}




public int getCheeseCount() {
	return cheeseCount;
}




public void setCheeseCount(int cheeseCount) {
	this.cheeseCount = cheeseCount;
}




public ArrayList<String> getSides() {
	return Sides;
}




public void setSides(ArrayList<String> sides) {
	Sides = sides;
}




@Override
public String toString() {
	return "Pizza [pizzatypes=" + pizzatypes + ", extraToppings=" + extraToppings + ", crust=" + crust
			+ ", cheeseCount=" + cheeseCount + ", Sides=" + Sides + "]";
}












}