package week1.pair_product;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxPairwiseProductTest {

  private static Stream<ValuesAndExpected> getNumbers() {
    return Stream.of(
        ValuesAndExpected.of(new int[]{1, 2, 4}, 8),
        ValuesAndExpected.of(new int[]{4, 2, 1, 0}, 8),
        ValuesAndExpected.of(new int[]{5, 4, 5, 0, -1}, 25),
        ValuesAndExpected.of(new int[]{3, 0, 1_000_000, 900_000, 0, -1}, 900_000_000_000L)
    );
  }

  @ParameterizedTest
  @MethodSource("getNumbers")
  void getSimpleMax(ValuesAndExpected valuesAndExpected) {
    long expectedResult = valuesAndExpected.expected;
    int[] numbers = valuesAndExpected.numbers;

    long result = MaxPairwiseProduct.getMaxPairFast(numbers);

    assertThat(result).isEqualTo(expectedResult);
  }

  private static class ValuesAndExpected {
    int[] numbers;
    long expected;

    static ValuesAndExpected of(int[] numbers, long expected) {
      ValuesAndExpected v = new ValuesAndExpected();
      v.numbers = numbers;
      v.expected = expected;
      return v;
    }
  }
}