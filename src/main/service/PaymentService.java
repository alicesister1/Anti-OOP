package main.service;

import main.domain.Discount;
import main.enums.DiscountType;

public interface PaymentService {

  Discount getDiscount(long price, DiscountType discountType);

  long payment(long price, DiscountType discountType);
}
