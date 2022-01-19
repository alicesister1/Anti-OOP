package main;

/**
 * 모든 enum들을 dto에서 사용할 수 있게 하기 위한 인터페이스
 */
public interface EnumModel {
  String getKey();
  String getValue();
}
