package week5;

import java.util.Scanner;

public class ChangeDP {
  static int getChange(int m) {
    int[] coins = new int[]{1, 3, 4};
    int[] minNumCoins = new int[m + 1];
    minNumCoins[0] = 0;
    int numCoins;
    for (int summ = 1; summ < minNumCoins.length; summ++) {
      minNumCoins[summ] = Integer.MAX_VALUE;
      for (int coin : coins) {
        if (summ >= coin) {
          numCoins = minNumCoins[summ - coin] + 1;
          if (numCoins < minNumCoins[summ]) {
            minNumCoins[summ] = numCoins;
          }
        }
      }
    }
    //write your code here
    return minNumCoins[m];
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int m = scanner.nextInt();
    System.out.println(getChange(m));

  }
}

