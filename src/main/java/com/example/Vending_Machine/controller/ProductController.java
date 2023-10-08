package com.example.Vending_Machine.controller;

import com.example.Vending_Machine.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.Vending_Machine.model.Product;
import com.example.Vending_Machine.service.ProductService;

import java.util.*;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/product")
	public ResponseEntity<Product> createProduct(@RequestBody ProductRequestDTO productRequestDTO){
		Product product = new Product();
		if(productRequestDTO != null){
			product.setProductName(productRequestDTO.getProductName());
			product.setSellerId(productRequestDTO.getSellerId());
			product.setCost(productRequestDTO.getCost());
			product.setAmountAvailability(productRequestDTO.getAmountAvailability());
		}
		return ResponseEntity.ok().body(this.productService.save(product));
		
	}
	@GetMapping("/product")
	public ResponseEntity<List<Product>> getAllProduct(){
		return ResponseEntity.ok().body(productService.getAllProduct());
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable long id){
		return ResponseEntity.ok().body(productService.getProductById(id));
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody ProductRequestDTO productRequestDTO){
		//if loggined user ==sellerid
		Product product = productService.getProductById(id);
//		product.setId(id);
		if(productRequestDTO.getSellerId().equals(product.getSellerId())){
			product.setProductName(productRequestDTO.getProductName());
			product.setCost(productRequestDTO.getCost());
			product.setAmountAvailability(productRequestDTO.getAmountAvailability());
//			productService.save(product);
		}
		return ResponseEntity.ok().body(this.productService.updateProduct(product));
	}

	@DeleteMapping("/products/{id}")
	public HttpStatus deleteProduct(@PathVariable long id){
		this.productService.deleteProduct(id);
		return HttpStatus.OK;
	}
}
