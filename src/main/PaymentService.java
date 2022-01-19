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
    long discountPrice;
    switch (discountType) {
      case NAVER:
        discountPrice = (long) (price * 0.1);
        break;
      case DANAWA:
        discountPrice = (long) (price * 0.15);
        break;
      case FANCAFE:
        discountPrice = DEFAULT_DISCOUNT_COUPON_PRICE; // 기본 할인쿠폰 금액
        if (price < discountPrice) {  // 상품금액이 할인쿠폰보다 적은경우 상품금액 전액 할인
          discountPrice = price;
        }
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + discountType);
    }
    return Discount.of(discountPrice);
  }

  public long payment(long price, DiscountType discountType) {
    // 결제금액
    long paymentAmount = price;
    switch (discountType) {
      case NAVER:
        paymentAmount = (long) (price * 0.9);
        break;
      case DANAWA:
        paymentAmount = (long) (price * 0.85);
        break;
      case FANCAFE:
        paymentAmount = price - DEFAULT_DISCOUNT_COUPON_PRICE;
        if (price < DEFAULT_DISCOUNT_COUPON_PRICE) {  // 상품금액이 할인쿠폰보다 적은경우 0원 결제
          paymentAmount = 0;
        }
        break;
    }
    return paymentAmount;
  }
}
