package main.service;

import main.domain.Discount;
import main.enums.DiscountPolicy;

public class PaymentServiceImpl {

  /**
   * 실시간 할인 내역
   *
   * @param price
   * @param discountCode
   * @return
   */
  public Discount getDiscount(long price, String discountCode) {
    Discountable discountPolicy = getDiscounter(discountCode);
    long discountPrice = discountPolicy.getDiscountPrice(price);
    return Discount.of(discountPrice);
  }

  /**
   * 할인이 적용된 결제금액
   *
   * @param price
   * @param discountCode
   * @return
   */
  public long payment(long price, String discountCode) {
    Discountable discountPolicy = getDiscounter(discountCode);
    long discountPrice = discountPolicy.getDiscountPrice(price);
    return price - discountPrice;
  }

  private Discountable getDiscounter(String discountCode) {
    if (discountCode == null) {
      return Discountable.NONE;
    }

    try {
      return DiscountPolicy.valueOf(discountCode);
    } catch (IllegalArgumentException e) {
      System.out.println("Not found discountCode = " + discountCode);
      return Discountable.NONE;
    }
  }


}
