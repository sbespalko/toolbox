package week2.gcd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GCDTest {

    @Test
    void gcd_naive() {
        assertThat(GCD.gcd_naive(10, 12)).isEqualTo(2);
        assertThat(GCD.gcd_naive(6, 9)).isEqualTo(3);
    }

    @Test
    void gcd_faster() {
        assertThat(GCD.gcd_faster(10, 12)).isEqualTo(2);
        assertThat(GCD.gcd_faster(6, 9)).isEqualTo(3);
    }
}