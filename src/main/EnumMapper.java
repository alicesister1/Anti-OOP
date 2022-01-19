package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import main.dto.EnumValue;

public class EnumMapper {

  // 다른 클래스에서 factory를 직접 접근하지 못하고 public으로 오픈한 put(), get(), getAll()만 접근할 수 있도록
  private final Map<String, List<EnumValue>> factory = new HashMap<>();

  public void put(String key, Class<? extends EnumModel> e) {
    factory.put(key, toEnumValues(e));
  }

  public Map<String, List<EnumValue>> getAll() {
    return factory;
  }

  public Map<String, List<EnumValue>> get(String keys) {
    return Arrays.stream(keys.split(","))
        .collect(Collectors.toMap(Function.identity(), key -> factory.get(key)));
  }

  /**
   * EnumModel 배열을 EnumValue 리스트로 전환
   *
   * @param e
   * @return
   */
  private List<EnumValue> toEnumValues(Class<? extends EnumModel> e) {
    return Arrays.stream(e.getEnumConstants()).map(EnumValue::new).collect(Collectors.toList());
  }
}
