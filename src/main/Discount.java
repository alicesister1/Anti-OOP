package main;

public class Discount {

  private final long discountAmnt;

  public Discount(long discountAmnt) {
    this.discountAmnt = discountAmnt;
  }

  public static Discount of(long discountAmt) {
    return new Discount(discountAmt);
  }
}
