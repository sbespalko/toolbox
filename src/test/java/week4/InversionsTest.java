package week4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InversionsTest {

    @Test
    public void positiveTest() {
        int[] array = new int[]{1, 2, 3, 0};
        int[] expected = new int[]{0, 1, 2, 3};
        Inversions.mergeSort(array);
        assertThat(array).isEqualTo(expected);
        assertThat(Inversions.mergeSort(new int[]{1, 2, 3, 0})).isEqualTo(3);
        assertThat(Inversions.mergeSort(new int[]{1, 3, 2})).isEqualTo(1);
        assertThat(Inversions.mergeSort(new int[]{2, 3, 9, 2, 9})).isEqualTo(2);

       int[] actual = { 5, 1, 6, 2, 3, 4 };
        int[] expected1 = { 1, 2, 3, 4, 5, 6 };
        Inversions.mergeSort(actual, actual.length);
        assertThat(expected1).isEqualTo(actual);
    }

    @Test
    void name() {
        assertThat(Inversions.mergeSort(new int[]{2, 3, 9, 2, 9})).isEqualTo(2);
    }
}