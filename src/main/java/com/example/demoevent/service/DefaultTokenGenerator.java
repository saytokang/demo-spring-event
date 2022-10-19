package com.example.demoevent.service;

import java.util.UUID;

import com.example.demoevent.entity.Customer;
import com.example.demoevent.repository.CustomerRepository;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class DefaultTokenGenerator implements TokenGenerator {

	private final CustomerRepository customerRepository;

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void generateToken(Customer customer) {
		log.info("== Token Generated : {}, token: {}", customer.getName(), UUID.randomUUID().toString());
		String token = UUID.randomUUID().toString();
		customer.withToken(token);
		customerRepository.save(customer);
	}

}
