package week4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MajorityElementTest {

  @Test
  void getMajorityElement() {
    assertThat(MajorityElement.getMajorityElement(new int[]{2, 3, 9, 2, 2})).isEqualTo(1);
    assertThat(MajorityElement.getMajorityElement(new int[]{1, 2, 3, 4})).isEqualTo(-1);
    assertThat(MajorityElement.getMajorityElement(new int[]{1, 2, 3, 1})).isEqualTo(-1);
  }
}