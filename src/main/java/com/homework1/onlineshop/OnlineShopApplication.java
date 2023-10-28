package com.homework1.onlineshop;

import com.homework1.onlineshop.domain.CartService;
import com.homework1.onlineshop.domain.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Random;

@SpringBootApplication
public class OnlineShopApplication implements CommandLineRunner {

    @Autowired
    private CartService cartService;

    public static void main(String[] args) {
        SpringApplication.run(OnlineShopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Random random = new Random();

        for (int i = 0; i < 5; i++){
            BigDecimal price = BigDecimal.valueOf(50 + random.nextInt(251));
            int id = i + 1;
            String name = "Product " + (i + 1);
            cartService.addProductToCart(new ProductDto(id, name, price));
        }
    }
}
