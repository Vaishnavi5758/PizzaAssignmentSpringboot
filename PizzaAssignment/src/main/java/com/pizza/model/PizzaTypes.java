package com.pizza.model;

import org.springframework.context.annotation.Configuration;

import com.pizza.enums.Type;

@Configuration
public class PizzaTypes {
	
	
	public String name;
	public String size;
	public int price;
	public Type type;
    public int count;//stock
    
    
    
    
	public PizzaTypes() {
		super();
	}
	public PizzaTypes(String name, String size, int price, Type type, int count) {
		super();
		this.name = name;
		this.size = size;
		this.price = price;
		this.type = type;
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "PizzaTypes [name=" + name + ", size=" + size + ", price=" + price + ", type=" + type + ", count="
				+ count + "]";
	}
	
	
	
	
	
	

}
