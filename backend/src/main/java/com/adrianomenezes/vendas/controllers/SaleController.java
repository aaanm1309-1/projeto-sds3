package com.adrianomenezes.vendas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrianomenezes.vendas.dto.SaleDTO;
import com.adrianomenezes.vendas.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
//		System.out.println("GEt");
		Page<SaleDTO> list = service.findAll(pageable);
//		System.out.println(list);
		return ResponseEntity.ok(list);
		
	}

}
