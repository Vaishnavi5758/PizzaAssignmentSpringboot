package com.pizza.model;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.context.annotation.Configuration;

import com.pizza.enums.Sides;

@Configuration
public class Vendor {
	private String name;
	private String size;
	private int count;
	
	
	
	public Vendor() {
		super();
	}
	public Vendor(String name, String size, int count) {
		super();
		this.name = name;
		this.size = size;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Vendor [name=" + name + ", size=" + size + ", count=" + count + "]";
	}
	
	
	
	
	

}
