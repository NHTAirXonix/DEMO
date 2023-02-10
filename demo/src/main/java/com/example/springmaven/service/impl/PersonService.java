package com.example.springmaven.service.impl;

import com.example.springmaven.dto.PersonDto;
import com.example.springmaven.model.Person;
import com.example.springmaven.repository.IPersonRepository;
import com.example.springmaven.service.IPersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private IPersonRepository personRepository;

    @Override
    public Page<PersonDto> findAllByName(String name, Pageable pageable) {
        Page<Person> personPage = personRepository.findAllPerson(name,pageable);

        List<PersonDto> personDTOs = personPage.getContent()
                .stream()
                .map(p -> new PersonDto( p.getId(), p.getName(),p.getPosition()))
                .collect(Collectors.toList());
        return new PageImpl<PersonDto>(personDTOs, personPage.getPageable(), personPage.getTotalElements());
    }

    @Override
    public void save(PersonDto personDto) {
        Person person = new Person();
        BeanUtils.copyProperties(personDto, person);
        personRepository.save(person);
    }

    @Override
    public PersonDto findById(Integer id) {
        Person person = personRepository.findById(id).get();
        PersonDto personDtoReturn = new PersonDto();
        BeanUtils.copyProperties(person,personDtoReturn);
        return personDtoReturn;
    }

    @Override
    public void deleteById(Integer id) {
        personRepository.deleteById(id);
    }


}