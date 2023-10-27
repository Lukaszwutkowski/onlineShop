package com.homework1.onlineshop.domain;

import lombok.Builder;

import java.math.BigDecimal;
@Builder
record Product(int id,
               String name,
               BigDecimal price) {
}
