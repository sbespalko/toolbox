package week2.lcm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LCMTest {

    @Test
    void lcm_naive() {
        assertThat(LCM.lcm_naive(16,20)).isEqualTo(80);
        assertThat(LCM.lcm_naive(20, 30)).isEqualTo(60);
        assertThat(LCM.lcm_naive(12, 15)).isEqualTo(60);
    }

    @Test
    void lcm_faster() {
        assertThat(LCM.lcm_faster(16,20)).isEqualTo(80);
        assertThat(LCM.lcm_faster(20, 30)).isEqualTo(60);
        assertThat(LCM.lcm_faster(12, 15)).isEqualTo(60);
        assertThat(LCM.lcm_faster(14159572 , 63967072)).isEqualTo(226436590403296L);
    }
}