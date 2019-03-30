package week3.moneychange;

import java.util.Scanner;

public class Change {
  static int getChange(int m) {
    int coinsCount = 0;
    while (m > 0) {
      int selectedCoin = 0;
      if (m - 10 >= 0) {
        selectedCoin = 10;
      } else if (m - 5 >= 0) {
        selectedCoin = 5;
      } else if (m - 1 >= 0) {
        selectedCoin = 1;
      }
      coinsCount++;
      m -= selectedCoin;
    }
    return coinsCount;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int m = scanner.nextInt();
    System.out.println(getChange(m));

  }
}

