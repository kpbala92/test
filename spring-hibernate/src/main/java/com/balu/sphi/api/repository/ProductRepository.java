package com.balu.sphi.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.balu.sphi.api.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	Optional<Product> findByName(String name);

}
