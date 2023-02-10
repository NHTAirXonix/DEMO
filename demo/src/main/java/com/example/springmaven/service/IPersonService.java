package com.example.springmaven.service;

import com.example.springmaven.dto.PersonDto;
import com.example.springmaven.model.Person;
import com.example.springmaven.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPersonService {

    Page<PersonDto> findAllByName(String name, Pageable pageable);

    void save(PersonDto personDto);

    PersonDto findById(Integer id);

    void deleteById(Integer id);
}
