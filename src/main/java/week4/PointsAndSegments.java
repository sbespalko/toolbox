package week4;

import java.util.Arrays;
import java.util.Scanner;

public class PointsAndSegments {

  static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
    int[] cnt = new int[points.length];

    Arrays.sort(starts);
    Arrays.sort(ends);

    for (int i = 0; i < points.length; i++) {
      int startsCount = searchInclusive(starts, points[i]);
      int endsCount = searchExclusive(ends, points[i]);
      cnt[i] = startsCount - endsCount - 1;
    }
    //write your code here
    return cnt;
  }

  static int searchInclusive(int[] a, int point) {
    return searchEqOrGt(a, point, true);
  }

  static int searchExclusive(int[] a, int point) {
    return searchEqOrGt(a, point, false);
  }

  static int searchEqOrGt(int[] a, int point, boolean inclusive) {
    int left = 0;
    int right = a.length - 1;
    int middle = (left + right) >> 1;
    while (a[middle] != point) {
      if (a[middle] < point) {
        left = middle + 1;
      } else {
        right = middle - 1;
      }
      if (left > right) {
        break;
      }
      middle = (left + right) >> 1;
    }
    if (inclusive) {
      while (middle < a.length && a[middle] <= point) {
        ++middle;
      }
    } else {
      while (middle >= 0 && a[middle] >= point) {
        --middle;
      }
    }
    return middle;
  }

  static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
    int[] cnt = new int[points.length];
    for (int i = 0; i < points.length; i++) {
      for (int j = 0; j < starts.length; j++) {
        if (starts[j] <= points[i] && points[i] <= ends[j]) {
          cnt[i]++;
        }
      }
    }
    return cnt;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n, m;
    n = scanner.nextInt();
    m = scanner.nextInt();
    int[] starts = new int[n];
    int[] ends = new int[n];
    int[] points = new int[m];
    for (int i = 0; i < n; i++) {
      starts[i] = scanner.nextInt();
      ends[i] = scanner.nextInt();
    }
    for (int i = 0; i < m; i++) {
      points[i] = scanner.nextInt();
    }
    //use fastCountSegments
    int[] cnt = fastCountSegments(starts, ends, points);
    for (int x : cnt) {
      System.out.print(x + " ");
    }
  }
}

