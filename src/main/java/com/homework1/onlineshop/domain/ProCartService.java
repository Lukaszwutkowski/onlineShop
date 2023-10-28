package com.homework1.onlineshop.domain;

import java.math.BigDecimal;
public class ProCartService extends PlusCartService{

    private final BigDecimal discount;
    public ProCartService(CartRepository cartRepository, BigDecimal VAT, BigDecimal discount) {
        super(cartRepository, VAT);
        this.discount = discount;
    }
    @Override
    public BigDecimal getTotalPrice() {
        BigDecimal totalWithVat = super.getTotalPrice();
        BigDecimal discountAmount = totalWithVat.multiply(discount);
        return totalWithVat.subtract(discountAmount);
    }
}
