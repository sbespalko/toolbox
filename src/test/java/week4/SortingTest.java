package week4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SortingTest {

  @Test
  void randomizedQuickSort() {
    assertThat(Sorting.randomizedQuickSort(new int[]{2, 3, 9, 2, 2}))
        .isEqualTo(new int[]{2, 2, 2, 3, 9});
  }
}