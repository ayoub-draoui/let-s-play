package com.adraoui.webstore.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.adraoui.webstore.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findByOwnerId(String ownerId);

    
}