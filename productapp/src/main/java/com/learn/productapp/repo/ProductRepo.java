package com.learn.productapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.productapp.model.Product;

public interface ProductRepo extends JpaRepository<Product,Long> {

}
