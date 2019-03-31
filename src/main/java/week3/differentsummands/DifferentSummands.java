package week3.differentsummands;

import java.util.*;

public class DifferentSummands {
  static List<Integer> optimalSummands(int n) {
    Deque<Integer> stack = new ArrayDeque<>();
    int sum = 0;
    for (int i = 1; i <= n && sum != n; i++) {
      if (sum + i > n) {
        sum -= stack.pop();
      }
      sum += i;
      stack.push(i);
    }
    return new ArrayList<>(stack);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    List<Integer> summands = optimalSummands(n);
    System.out.println(summands.size());
    for (Integer summand : summands) {
      System.out.print(summand + " ");
    }
  }
}

