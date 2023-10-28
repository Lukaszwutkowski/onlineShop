package com.homework1.onlineshop.domain;

import com.homework1.onlineshop.domain.dto.ProductDto;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public Product addProductToCart(ProductDto productToAdd) {
        return cartRepository.addProduct(productToAdd);
    }

    public BigDecimal getTotalPrice() {
        return cartRepository.getTotalPrice();
    }

    public List<ProductDto> getAllProducts(){
        return cartRepository.getAllProducts();
    }

    public String getAppLevel() {
        return "start";
    }
    public BigDecimal getVatValue() {
        return BigDecimal.ZERO;
    }

    public BigDecimal getDiscountValue() {
        return BigDecimal.ZERO;
    }

    public BigDecimal getVatAmount() {
        return BigDecimal.ZERO;
    }

    public BigDecimal getDiscountAmount() {
        return BigDecimal.ZERO;
    }
}
