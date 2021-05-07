package com.adrianomenezes.vendas.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adrianomenezes.vendas.dto.SaleDTO;
import com.adrianomenezes.vendas.dto.SaleSuccessDTO;
import com.adrianomenezes.vendas.dto.SaleSumDTO;
import com.adrianomenezes.vendas.entities.Sale;
import com.adrianomenezes.vendas.repositories.SaleRepository;
import com.adrianomenezes.vendas.repositories.SellerRepository;

@Service
public class SaleService {
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller(){
//		sellerRepository.findAll();
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller(){
//		sellerRepository.findAll();
		return repository.successGroupedBySeller();
	}
	
	
	
	
}
