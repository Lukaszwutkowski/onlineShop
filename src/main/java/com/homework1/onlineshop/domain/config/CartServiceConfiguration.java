package com.homework1.onlineshop.domain.config;

import com.homework1.onlineshop.domain.CartRepository;
import com.homework1.onlineshop.domain.CartService;
import com.homework1.onlineshop.domain.PlusCartService;
import com.homework1.onlineshop.domain.ProCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.math.BigDecimal;

@Configuration
public class CartServiceConfiguration {

    private final String appLevel;
    private final CartRepository cartRepository;
    private final BigDecimal vatValue;
    private final BigDecimal discountValue;

    @Autowired
    public CartServiceConfiguration(
            @Value("${app.level}") String appLevel,
            CartRepository cartRepository,
            @Value("${app.vat}") BigDecimal vatValue,
            @Value("${app.discount}") BigDecimal discountValue) {
        this.appLevel = appLevel;
        this.cartRepository = cartRepository;
        this.vatValue = vatValue;
        this.discountValue = discountValue;
    }
    @Bean
    @Primary
    public CartService cartService() {
        if ("start".equalsIgnoreCase(appLevel)) {
            return new CartService(cartRepository);
        } else if ("plus".equalsIgnoreCase(appLevel)) {
            return new PlusCartService(cartRepository, vatValue);
        } else if ("pro".equalsIgnoreCase(appLevel)) {
            return new ProCartService(cartRepository, vatValue, discountValue);
        } else {
            throw new IllegalArgumentException("Unknown app level: " + appLevel);
        }
    }
}
