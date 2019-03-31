package week2.fibonacci.again;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FibonacciSumLastDigitTest {

    @Test
    void getFibonacciSumNaive() {
        assertThat(FibonacciSumLastDigit.getFibonacciSumNaive(3)).isEqualTo(4);
        assertThat(FibonacciSumLastDigit.getFibonacciSumNaive(100)).isEqualTo(5);
    }

    @Test
    void getFibonacciSum() {
        assertThat(FibonacciSumLastDigit.getFibonacciSum(0)).isEqualTo(0);
        assertThat(FibonacciSumLastDigit.getFibonacciSum(3)).isEqualTo(4);
        assertThat(FibonacciSumLastDigit.getFibonacciSum(100)).isEqualTo(5);
    }
}