package week5;

import java.util.Scanner;

class EditDistance {
  static int editDistance(String s, String t) {
    if (s.equals(t)) {
      return 0;
    }
    int[] working = new int[t.length() + 1];
    int[] prev = new int[t.length() + 1];
    for (int i = 0; i < working.length; i++) {
      working[i] = i;
    }

    for (int i = 1; i <= s.length(); i++) {
      System.arraycopy(working, 0, prev, 0, working.length);
      working[0] = i;
      char chI = s.charAt(i - 1);
      for (int j = 1; j <= t.length(); j++) {
        char chT = t.charAt(j - 1);
        int cost = chT == chI ? 0 : 1;
        int min = min(working[j - 1] + 1,
            prev[j] + 1,
            prev[j - 1] + cost);
        working[j] = min;
      }
    }
    return working[t.length()];
  }

  private static int min(int a, int b, int c) {
    return Math.min(Math.min(a, b), c);
  }

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(editDistance(s, t));
  }

}
