package main.service;

import main.enums.DiscountType;

public class SimpleDiscounterFactory implements DiscounterFactory {

  @Override
  public Discountable getDiscounter(DiscountType discountType) {
    switch (discountType) {
      case NAVER:
        return new NaverDiscountPolicy();
      case DANAWA:
        return new DanawaDiscountPolicy();
      case FANCAFE:
        return new FancafeDiscountPolicy();
    }

    return Discountable.NONE;
  }
}
