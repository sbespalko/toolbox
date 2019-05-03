package week6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KnapsackTest {

  @Test
  void optimalWeight() {
    assertThat(Knapsack.optimalWeight(10, new int[]{1, 4, 8})).isEqualTo(9);
    assertThat(Knapsack.optimalWeight(20, new int[]{15, 8, 8})).isEqualTo(16);
  }
}