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
public class PizzaOrder {
	@Autowired
	PizzaTypes pizzatypes ;
	@Autowired
    Pizza pizzas;
	@Autowired
    Order order ;
   
       //Dummy data for ToppingS
    
    ArrayList<String> nameExtraToppings = new ArrayList<>();{
    nameExtraToppings.add("CAPSICUM");
    nameExtraToppings.add("PANEER");
    }
  		//Dummy data for Sides
  		ArrayList<String> nameSides=new ArrayList<>();
  		{
  		nameSides.add("COLD_DRINK");	
  		}
  		
  		//Adding dummy data to constructor
  		ArrayList<String> listofsides = new ArrayList<String>();{
  		listofsides.add("COLD_DRINK");
  		}
  		
  		//Adding data to PizzaType class
  		PizzaTypes pizzatype = new PizzaTypes("Cheese and corn", "Regular",150, Type.VEG, 15);
  		//Adding data to pizza class
  		
  		
  		Pizza pizza1 = new Pizza(pizzatype,nameExtraToppings,Crust.FRESH_PAN_PIZZA, true,listofsides);
  		
  		
  		//Adding Pizza to PizzaList
  		ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();{
  		pizzaList.add(pizza1);
  		}
  		
  		Order orders = new Order( pizzaList, listofsides,true, "pqr");
    
  		
  		static Map<String,Order>  Order101 = new HashMap<>();{
  			
  			Order101.put("pqr",orders);
  			
  			
  		}
  		
  		
	ArrayList<Pizza> pizza = new ArrayList<>();
	
	static Map<String,Integer>  vegPizzaTypeMap= new HashMap<>();{
		vegPizzaTypeMap.put("Deluxe Veggie+Regular" , 150);
		vegPizzaTypeMap.put("Deluxe Veggie+Medium" , 170);
		vegPizzaTypeMap.put("Cheese and corn+Regular" , 150);
		
	}
	
	static Map<String,Integer>  NonvegPizzaTypeMap= new HashMap<>();{
		NonvegPizzaTypeMap.put("Nonveg_Supreme+Regular" , 150);
		NonvegPizzaTypeMap.put("Nonveg_Supreme+Medium" , 170);
		
	}
	
	
	static Map<String,Integer>  vegToppingMap= new HashMap<>();{
	
	vegToppingMap.put((Toppings.BLACK_OLIVE).name() , 20);
	vegToppingMap.put((Toppings.CAPSICUM).name(), 25);
	vegToppingMap.put((Toppings.PANEER).name(), 35);
	vegToppingMap.put((Toppings.MUSHROOM).name(), 30);
	vegToppingMap.put((Toppings.FRESH_TOMATO).name(), 10);
	}
	
	static Map<String,Integer>  NonvegToppingMap= new HashMap<>();{
		
	NonvegToppingMap.put((Toppings.CHIKEN_TIKKA).name() , 35);
	NonvegToppingMap.put((Toppings.BARBEQUE_CHICKEN).name(), 45);
	NonvegToppingMap.put((Toppings.GRILLED_CHICKEN).name(), 40);
	NonvegToppingMap.put((Toppings.BLACK_OLIVE).name() , 20);
	NonvegToppingMap.put((Toppings.CAPSICUM).name(), 25);
	
	}
	
	static Map<String, Integer> sidesMap = new HashMap<>();{
		sidesMap.put((Sides.COLD_DRINK).name(), 55);
		sidesMap.put((Sides.MOUSSE_CAKE).name(), 90);
		
	}
	
	Map<String, Integer> ExtraCheeseMap = new HashMap<>();{
		ExtraCheeseMap.put("ExtraCheese", 55);
	}
	
	
	
	
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
		PizzaTypes pizzatype = new PizzaTypes("Cheese and corn", "Regular",150, Type.VEG, 15);
		//Adding data to pizza class
		
		
		Pizza pizza1 = new Pizza(pizzatype,nameExtraToppings,Crust.FRESH_PAN_PIZZA, true,listofsides);
		
		
		//Adding Pizza to PizzaList
		ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
		pizzaList.add(pizza1);
	
		
	//	System.out.print("pizzaList is" +pizzaList);
		//Upcoming Order with data
		Order order = new Order( pizzaList, listofsides,true, "pqr");
		
		System.out.print("order is" +order);
		//System.out.print("order is" +order );
		
		return order;
}
	
	
	
	public  int calculateTotalOrderCost(String OrderId){
		
	    int cost = 0;
	    
	   
	    Order oredr101 = Order101.get(OrderId);
		ArrayList<Pizza> pizzaList = oredr101.getPizzas();
	    
		
		
		for(Pizza pizza: pizzaList){
			String pizzaName = pizza.getPizzatypes().getName()+ "+" +pizza.getPizzatypes().getSize() ;
			ArrayList<String> ToppingNames = pizza.getExtraToppings();
			
			
			int pizzaCount =pizza.getPizzatypes().getCount();
			ArrayList<String> Sides = pizza.getSides();
			Crust crust = pizza.getCrust();
			int crustLength = crust.values().length;
			
			
			try{
				if(crustLength > 1){
					
				}
				}catch(Exception e){
					System.out.print("Select only 1 crust");
				}

			
			if(pizza.getPizzatypes().getType().equals(Type.VEG))
			{
				//System.out.print(" vegPizzaTypeMap.get(pizzaName)" + pizzaName);
			cost +=  vegPizzaTypeMap.get(pizzaName);
			
			
			
			for(int i=0; i<ToppingNames.size(); i++){
				
		
				
				cost += vegToppingMap.get(ToppingNames.get(i));
				System.out.println(" cost)" + cost);
			
			}
			
			}else{
				
				cost +=  NonvegPizzaTypeMap.get(pizzaName);
				if(ToppingNames.size() > 1 ){
					System.out.println("abc");
					return 0;
				}else{
				for(int i=0; i<ToppingNames.size(); i++){
					cost += NonvegToppingMap.get(ToppingNames.get(i));
				}
				}
				
			}
			
			for(int i = 0 ; i<Sides.size(); i++)
			{
				cost += sidesMap.get(Sides.get(i));
			}
			
			
				
		System.out.println("Your order cost is : " +cost +" Click confirm to place your order");
		 
		
			
		if(order.isConfirmOrder()){
			System.out.println("Your order has been confirmed and total amount of your order is : " +cost +" , Proceed for payment");
			
			int PizzaCountVendor = Vendor.PizzaCount.get(pizzaName);
			PizzaCountVendor =	PizzaCountVendor-1;
			System.out.println(" PizzaCountVendor" + PizzaCountVendor);
			
			
			int PizzaCount = pizza.getPizzatypes().getCount();
			PizzaCount = pizzaCount - 1;
			System.out.println(" PizzaCount" + PizzaCount);
			
		}
		}
		
		
		
		
		
		return cost;
		
		
		
		
		
	}
		
	

}
