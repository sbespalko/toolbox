package week2.fibonacci.naive;

import java.util.Scanner;

public class Fibonacci {
  static long calc_fib(int n) {
    if (n <= 1)
      return n;

    return calc_fib(n - 1) + calc_fib(n - 2);
  }

  static long fasterCalcFib(int n) {
    long result = 0;
    long prev = 1;
    long tmp;
    while (n != 0) {
      tmp = result;
      result += prev;
      prev = tmp;
      n--;
    }
    return result;
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(fasterCalcFib(n));
  }
}
