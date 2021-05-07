package com.adrianomenezes.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adrianomenezes.vendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long>{

}
