package com.homework1.onlineshop.domain;

import com.homework1.onlineshop.domain.dto.ProductDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CartServiceTest {

    @InjectMocks
    private CartService cartService;

    @Mock
    private CartRepository cartRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void it_should_add_product_to_cart(){

        //given
        ProductDto product = new ProductDto(1, "Test Product", BigDecimal.valueOf(100));
        Product expectedProduct = Product.builder()
                .id(product.id())
                .name(product.name())
                .price(product.price())
                .build();

        when(cartRepository.addProduct(product)).thenReturn(expectedProduct);

        //when
        Product addedProduct = cartService.addProductToCart(product);

        //then
        assertEquals(expectedProduct.name(), addedProduct.name());
        assertEquals(expectedProduct.price(), addedProduct.price());
        verify(cartRepository).addProduct(product);

    }

    @Test
    public void it_should_return_total_price_of_products_in_cart(){

        //given
        ProductDto product1 = new ProductDto(1, "First product", BigDecimal.valueOf(125));
        ProductDto product2 = new ProductDto(2, "Second product", BigDecimal.valueOf(125));
        BigDecimal expectedTotalPrice = product1.price().add(product2.price());

        when(cartRepository.getTotalPrice()).thenReturn(expectedTotalPrice);

        //when
        BigDecimal actualTotalPrice = cartService.getTotalPrice();

        //then
        assertEquals(expectedTotalPrice, actualTotalPrice);
        verify(cartRepository).getTotalPrice();
    }
}