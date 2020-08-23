package com.balu.sphi.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balu.sphi.api.entity.Product;
import com.balu.sphi.api.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product saveProduct(Product product) {
		
		return productRepository.save(product);
	}
	public List<Product> saveProducts(List<Product> products){
		
		return productRepository.saveAll(products);
	}
	
	public List<Product> getProducts(){
		
		return productRepository.findAll();
	}
	public Product getProductById(int id){
		
		return productRepository.findById(id).orElse(null);
	}
	
	public Product getProductByName(String name){
		
		return productRepository.findByName(name).orElse(null);
	}
	
	public String deleteProduct(int id) {
		productRepository.deleteById(id);
		return "product removed.."+id;
	}
	
	public Product updateProduct(Product product) {
		
		Product existingProduct = productRepository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		return productRepository.save(existingProduct);
		
	}
	
}
