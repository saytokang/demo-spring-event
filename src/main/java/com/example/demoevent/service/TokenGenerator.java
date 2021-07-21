package com.example.demoevent.service;

import com.example.demoevent.entity.Customer;

public interface TokenGenerator {

    public void generateToken(Customer customer);
    
}
