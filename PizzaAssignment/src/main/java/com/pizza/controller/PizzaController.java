package com.pizza.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.pizza.enums.Crust;
import com.pizza.enums.Sides;
import com.pizza.enums.Type;
import com.pizza.model.Order;
import com.pizza.model.Pizza;
import com.pizza.model.PizzaTypes;
import com.pizza.model.Vendor;
import com.pizza.service.CalculateCostService;
import com.pizza.service.ShowPlacedOrderService;
import com.pizza.service.VendorService;

@RestController
public class PizzaController {

	@Autowired
	CalculateCostService calculateCostService;

	@Autowired
	VendorService vendorService;

	@Autowired
	ShowPlacedOrderService showPlacedOrderService;

	@GetMapping(value = "/Check")
	public String getMessage() {

		return "Hi vaishnavi here";
	}

	// Show placed order
	@GetMapping(value = "/ShowOrder")
	public ResponseEntity<String> ShowOrder() {

		return new ResponseEntity<>("Your Order is " + showPlacedOrderService.getOrder(), HttpStatus.OK);
	}

	// Calculating Total order cost by OrderId
	@GetMapping(value = "/calculateTotalOrderCost/{pqr}")
	public ResponseEntity<String> calculateTotalOrderCost(@PathVariable("pqr") String OrderId) {

		return new ResponseEntity<>("Your Total Order cost is " + calculateCostService.calculateTotalOrderCost(OrderId)
				+ "  Please, Click confirm order to proceed", HttpStatus.OK);

	}

	// Updated Pizza Count after placing order
	@GetMapping("/orderStatus/{pqr}")
	public ResponseEntity<String> getOrderStatus(@PathVariable("pqr") String OrderId) {
		return new ResponseEntity<>("Customers Order is Confirmed and inventory is updated : Current Pizza Count is :"
				+ calculateCostService.cofirm(OrderId), HttpStatus.OK);

	}

	// Add Pizzas By Vendor
	@RequestMapping(method = RequestMethod.POST, value = "/AddPizzas")
	public ResponseEntity<Void> AddPizzasByVendor(@RequestBody Pizza pizza) {
		System.out.print("pizza:" + pizza);
		System.out.print("pizza:" + pizza.getPizzatypes().getCount());
		if (pizza == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
		vendorService.AddPizzasByVendor(pizza);

		HttpHeaders httpHeaders = new HttpHeaders();

		return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);

	}
	// PizzaNameAndCount.get(pizzaNameAndSize)
}
