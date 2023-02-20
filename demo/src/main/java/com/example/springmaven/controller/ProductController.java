package com.example.springmaven.controller;

import com.example.springmaven.model.Product;
import com.example.springmaven.service.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller

public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/list")
    public String index(@RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "name", defaultValue = "") String name,
                        Model model) {
        Sort sort = Sort.by("product_id").ascending();
        Page<Product> productList = productService.findAllByName(name, PageRequest.of(page, 2, sort));
        Product product = new Product();
        product.setName(name);
        model.addAttribute("product", product);
        model.addAttribute("productList", productList);
        model.addAttribute("name", name);
        return "/product/listProduct";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/product/createProduct";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "createProduct";
        } else {
            productService.save(product);
            return "redirect:/list";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/product/editProduct";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "editProduct";
        } else {
            productService.save(product);
            return "redirect:/list";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        productService.deleteById(id);
        return "redirect:/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/product/viewProduct";
    }



}
