package com.example.springmaven.controller;

import com.example.springmaven.dto.PersonDto;
import com.example.springmaven.model.Person;
import com.example.springmaven.model.Product;
import com.example.springmaven.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("person")
public class PersonController {

    @Autowired
    private IPersonService personService;

    @GetMapping("/list2")
    public String getListPerson(@RequestParam(name = "page", defaultValue = "0") int page,
                                @RequestParam(name = "name", defaultValue = "") String name,
                                Model model) {
        Sort sort = Sort.by("id").ascending();
        Page<PersonDto> personPage = personService.findAllByName(name, PageRequest.of(page, 2, sort));
        Person person = new Person();
        person.setName(name);
        model.addAttribute("person", person);
        model.addAttribute("personList", personPage);
        model.addAttribute("name", name);
        return "/person/listPerson";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("person", new PersonDto());
        return "/person/createPerson";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("product") PersonDto personDto, BindingResult result) {
        if (result.hasErrors()) {
            return "createProduct";
        } else {
            personService.save(personDto);
            return "redirect:/person/list2";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("person", personService.findById(id));
        return "/person/editPerson";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("product") PersonDto personDto, BindingResult result) {
        if (result.hasErrors()) {
            return "editProduct";
        } else {
            personService.save(personDto);
            return "redirect:/list";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        personService.deleteById(id);
        return "redirect:/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("person", personService.findById(id));
        return "/person/viewPerson";
    }
}
