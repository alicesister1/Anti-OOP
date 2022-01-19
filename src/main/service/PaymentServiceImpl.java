package main.service;

import main.domain.Discount;
import main.enums.DiscountType;

public class PaymentServiceImpl implements PaymentService {

  public static final int DEFAULT_DISCOUNT_COUPON_PRICE = 1000;

  /**
   * 실시간 할인 내역
   *
   * @param price
   * @param discountType
   * @return
   */
  public Discount getDiscount(long price, DiscountType discountType) {
    Discountable discountPolicy = getDiscounter(discountType);
    long discountPrice = discountPolicy.getDiscountPrice(price);
    return Discount.of(discountPrice);
  }

  public long payment(long price, DiscountType discountType) {
    Discountable discountPolicy = getDiscounter(discountType);
    long discountPrice = discountPolicy.getDiscountPrice(price);
    return price - discountPrice;
  }

  private Discountable getDiscounter(DiscountType discountType) {
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
