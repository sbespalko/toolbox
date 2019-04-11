package week4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class SortingTest {

    @Test
    void randomizedQuickSort() {
        assertThat(Sorting.randomizedQuickSort(new int[]{1, 1, 4, 2, 2})).isEqualTo(new int[]{1, 1, 2, 2, 4});
        assertThat(Sorting.randomizedQuickSort(new int[]{1, 1, 4, 2, 2})).isEqualTo(new int[]{1, 1, 2, 2, 4});
        assertThat(Sorting.randomizedQuickSort(new int[]{2, 3, 9, 2, 2})).isEqualTo(new int[]{2, 2, 2, 3, 9});
    }

    @Test
    void name() {
        for (int i = 0; i < 10000; i++) {
            Random rnd = new Random();
            int count = rnd.nextInt(100);
            int[] array = new int[count];
            for (int j = 0; j < array.length; j++) {
                array[j] = rnd.nextInt(15);
            }
            System.out.println(i + "initial array: " + Arrays.toString(array));

            Sorting.randomizedQuickSort(array);
            int[] check = array.clone();
            Arrays.sort(check);
            assertThat(array).withFailMessage("fail sorted " + Arrays.toString(array)).containsExactly(check);
        }
    }
}