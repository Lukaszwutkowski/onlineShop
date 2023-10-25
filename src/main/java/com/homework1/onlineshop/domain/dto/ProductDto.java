package com.homework1.onlineshop.domain.dto;

import java.math.BigDecimal;

public record ProductDto(Long id, String name, BigDecimal price) {
}
