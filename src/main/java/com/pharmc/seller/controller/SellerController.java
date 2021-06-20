package com.pharmc.seller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharmc.seller.model.SellerLoginRequest;
import com.pharmc.seller.model.SellerLoginResponse;
import com.pharmc.seller.service.SellerService;

@RestController
@RequestMapping("/seller")
public class SellerController {
	
	@Autowired
	private SellerService service;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody SellerLoginRequest request){
		SellerLoginResponse response = service.checkCredentials(request);
		return new ResponseEntity<SellerLoginResponse>(response, HttpStatus.OK);
	}

}
