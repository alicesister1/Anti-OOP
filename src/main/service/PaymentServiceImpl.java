package main.service;

import main.domain.Discount;
import main.enums.DiscountType;

public class PaymentServiceImpl implements PaymentService {

  SimpleDiscounterFactory discounterFactory = new SimpleDiscounterFactory();

  /**
   * 실시간 할인 내역
   *
   * @param price
   * @param discountType
   * @return
   */
  @Override
  public Discount getDiscount(long price, DiscountType discountType) {
    Discountable discountPolicy = getDiscounter(discounterFactory, discountType);
    long discountPrice = discountPolicy.getDiscountPrice(price);
    return Discount.of(discountPrice);
  }

  /**
   * 할인이 적용된 결제금액
   *
   * @param price
   * @param discountType
   * @return
   */
  @Override
  public long payment(long price, DiscountType discountType) {
    Discountable discountPolicy = getDiscounter(discounterFactory, discountType);
    long discountPrice = discountPolicy.getDiscountPrice(price);
    return price - discountPrice;
  }

  private Discountable getDiscounter(SimpleDiscounterFactory factory, DiscountType discountType) {
    Discountable discountPolicy = factory.getDiscounter(discountType);
    return discountPolicy;
  }


}
