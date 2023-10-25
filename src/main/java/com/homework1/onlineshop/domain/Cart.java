package com.homework1.onlineshop.domain;

import com.homework1.onlineshop.domain.dto.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Cart{

    private final CartRepository cartRepository;

    List<Product> products = new ArrayList<>();
    public Product addProduct(ProductDto productToAdd) {
        final Product product = Product.builder()
                .id(productToAdd.id())
                .name(productToAdd.name())
                .price(productToAdd.price())
                .build();
        cartRepository.addProduct(product);
        products.add(product);

        return product;
    }

    public BigDecimal getTotalPrice() {
        return products.stream()
                .map(Product::price)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
