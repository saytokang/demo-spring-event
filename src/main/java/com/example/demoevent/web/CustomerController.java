package com.example.demoevent.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoevent.dto.CustomerResponse;
import com.example.demoevent.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/new")
	public ResponseEntity<?> newCustomer(@RequestParam String name, @RequestParam String email) {
		CustomerResponse customer = customerService.createCustomer(name, email);
		return ResponseEntity.ok().body(customer);
	}

}
