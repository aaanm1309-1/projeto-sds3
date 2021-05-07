package com.adrianomenezes.vendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrianomenezes.vendas.dto.SellerDTO;
import com.adrianomenezes.vendas.services.SellerService;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController {
	
	@Autowired
	private SellerService service;
	
	@GetMapping
	public ResponseEntity<List<SellerDTO>> findAll() {
//		System.out.println("GEt");
		List<SellerDTO> list = service.findAll();
//		System.out.println(list);
		return ResponseEntity.ok(list);
		
	}

}
