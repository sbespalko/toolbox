package week6;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.max;


public class Knapsack {
  static int optimalWeight(int W, int[] w) {
    int[][] knapsack = new int[w.length + 1][W + 1];

    for (int i = 0; i < W + 1; i++) {
      knapsack[0][i] = 0;
    }
    for (int i = 0; i < w.length + 1; i++) {
      knapsack[i][0] = 0;
    }

    for (int i = 1; i < w.length + 1; i++) {
      for (int j = 1; j < W + 1; j++) {
        if (w[i - 1] <= j) {
          knapsack[i][j] = max(knapsack[i - 1][j],
              knapsack[i - 1][j - w[i - 1]] + w[i - 1]);
        } else {
          knapsack[i][j] = knapsack[i - 1][j];
        }
      }
    }
    System.out.println("Knapsack: W=" + W + ", w=" + Arrays.toString(w));
    printKnapsack(knapsack);
    return knapsack[w.length][W];
  }

  private static void printKnapsack(int[][] knapsack) {
    for (int[] ints : knapsack) {
      System.out.println(Arrays.toString(ints));
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int W, n;
    W = scanner.nextInt();
    n = scanner.nextInt();
    int[] w = new int[n];
    for (int i = 0; i < n; i++) {
      w[i] = scanner.nextInt();
    }
    System.out.println(optimalWeight(W, w));
  }
}

