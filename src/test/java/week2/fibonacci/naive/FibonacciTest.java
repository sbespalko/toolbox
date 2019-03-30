package week2.fibonacci.naive;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTimeout;

class FibonacciTest {

  @Test
  void calc_fib() {
    long result = assertTimeout(Duration.ofMillis(1500), () -> Fibonacci.calc_fib(42));
    assertThat(result).isEqualTo(267914296L);
  }

  @Test
  void fasterCalcFib() {
    long result = assertTimeout(Duration.ofMillis(1000), () -> Fibonacci.fasterCalcFib(42));
    System.out.println(result);
    assertThat(result).isEqualTo(267914296L);
  }
}