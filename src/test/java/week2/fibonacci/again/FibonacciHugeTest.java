package week2.fibonacci.again;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FibonacciHugeTest {

    @Test
    void getFibonacciHugeNaive() {
        assertThat(FibonacciHuge.getFibonacciHugeNaive(5,10000)).isEqualTo(5);
        assertThat(FibonacciHuge.getFibonacciHugeNaive(10,10000)).isEqualTo(55);
    }

    @Test
    void getFibonacciHugeFaster() {
        assertThat(FibonacciHuge.getFibonacciHugeFaster(5,10000)).isEqualTo(5);
        assertThat(FibonacciHuge.getFibonacciHugeFaster(10,10000)).isEqualTo(55);
        assertThat(FibonacciHuge.getFibonacciHugeFaster(239,1000)).isEqualTo(161);
        assertThat(FibonacciHuge.getFibonacciHugeFaster(2816213588L,239)).isEqualTo(151);
    }
}