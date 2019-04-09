package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;
import java.util.StringTokenizer;

public class MajorityElement {
  static int getMajorityElement(int[] a) {
    return getMajorityElement(a, 0, a.length);
  }

  static int getMajorityElement(int[] a, int left, int right) {
    Map<Integer, Integer> countMap = new HashMap<>((int) (a.length / 0.75));

    for (int i = 0; i < a.length; i++) {
      countMap.compute(a[i], (k, v) -> v == null ? 1 : ++v);
    }
    OptionalInt max = countMap.values().stream().mapToInt(Integer::intValue).max();
    if (max.isPresent() && max.getAsInt() > a.length / 2) {
      return 1;
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
    if (getMajorityElement(a, 0, a.length) != -1) {
      System.out.println(1);
    } else {
      System.out.println(0);
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

