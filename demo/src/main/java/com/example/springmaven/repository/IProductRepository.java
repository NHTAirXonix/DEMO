package com.example.springmaven.repository;

import com.example.springmaven.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select * from product where product_status = '' and product_name like %:name%", nativeQuery = true)
    Page<Product> findAllProduct(@Param("name") String name, Pageable pageable);

    @Modifying
    @Query(value = "update  product set product_status = '1' where product_id = :id", nativeQuery = true)
    void deleteById(@Param("id") String id);

    @Query(value = "select * from product where product_name  like %:name% ", nativeQuery = true)
    List<Product> searchByName(@Param("name") String name);
}
