package main.dto;

import main.enums.EnumModel;

/**
 * EnumModel은 Interface이므로 인스턴스가 아닌 타입이다. enum의 value 사용을 위한 DTO를 생성
 */
public class EnumValue {

  private final String key;
  private final String value;

  public EnumValue(EnumModel enumModel) {
    key = enumModel.getKey();
    value = enumModel.getValue();
  }

  public String getKey() {
    return key;
  }

  public String getValue() {
    return value;
  }
}
