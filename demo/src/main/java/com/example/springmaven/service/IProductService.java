package com.example.springmaven.service;

import com.example.springmaven.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    Page<Product> findAllByName(String name, Pageable pageable);

    void save(Product product);

    Optional<Product> findById(Long id);

    void deleteById(Long id);

    List<Product> searchByName(Product product);
}
