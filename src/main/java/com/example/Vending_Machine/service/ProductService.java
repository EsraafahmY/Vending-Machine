package com.example.Vending_Machine.service;

import java.util.List;

import com.example.Vending_Machine.model.Product;

public interface ProductService {
	Product save(Product product);

	Product updateProduct(Product product);

	List<Product> getAllProduct();

	Product getProductById(long productId);

	void deleteProduct(long id);
}
