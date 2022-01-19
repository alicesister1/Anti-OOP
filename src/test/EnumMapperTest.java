package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import main.DiscountType;
import main.EnumMapper;
import main.dto.EnumValue;
import org.junit.jupiter.api.Test;

class EnumMapperTest {

  @Test
  void getEnumValue() {
    //given
    String key = "discountType";
    EnumMapper EnumMapper = new EnumMapper();
    EnumMapper.put(key, DiscountType.class);

    //when
    Map<String, List<EnumValue>> result = EnumMapper.get(key);

    //then
    List<EnumValue> enumValues = result.get(key);
    EnumValue first = enumValues.get(0);
    EnumValue second = enumValues.get(1);
    EnumValue third = enumValues.get(2);
    assertEquals(first.getKey(), "NAVER");
    assertEquals(first.getValue(), "네이버");
    assertEquals(second.getKey(), "DANAWA");
    assertEquals(second.getValue(), "다나와");
    assertEquals(third.getKey(), "FANCAFE");
    assertEquals(third.getValue(), "팬카페");
  }
}