package week1.pair_product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class MaxPairwiseProduct {
  static int getMaxPairwiseProduct(int[] numbers) {
    int max_product = 0;
    int n = numbers.length;

    for (int first = 0; first < n; ++first) {
      for (int second = first + 1; second < n; ++second) {
        max_product = max(max_product, numbers[first] * numbers[second]);
      }
    }

    return max_product;
  }

  static long getMaxPairFast(int[] numbers) {
    int max1 = 0;
    int max2 = 0;
    for (int number : numbers) {
      if (number > max1) {
        max2 = max1;
        max1 = number;
      } else if (number > max2) {
        max2 = number;
      }
    }
    return (long) max1 * max2;
  }

  public static void main(String[] args) {
    FastScanner scanner = new FastScanner(System.in);
    int n = scanner.nextInt();
    int[] numbers = new int[n];
    for (int i = 0; i < n; i++) {
      numbers[i] = scanner.nextInt();
    }
    System.out.println(getMaxPairFast(numbers));
  }

  static class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    FastScanner(InputStream stream) {
      try {
        br = new BufferedReader(new
            InputStreamReader(stream));
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
