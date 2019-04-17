package week5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrimitiveCalculatorTest {

  @Test
  void optimal_sequence() {
    assertThat(PrimitiveCalculator.optimal_sequence(5)).containsExactly(1, 3, 4, 5);
    assertThat(PrimitiveCalculator.optimal_sequence(1)).containsExactly(1);
    assertThat(PrimitiveCalculator.optimal_sequence(96234))
        .containsExactly(1, 3, 9, 10, 11, 33, 99, 297, 891, 2673, 8019, 16038, 16039, 48117, 96234);
  }
}