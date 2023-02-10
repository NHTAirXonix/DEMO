package com.example.springmaven.repository;

import com.example.springmaven.model.Person;
import com.example.springmaven.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface IPersonRepository extends JpaRepository<Person,Integer> {

    @Query(value = "select * from person where name like %:name%", nativeQuery = true)
    Page<Person> findAllPerson(@Param("name") String name, Pageable pageable);}

