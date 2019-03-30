package week3.fractionalknapsack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FractionalKnapsackTest {

  @Test
  void getOptimalValue() {
    assertThat(FractionalKnapsack
        .getOptimalValue(50, new int[]{60, 100, 120}, new int[]{20, 50, 30})).isEqualTo(180);
    assertThat(FractionalKnapsack.getOptimalValue(10, new int[]{500}, new int[]{30}))
        .isEqualTo(166 + 2.0 / 3);
  }
}