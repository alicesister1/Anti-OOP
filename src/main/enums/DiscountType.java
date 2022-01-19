package main.enums;

public enum DiscountType implements EnumModel {
  NAVER("네이버"),
  DANAWA("다나와"),
  FANCAFE("팬카페");

  private final String value;

  DiscountType(String value) {
    this.value = value;
  }

  @Override
  public String getKey() {
    return name();
  }

  @Override
  public String getValue() {
    return value;
  }
}
