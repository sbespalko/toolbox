package week3.moneychange;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ChangeTest {

  @Test
  void getChange() {
    assertThat(Change.getChange(10)).isEqualTo(1);
    assertThat(Change.getChange(100)).isEqualTo(10);
    assertThat(Change.getChange(2)).isEqualTo(2);
    assertThat(Change.getChange(28)).isEqualTo(6);
    assertThat(Change.getChange(1)).isEqualTo(1);
    assertThat(Change.getChange(1000)).isEqualTo(100);
  }
}