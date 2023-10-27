package com.homework1.onlineshop.domain;

import com.homework1.onlineshop.domain.dto.ProductDto;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CartRepositoryImpl implements CartRepository{

    private List<ProductDto> products = new ArrayList<>();
    @Override
    public Product addProduct(ProductDto productToAdd) {
        final Product product = Product.builder()
                .id(productToAdd.id())
                .name(productToAdd.name())
                .price(productToAdd.price())
                .build();

        products.add(productToAdd);
        return product;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return products.stream()
                .map(ProductDto::price)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    @Override
    public List<ProductDto> getAllProducts(){
        return new ArrayList<>(products);
    }
}
