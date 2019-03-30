package week3.fractionalknapsack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FractionalKnapsack {
  static double getOptimalValue(int capacity, int[] values, int[] weights) {
    double value = 0;
    List<Fraction> fractions = new ArrayList<>(values.length);
    for (int i = 0; i < values.length; i++) {
      fractions.add(new Fraction(values[i], weights[i]));
    }
    Collections.sort(fractions);
    Collections.reverse(fractions);

    for (Fraction fraction : fractions) {
      if (capacity == 0) {
        break;
      }
      double part = 1;
      if (capacity < fraction.weight) {
        part = capacity * 1.0 / fraction.weight;
      }
      capacity -= part * fraction.weight;
      value += part * fraction.value;
    }

    return value;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int capacity = scanner.nextInt();
    int[] values = new int[n];
    int[] weights = new int[n];
    for (int i = 0; i < n; i++) {
      values[i] = scanner.nextInt();
      weights[i] = scanner.nextInt();
    }
    System.out.println(getOptimalValue(capacity, values, weights));
  }

  private static class Fraction implements Comparable<Fraction> {
    private int value;
    private int weight;
    private double rate;

    public Fraction(int value, int weight) {
      this.value = value;
      this.weight = weight;
      this.rate = value * 1.0 / weight;
    }

    @Override
    public int compareTo(Fraction o) {
      return Double.compare(this.rate, o.rate);
    }
  }
} 
