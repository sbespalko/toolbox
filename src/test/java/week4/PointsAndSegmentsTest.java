package week4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class PointsAndSegmentsTest {
  Random rnd = new Random();

  @Test
  void fastCountSegments() {
    assertThat(PointsAndSegments
        .fastCountSegments(new int[]{-2, -1, 0, 1, 1, 3, 3, 4},
            new int[]{0, 0, 2, 3, 4, 4, 5, 7},
            new int[]{-2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8}))
        .containsExactly(1, 2, 3, 3, 3, 4, 4, 2, 1, 1, 0);

    assertThat(PointsAndSegments
        .fastCountSegments(new int[]{0, 7}, new int[]{5, 10}, new int[]{1, 6, 11}))
        .containsExactly(1, 0, 0);

    assertThat(PointsAndSegments
        .fastCountSegments(new int[]{0, -3, 7}, new int[]{5, 2, 10}, new int[]{1, 6}))
        .containsExactly(2, 0);

  }

  @Test
  void searchEqOrGt() {
    assertThat(PointsAndSegments.searchInclusive(new int[]{-2, -1, 0, 1, 1, 3, 3, 4}, 2))
        .isEqualTo(5);
    assertThat(PointsAndSegments.searchInclusive(new int[]{-2, -1, 0, 1, 1, 3, 3, 4}, 1))
        .isEqualTo(5);

    assertThat(PointsAndSegments.searchExclusive(new int[]{-2, -1, 0, 1, 1, 3, 3, 4}, 1))
        .isEqualTo(2);
    assertThat(PointsAndSegments.searchExclusive(new int[]{-2, -1, 0, 1, 1, 3, 3, 4}, 2))
        .isEqualTo(4);
  }

  @Test
  void stress() {

    for (int i = 0; i < 100; i++) {
      System.out.println(" i = " + i);
      int size = rnd.nextInt(500);
      int[] starts = generateArray(size, 500);
      int[] ends = new int[size];
      for (int i1 = 0; i1 < starts.length; i1++) {
        ends[i1] = starts[i1] + rnd.nextInt(1000);
      }
      int[] points = generateArray(1000, 2000);

      int[] result = PointsAndSegments.fastCountSegments(starts, ends, points);
      int[] expected = PointsAndSegments.naiveCountSegments(starts, ends, points);
      assertThat(result).withFailMessage("fail in array: %s, %s, %s",
          Arrays.toString(starts), Arrays.toString(ends), Arrays.toString(points))
                        .containsExactly(expected);
    }
  }

  private int[] generateArray(int size, int bound) {
    int[] array = new int[size];
    for (int j = 0; j < array.length; j++) {
      array[j] = rnd.nextInt(bound);
    }
    return array;
  }
}