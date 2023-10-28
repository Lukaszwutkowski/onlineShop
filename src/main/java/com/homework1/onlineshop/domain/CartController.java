package com.homework1.onlineshop.domain;

import com.homework1.onlineshop.domain.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    @PostMapping("/products")
    public ResponseEntity<Product> addProductToCart(@RequestBody ProductDto productDto){
        Product product = cartService.addProductToCart(productDto);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/total-price")
    public ResponseEntity<BigDecimal> getTotalPrice(){
        BigDecimal totalPrice = cartService.getTotalPrice();
        return ResponseEntity.ok(totalPrice);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> products = cartService.getAllProducts();
        return ResponseEntity.ok(products);
    }
}