package com.pharmc.seller.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pharmc.seller.model.SellerLoginRequest;
import com.pharmc.seller.model.SellerLoginResponse;
import com.pharmc.seller.service.SellerService;

@RestController
public class SellerController {
	
	@Autowired
	private SellerService service;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody SellerLoginRequest request){
		SellerLoginResponse response = service.checkCredentials(request);
		return new ResponseEntity<SellerLoginResponse>(response, HttpStatus.OK);
	}
	
	@GetMapping("/{sid}/orders")
	public ResponseEntity<?> getOrders(@PathVariable("sid") long sid){
		return new ResponseEntity<>(service.getOrders(sid),HttpStatus.OK);
	}
    
	@GetMapping("/{sid}/paid/payments")
	public ResponseEntity<?> getPaidPaymentDetails(@PathVariable("sid") long sid){
		return new ResponseEntity<> (service.getPayments(sid, "PAID"),HttpStatus.OK);
	}
	
	@GetMapping("/{sid}/payments")
	public ResponseEntity<?> getNewPaymentDetails(@PathVariable("sid") long sid){
		return new ResponseEntity<> (service.getPayments(sid, "NEW"),HttpStatus.OK);
	}
}
