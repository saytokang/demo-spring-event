package com.example.demoevent.dto;

import com.example.demoevent.entity.Customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerResponse {

	private String name;

	private String email;

	private String token;

	private Long id;

	public static CustomerResponse of(Customer c) {
		return CustomerResponse.builder().id(c.getId()).name(c.getName()).email(c.getEmail()).token(c.getToken())
				.build();
	}

}
