package com.example.demo.controller;

import com.example.demo.dto.request.ProductCreationRequest;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String homePage(){
        return "admin/index";
    }
    @GetMapping("/product")
    public String index(Model model){
        List<Product> list = this.productService.getAllProducts();

        model.addAttribute("list", list);

        return "admin/page-list-product";
    }

    @GetMapping ("/add-product")
    public String creatProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);

        return "admin/page-add-product";
    }
    @PostMapping("/add-product")
    public String save(@ModelAttribute("product") Product product){

        if (this.productService.creatProduct(product)) {
            return "redirect:/admin/product";
        } else {
            return "redirect:/admin/add-product";
        }


    }


    @GetMapping("/delete-product/{productId}")
    String deleteProduct(@PathVariable("productId") String productId) {
        if (this.productService.deleteProduct(productId)) {
            return "redirect:/admin/product";
        } else {
            return "redirect:/admin/product";
        }
    }

}
