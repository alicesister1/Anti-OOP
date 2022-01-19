package main;

public class PaymentService {

  public static final int DEFAULT_DISCOUNT_COUPON_PRICE = 1000;

  /**
   * 실시간 할인 내역
   *
   * @param price
   * @param discountType
   * @return
   */
  public Discount getDiscount(long price, DiscountType discountType) {
    long discountPrice = getDiscountPrice(price, discountType);
    return Discount.of(discountPrice);
  }

  public long payment(long price, DiscountType discountType) {
    return price - getDiscountPrice(price, discountType);
  }

  private long getDiscountPrice(long price, DiscountType discountType) {
    long discount = 0;
    switch (discountType) {
      case NAVER:
        discount = (long) (price * 0.1);
        break;
      case DANAWA:
        discount = (long) (price * 0.15);
        break;
      case FANCAFE:
        discount = DEFAULT_DISCOUNT_COUPON_PRICE; // 기본 할인쿠폰 금액
        if (price < discount) {  // 상품금액이 할인쿠폰보다 적은경우 상품금액 전액 할인
          discount = price;
        }
        break;
    }
    return discount;
  }
}
