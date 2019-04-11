package week4;

import java.util.Scanner;

public class Inversions {

    static long mergeSort(int[] a) {
        return mergeSort(a, a.length);
    }

    static long mergeSort(int[] a, int n) {
        long numberOfInversions = 0;
        if (n < 2) {
            return numberOfInversions;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        System.arraycopy(a, 0, l, 0, mid);
        System.arraycopy(a, mid, r, 0, n - mid);

        numberOfInversions += mergeSort(l, mid);
        numberOfInversions += mergeSort(r, n - mid);

        numberOfInversions += merge(a, l, r, mid, n - mid);
        return numberOfInversions;
    }

    public static long merge(int[] a, int[] l, int[] r, int left, int right) {
        long numberOfInversions = 0;
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
                numberOfInversions += left - i;
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];

        }
        return numberOfInversions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(mergeSort(a));
    }
}

