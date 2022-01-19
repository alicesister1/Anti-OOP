package main.enums;

import lombok.Getter;
import main.service.Discountable;

@Getter
public enum DiscountPolicy implements Discountable {
  NAVER(10, 0L) {
    @Override
    public long getDiscountPrice(long price) {
      return price * getDiscountRatio() / 100;
    }
  },
  DANAWA(15, 0L) {
    @Override
    public long getDiscountPrice(long price) {
      return price * getDiscountRatio() / 100;
    }
  },
  FANCAFE(0, 1000L) {
    @Override
    public long getDiscountPrice(long price) {
      return Math.min(price, getDiscountPrice());
    }
  };

  DiscountPolicy(int discountRatio, long discountPrice) {
    this.discountRatio = discountRatio;
    this.discountPrice = discountPrice;
  }

  private final int discountRatio;
  private final long discountPrice;
}
