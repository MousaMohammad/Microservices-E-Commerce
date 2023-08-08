package com.mousatech.productservice.service;


import com.mousatech.productservice.dto.ProductRequest;
import com.mousatech.productservice.dto.ProductResponse;
import com.mousatech.productservice.model.Product;
import com.mousatech.productservice.repository.ProductRepo;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j // This annotation is used to generate logs
public class ProductService {

    @Autowired
    ProductRepo productRepo;
    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepo.save(product);

        log.info("Product {}: created successfully:)", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepo.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
