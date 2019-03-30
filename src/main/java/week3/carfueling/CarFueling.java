package week3.carfueling;

import java.util.Scanner;

public class CarFueling {
  static int computeMinRefills(int dist, int tank, int[] stops) {
    int refuelCount = 0;
    int currPos = 0;
    int lastStop = 0;
    int i = 0;
    while (currPos + tank < dist) {
      lastStop = i;
      while (i < stops.length && currPos + tank >= stops[i]) {
        ++i;
      }
      //stops not found
      if (lastStop == i) {
        return -1;
      }
      currPos = stops[i - 1];
      ++refuelCount;
    }
    return refuelCount;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int dist = scanner.nextInt();
    int tank = scanner.nextInt();
    int n = scanner.nextInt();
    int stops[] = new int[n];
    for (int i = 0; i < n; i++) {
      stops[i] = scanner.nextInt();
    }

    System.out.println(computeMinRefills(dist, tank, stops));
  }
}
