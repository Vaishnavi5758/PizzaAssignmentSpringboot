package com.pizza.service;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.pizza.enums.Crust;
import com.pizza.enums.Sides;
import com.pizza.enums.Toppings;
import com.pizza.enums.Type;
import com.pizza.model.Order;
import com.pizza.model.Pizza;
import com.pizza.model.PizzaTypes;

@Component
@Service
public class CalculateCostService {
	@Autowired
	PizzaTypes pizzatypes;
	@Autowired
	Pizza pizzas;
	@Autowired
	Order order;

	// Dummy data for ToppingS

	ArrayList<String> nameExtraToppings = new ArrayList<>();
	{
		nameExtraToppings.add("CAPSICUM");
		nameExtraToppings.add("PANEER");
	}
	// Dummy data for Sides
	ArrayList<String> nameSides = new ArrayList<>();
	{
		nameSides.add("COLD_DRINK");
	}

	// Adding dummy data to constructor
	ArrayList<String> listofsides = new ArrayList<String>();
	{
		listofsides.add("COLD_DRINK");
	}

	// Adding data to PizzaType class
	PizzaTypes pizzatype1 = new PizzaTypes("Cheese and corn", "Regular", 150, Type.VEG, 15);
	PizzaTypes pizzatype2 = new PizzaTypes("Deluxe Veggie", "Medium", 170, Type.VEG, 20);
	// Adding data to pizza class

	Pizza pizza1 = new Pizza(pizzatype1, nameExtraToppings, Crust.FRESH_PAN_PIZZA, 1, listofsides);
	Pizza pizza2 = new Pizza(pizzatype2, nameExtraToppings, Crust.FRESH_PAN_PIZZA, 1, listofsides);

	// Adding Pizza to PizzaList
	ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
	{
		pizzaList.add(pizza1);
		pizzaList.add(pizza2);
	}

	Order orders = new Order(pizzaList, listofsides, true, "pqr");

	static Map<String, Order> Order101 = new HashMap<>();
	{

		Order101.put("pqr", orders);

	}

	ArrayList<Pizza> pizza = new ArrayList<>();
	// Name and price of Pizzas
	static Map<String, Integer> vegPizzaTypeMap = new HashMap<>();
	{
		vegPizzaTypeMap.put("Deluxe Veggie+Regular", 150);
		vegPizzaTypeMap.put("Deluxe Veggie+Medium", 170);
		vegPizzaTypeMap.put("Cheese and corn+Regular", 150);

	}

	static Map<String, Integer> NonvegPizzaTypeMap = new HashMap<>();
	{
		NonvegPizzaTypeMap.put("Nonveg_Supreme+Regular", 150);
		NonvegPizzaTypeMap.put("Nonveg_Supreme+Medium", 170);

	}

	// Name and price of topping
	static Map<String, Integer> vegToppingMap = new HashMap<>();
	{

		vegToppingMap.put((Toppings.BLACK_OLIVE).name(), 20);
		vegToppingMap.put((Toppings.CAPSICUM).name(), 25);
		vegToppingMap.put((Toppings.PANEER).name(), 35);
		vegToppingMap.put((Toppings.MUSHROOM).name(), 30);
		vegToppingMap.put((Toppings.FRESH_TOMATO).name(), 10);
	}

	static Map<String, Integer> NonvegToppingMap = new HashMap<>();
	{

		NonvegToppingMap.put((Toppings.CHIKEN_TIKKA).name(), 35);
		NonvegToppingMap.put((Toppings.BARBEQUE_CHICKEN).name(), 45);
		NonvegToppingMap.put((Toppings.GRILLED_CHICKEN).name(), 40);
		NonvegToppingMap.put((Toppings.BLACK_OLIVE).name(), 20);
		NonvegToppingMap.put((Toppings.CAPSICUM).name(), 25);

	}

	static Map<String, Integer> sidesMap = new HashMap<>();
	{
		sidesMap.put((Sides.COLD_DRINK).name(), 55);
		sidesMap.put((Sides.MOUSSE_CAKE).name(), 90);

	}

	Map<String, Integer> ExtraCheeseMap = new HashMap<>();
	{
		ExtraCheeseMap.put("ExtraCheese", 55);
	}

	static Map<String, Integer> PizzaCount = new HashMap<>();
	{
		PizzaCount.put("Deluxe Veggie+Regular", 15);
		PizzaCount.put("Deluxe Veggie+Medium", 20);
		PizzaCount.put("Cheese and corn+Regular", 15);
		PizzaCount.put("Nonveg_Supreme+Regular", 15);
		PizzaCount.put("Nonveg_Supreme+Medium", 7);

	}

	// calculate Total Order Cost of order
	public int calculateTotalOrderCost(String OrderId) {

		int cost = 0;


		// Fetching Order by orderId from HashMap
		Order order101 = Order101.get(OrderId);
		ArrayList<Pizza> pizzaList = order101.getPizzas();

		for (Pizza pizza : pizzaList) {
			String pizzaName = pizza.getPizzatypes().getName() + "+" + pizza.getPizzatypes().getSize();
			ArrayList<String> ToppingNames = pizza.getExtraToppings();

			int pizzaCount = pizza.getPizzatypes().getCount();
			ArrayList<String> Sides = pizza.getSides();
			Crust crust = pizza.getCrust();
			int crustLength = crust.values().length;

			try {
				if (crustLength > 1) {

				}
			} catch (Exception e) {
				System.out.print("Select only 1 crust");
			}

			if (pizza.getPizzatypes().getType().equals(Type.VEG)) {
				// System.out.print(" vegPizzaTypeMap.get(pizzaName)" +
				// pizzaName);
				cost += vegPizzaTypeMap.get(pizzaName);

				for (int i = 0; i < ToppingNames.size(); i++) {
					cost += vegToppingMap.get(ToppingNames.get(i));
				}

			} else {

				cost += NonvegPizzaTypeMap.get(pizzaName);
				if (ToppingNames.size() > 1) {

					return 0;
				} else {
					for (int i = 0; i < ToppingNames.size(); i++) {
						cost += NonvegToppingMap.get(ToppingNames.get(i));
					}
				}

			}

			for (int i = 0; i < Sides.size(); i++) {
				cost += sidesMap.get(Sides.get(i));
			}

		}

		return cost;

	}

	

	// After Clicking Confirm by client, inventory will be changed and
	// count will be decreased.
	public int cofirm(String OrderId) {

		int PizzaCountVendor = 0;

		Order order = new Order(pizzaList, listofsides, true, "pqr");
		if (order.isConfirmOrder()) {
			Order order101 = Order101.get(OrderId);
			ArrayList<Pizza> pizzaList = order101.getPizzas();

			for (Pizza pizza : pizzaList) {
				String pizzaName = pizza.getPizzatypes().getName() + "+" + pizza.getPizzatypes().getSize();

				// Fetching pizza count by pizza name from Hashmap
				PizzaCountVendor = PizzaCount.get(pizzaName);

				// Decreasing count of pizza in inventory after placing order
				PizzaCountVendor = PizzaCountVendor - 1;

				// int PizzaCount = pizza.getPizzatypes().getCount();
				// PizzaCount = PizzaCount - 1;
				// System.out.println(" PizzaCount" + PizzaCount);

			}
		}
		return PizzaCountVendor;
	}
}
