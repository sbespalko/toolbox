package week5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ChangeDPTest {

  @Test
  void getChange() {
    assertThat(ChangeDP.getChange(9)).isEqualTo(3);
    assertThat(ChangeDP.getChange(6)).isEqualTo(2);
    assertThat(ChangeDP.getChange(7)).isEqualTo(2);
    assertThat(ChangeDP.getChange(8)).isEqualTo(2);
    assertThat(ChangeDP.getChange(10)).isEqualTo(3);
    assertThat(ChangeDP.getChange(34)).isEqualTo(9);
  }
}