package com.homework1.onlineshop.domain;

import com.homework1.onlineshop.domain.dto.ProductDto;

import java.math.BigDecimal;

public interface CartRepository {

    void addProduct(ProductDto productToAdd);

    BigDecimal getTotalPrice();

}
