package com.example.demo.controller;

import com.example.demo.dto.request.ProductCreationRequest;
import com.example.demo.dto.request.ProductUpdateRequest;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
//    Product creatProduct(@RequestBody ProductCreationRequest request) {
//        return productService.creatProduct(request);
//    }

    @GetMapping
    List<Product> getAllProduct(){
        return productService.getAllProducts();
    }


    @GetMapping("/{productId}")
    Product getProduct(@PathVariable("productId") String productId) {
        return productService.getProduct(productId);
    }

    @PutMapping("/{productId}")
    Product updateProduct(@PathVariable String productId, @RequestBody ProductUpdateRequest request) {
        return productService.updateUser(productId, request);
    }




}
