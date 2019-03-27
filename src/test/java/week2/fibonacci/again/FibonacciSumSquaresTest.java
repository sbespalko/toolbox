package week2.fibonacci.again;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FibonacciSumSquaresTest {

    @Test
    void getFibonacciSumSquaresNaive() {
        assertThat(FibonacciSumSquares.getFibonacciSumSquaresNaive(7)).isEqualTo(3);
        assertThat(FibonacciSumSquares.getFibonacciSumSquaresNaive(8)).isEqualTo(4);
        assertThat(FibonacciSumSquares.getFibonacciSumSquaresNaive(9)).isEqualTo(0);
    }

    @Test
    void getFibonacciSumSquares() {
        assertThat(FibonacciSumSquares.getFibonacciSumSquares(7)).isEqualTo(3);
        assertThat(FibonacciSumSquares.getFibonacciSumSquares(8)).isEqualTo(4);
        assertThat(FibonacciSumSquares.getFibonacciSumSquares(9)).isEqualTo(0);
        assertThat(FibonacciSumSquares.getFibonacciSumSquares(73)).isEqualTo(1);
        assertThat(FibonacciSumSquares.getFibonacciSumSquares(1234567890)).isEqualTo(0);
    }
}