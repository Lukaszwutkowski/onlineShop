package com.homework1.onlineshop.domain;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
public class PlusCartService extends CartService{

    private final BigDecimal VAT;
    public PlusCartService(CartRepository cartRepository, BigDecimal VAT) {
        super(cartRepository);
        this.VAT = VAT;
    }

    @Override
    public BigDecimal getTotalPrice() {
        BigDecimal originalTotal = super.getTotalPrice();
        BigDecimal vatAmount = originalTotal.multiply(VAT);
        return originalTotal.add(vatAmount);
    }
}
