package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearch {

  static int binarySearchOld(int[] a, int x) {
    int left = 0, right = a.length - 1;
    //write your code here
    int middle = (left + right) >> 1;
    while (a[middle] != x) {
      if (a[middle] > x) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
      if (left > right) {
        break;
      }
      middle = (left + right) >> 1;
    }
    return a[middle] == x ? middle : -1;
  }

  static int binarySearch(int[] a, int key) {
    int low = 0;
    int high = a.length - 1;

    while (low <= high) {
      int mid = (low + high) >>> 1;
      int midVal = a[mid];

      if (midVal < key)
        low = mid + 1;
      else if (midVal > key)
        high = mid - 1;
      else
        return mid;
    }
    return -1;
  }

  static int linearSearch(int[] a, int x) {
    for (int i = 0; i < a.length; i++) {
      if (a[i] == x) return i;
    }
    return -1;
  }

  public static void main(String[] args) {
    FastScanner scanner = new FastScanner(System.in);
    int n = scanner.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
    }
    int m = scanner.nextInt();
    int[] b = new int[m];
    for (int i = 0; i < m; i++) {
      b[i] = scanner.nextInt();
    }
    for (int i = 0; i < m; i++) {
      //replace with the call to binarySearch when implemented
      System.out.print(binarySearch(a, b[i]) + " ");
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
