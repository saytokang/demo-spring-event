package com.example.demoevent.event;

import com.example.demoevent.service.TokenGenerator;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class CustomerCreationEventListener {

	private final TokenGenerator tokenGenerator;

	@TransactionalEventListener
	public void onEvent(CustomerCreationEvent event) {
		log.info("== Event Received : {}", event);
		tokenGenerator.generateToken(event.getCustomer());
	}

}
