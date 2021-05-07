package com.adrianomenezes.vendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adrianomenezes.vendas.dto.SaleSuccessDTO;
import com.adrianomenezes.vendas.dto.SaleSumDTO;
import com.adrianomenezes.vendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	@Query("SELECT new com.adrianomenezes.vendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount))"
			+ " FROM Sale AS obj "
			+ " GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();

	@Query("SELECT new " 
			+ " com.adrianomenezes.vendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited) , SUM(obj.deals))"
			+ " FROM Sale AS obj "
			+ " GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();

}
