package week3.carfueling;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarFuelingTest {

  @Test
  void computeMinRefills() {
    assertThat(CarFueling.computeMinRefills(950, 400, new int[]{200, 375, 550, 750})).isEqualTo(2);
    assertThat(CarFueling.computeMinRefills(10, 3, new int[]{1, 2, 5, 9})).isEqualTo(-1);
    assertThat(CarFueling.computeMinRefills(200, 250, new int[]{100, 150})).isEqualTo(0);
    assertThat(CarFueling.computeMinRefills(200, 100, new int[]{100})).isEqualTo(1);
    assertThat(CarFueling.computeMinRefills(100_000, 250, new int[]{100, 150})).isEqualTo(-1);
    assertThat(CarFueling.computeMinRefills(100, 20, new int[]{20, 40, 60, 80})).isEqualTo(4);
  }
}