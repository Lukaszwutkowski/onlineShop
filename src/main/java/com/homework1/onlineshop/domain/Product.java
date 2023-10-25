package com.homework1.onlineshop.domain;

import lombok.Builder;

import java.math.BigDecimal;
@Builder
record Product(Long id,
               String name,
               BigDecimal price) {
}
