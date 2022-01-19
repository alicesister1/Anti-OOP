package main.service;

import main.enums.DiscountType;

/**
 * 할인정책 생성
 */
public interface DiscounterFactory {

  Discountable getDiscounter(DiscountType discountType);
}

