package com.example.demoevent.event;

import com.example.demoevent.entity.Customer;

import lombok.Getter;

public class CustomerCreationEvent {

	@Getter
	private final Customer customer;

	public CustomerCreationEvent(Customer customer) {
		this.customer = customer;
	}

}
