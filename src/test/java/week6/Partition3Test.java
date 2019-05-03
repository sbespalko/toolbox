package week6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Partition3Test {

  @Test
  void partition3() {
    assertThat(Partition3.partition3(new int[]{8, 6, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3})).isEqualTo(1);
    assertThat(Partition3.partition3(new int[]{3, 2, 2, 3, 2, 6})).isEqualTo(1);
    assertThat(Partition3.partition3(new int[]{1, 1, 1, 2, 2, 2})).isEqualTo(1);
    assertThat(Partition3.partition3(new int[]{1, 2, 3, 4, 5, 5, 7, 7, 8, 10, 12, 19, 25}))
        .isEqualTo(1);
    assertThat(Partition3.partition3(new int[]{17, 59, 34, 57, 17, 23, 67, 1, 18, 2, 59}))
        .isEqualTo(1);
    assertThat(Partition3.partition3(new int[]{3, 3, 3})).isEqualTo(1);
    assertThat(Partition3.partition3(new int[]{40})).isEqualTo(0);
  }
}