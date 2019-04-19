package week5;

import java.util.Scanner;

class EditDistance {
  static int editDistance(String s, String t) {
    if (s.equals(t)) {
      return 0;
    }
    int[][] matrix = new int[s.length() + 1][t.length() + 1];
    for (int i = 0; i <= s.length(); i++) {
      matrix[i][0] = i;
    }
    for (int i = 0; i <= t.length(); i++) {
      matrix[0][i] = i;
    }

    for (int i = 1; i <= s.length(); i++) {
      char chI = s.charAt(i - 1);
      for (int j = 1; j <= t.length(); j++) {
        char chT = t.charAt(j - 1);
        int cost = chT == chI ? 0 : 1;
        int min = min(matrix[i][j - 1] + 1,
            matrix[i - 1][j] + 1,
            matrix[i - 1][j - 1] + cost);
        matrix[i][j] = min;
      }
    }
    return matrix[s.length()][t.length()];
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
