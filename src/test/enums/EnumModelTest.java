package test.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import main.enums.DiscountType;
import main.enums.EnumModel;
import org.junit.jupiter.api.Test;

class EnumModelTest {

  @Test
  public void EnumModel_인터페이스를_구현하는_경우_EnumMode_타입임을_확인할_수_있다() {
    List<EnumModel> enumModels = new ArrayList<>();
    enumModels.add(DiscountType.NAVER);
    enumModels.add(DiscountType.DANAWA);
    enumModels.add(DiscountType.FANCAFE);

    assertEquals(enumModels.get(0).getValue(), "네이버");
    assertEquals(enumModels.get(1).getValue(), "다나와");
    assertEquals(enumModels.get(2).getValue(), "팬카페");
  }
}