package com.example.demoevent.service;


import com.example.demoevent.dto.CustomerResponse;
import com.example.demoevent.entity.Customer;
import com.example.demoevent.event.CustomerCreationEvent;
import com.example.demoevent.repository.CustomerRepository;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public CustomerResponse createCustomer(String name, String email) {
        Customer entityCustomer = Customer.builder()
        .name(name).email(email)
        .build();
        Customer newCustomer = customerRepository.save(entityCustomer);
        
        CustomerCreationEvent event = new CustomerCreationEvent(newCustomer);
        eventPublisher.publishEvent(event);

        return  CustomerResponse.of(newCustomer);
    }
}
