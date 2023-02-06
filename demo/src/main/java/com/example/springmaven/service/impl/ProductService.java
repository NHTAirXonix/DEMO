package com.example.springmaven.service.impl;

import com.example.springmaven.model.Product;
import com.example.springmaven.repository.IProductRepository;
import com.example.springmaven.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Page<Product> findAllByName(String name, Pageable pageable) {
        return iProductRepository.findAllProduct(name, pageable);
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public List<Product> searchByName(Product product) {
        return iProductRepository.searchByName(product.getName());
    }
}