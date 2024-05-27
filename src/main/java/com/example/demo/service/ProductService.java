package com.example.demo.service;

import com.example.demo.dto.request.ProductCreationRequest;
import com.example.demo.dto.request.ProductUpdateRequest;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public boolean creatProduct(Product product){

        try {
            this.productRepository.save(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public Product updateUser(String productId, ProductUpdateRequest request) {
        Product product = getProduct(productId);

        product.setName(request.getName());
        product.setBrandName(request.getBrandName());
        product.setQuantity(request.getQuantity());
        product.setDetail(request.getDetail());

        return productRepository.save(product);
    }

    public boolean deleteProduct(String userId){
        try {
            this.productRepository.deleteById(userId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProduct(String id){
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
