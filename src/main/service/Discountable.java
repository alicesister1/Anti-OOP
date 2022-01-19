package main.service;

public interface Discountable {

  Discountable NONE = price -> 0;

  long getDiscountPrice(long price);
}

class NaverDiscountPolicy implements Discountable {

  @Override
  public long getDiscountPrice(long price) {
    return (long) (price * 0.1);
  }
}

class DanawaDiscountPolicy implements Discountable {

  @Override
  public long getDiscountPrice(long price) {
    return (long) (price * 0.15);
  }
}

class FancafeDiscountPolicy implements Discountable {

  private long defaultDiscount = 1000L;

  @Override
  public long getDiscountPrice(long price) {
    return Math.min(price, defaultDiscount);
  }
}