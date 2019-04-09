package week4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTest {

  public static int[] arrayGen(int count) {
    int[] array = new int[count];
    for (int i = 0; i < array.length; i++) {
      array[i] = i * 3 + 100;
    }
    return array;
  }

  @Test
  void binarySearch() {
    assertThat(BinarySearch
        .binarySearch(new int[]{1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34, 37, 40}, 0))
        .isEqualTo(-1);
    assertThat(BinarySearch.binarySearch(new int[]{1, 5, 8, 12, 13, 14}, 15)).isEqualTo(-1);
    assertThat(BinarySearch.binarySearch(new int[]{1, 5, 8, 12, 13, 14}, 14)).isEqualTo(5);
    assertThat(BinarySearch.binarySearch(new int[]{1, 5, 8, 12, 13, 14}, 13)).isEqualTo(4);
    assertThat(BinarySearch.binarySearch(new int[]{1, 5, 8, 12, 13, 14}, 12)).isEqualTo(3);
    assertThat(BinarySearch.binarySearch(new int[]{1, 5, 8, 12, 13}, 13)).isEqualTo(4);
    assertThat(BinarySearch.binarySearch(new int[]{1, 5, 8, 12, 13}, 23)).isEqualTo(-1);
    assertThat(BinarySearch.binarySearch(new int[]{1, 5, 8, 12, 13}, 8)).isEqualTo(2);
    assertThat(BinarySearch.binarySearch(new int[]{1, 5, 8, 12, 13}, 1)).isEqualTo(0);
    assertThat(BinarySearch.binarySearch(new int[]{1, 5, 8, 12, 13}, 11)).isEqualTo(-1);
  }

  @Test
  void name() {
    Random rnd = new Random();
    int count = rnd.nextInt(100);
    int[] array = new int[count];
    for (int i = 0; i < array.length; i++) {
      array[i] = i * 3 + 100;
    }
    System.out.println(Arrays.toString(array));

    for (int i = 0; i < 10000; i++) {
      int toSearch = rnd.nextInt(120 * 5);
      System.out.print(toSearch + ", ");
      int binaryResult = BinarySearch.binarySearch(array, toSearch);
      int linearSearch = BinarySearch.linearSearch(array, toSearch);
      if (binaryResult != linearSearch) {
        System.out.println("In array: " + Arrays.toString(array));
        System.out.println("toSearch: " + toSearch);
        System.out.println("Bin: " + binaryResult + " Lin: " + linearSearch);
      }
    }
  }
}