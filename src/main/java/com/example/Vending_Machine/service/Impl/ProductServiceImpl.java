package com.example.Vending_Machine.service.Impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Vending_Machine.model.Product;
import com.example.Vending_Machine.repos.ProductRepo;
import com.example.Vending_Machine.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepo productRepo;

	@Override
	public Product save(Product product) {
		return productRepo.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		Optional<Product> productobj = this.productRepo.findById(product.getId());

		if(productobj.isPresent()) {
			Product updatedProduct = productobj.get();
			updatedProduct.setId(product.getId());
			updatedProduct.setProductName(product.getProductName());
			updatedProduct.setCost(product.getCost());
			updatedProduct.setAmountAvailability(product.getAmountAvailability());
			updatedProduct.setSellerId(product.getSellerId());
			productRepo.save(updatedProduct);
			return updatedProduct;
		}else {
			System.out.println("Record not found with id : " + product.getId());
		}
        return product;
    }

	@Override
	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(long productId) {
		Optional<Product> productobj = this.productRepo.findById(productId);

		if(productobj.isPresent()) {

			return productobj.get();
		}else {
			System.out.println("Record not found with id : " + productId);
		}
        return productobj.get();
    }

	@Override
	public void deleteProduct(long id) {
		Optional<Product> productObj = this.productRepo.findById(id);

		if(productObj.isPresent()) {
			this.productRepo.delete(productObj.get());
		}else {
			System.out.println("Record not found with id : " + id);
		}
	}
	
}
