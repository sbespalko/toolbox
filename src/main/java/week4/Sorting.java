package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class Sorting {
    private static Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) {
        //write your code here
        int pivot = a[l];
        int m1 = l;
        int eq = 0;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] == pivot) {
                m1++;
                eq++;
                int t = a[i];
                a[i] = a[m1];
                a[m1] = t;
            } else if (a[i] < pivot) {
                m1++;
                int t = a[i];
                a[i] = a[m1];
                a[m1] = t;

                t = a[m1];
                a[m1] = a[m1 - eq];
                a[m1 - eq] = t;
            }
        }
        int t = a[l];
        a[l] = a[m1 - eq];
        a[m1 - eq] = t;

        int m2 = m1;
        m1 = m2 - eq;
        return new int[]{m1, m2};
    }

    private static int partition2(int[] a, int l, int r) {
        int pivot = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= pivot) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }

    static int[] randomizedQuickSort(int[] a) {
        randomizedQuickSort(a, 0, a.length - 1);
        return a;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int pivot = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[pivot];
        a[pivot] = t;
        //use partition3
        int[] m = partition3(a, l, r);
        randomizedQuickSort(a, l, m[0] - 1);
        randomizedQuickSort(a, m[1] + 1, r);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

