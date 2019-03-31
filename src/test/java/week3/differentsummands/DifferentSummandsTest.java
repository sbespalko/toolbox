package week3.differentsummands;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DifferentSummandsTest {

  @Test
  void optimalSummands() {
    assertThat(DifferentSummands.optimalSummands(6)).containsOnly(1, 2, 3);
    assertThat(DifferentSummands.optimalSummands(8)).containsOnly(1, 2, 5);
    assertThat(DifferentSummands.optimalSummands(2)).containsOnly(2);
    assertThat(DifferentSummands.optimalSummands(1)).containsOnly(1);
  }
}