package week2.fibonacci.again;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FibonacciPartialSumTest {

    @Test
    void getFibonacciPartialSumNaive() {
        assertThat(FibonacciPartialSum.getFibonacciPartialSumNaive(3, 7)).isEqualTo(1);
        assertThat(FibonacciPartialSum.getFibonacciPartialSumNaive(10, 10)).isEqualTo(5);
    }

    @Test
    void getFibonacciPartialSum() {
        assertThat(FibonacciPartialSum.getFibonacciPartialSum(3, 7)).isEqualTo(1);
        assertThat(FibonacciPartialSum.getFibonacciPartialSum(10, 10)).isEqualTo(5);
        assertThat(FibonacciPartialSum.getFibonacciPartialSum(10, 200)).isEqualTo(2);

    }
}