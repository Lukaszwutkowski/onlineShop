package com.homework1.onlineshop.domain;

import com.homework1.onlineshop.domain.dto.ProductDto;

import java.math.BigDecimal;
import java.util.List;

public interface CartRepository {

    Product addProduct(ProductDto productToAdd);

    BigDecimal getTotalPrice();

    List<ProductDto> getAllProducts();
}
