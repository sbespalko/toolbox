package week5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrimitiveCalculator {
  static List<Integer> optimal_sequence(int n) {

    int[] ops = new int[n + 1];
    ops[1] = 0;
    int min;
    //F(n) = min (F(n-1), F(n/2), F(n/3)) + 1
    for (int i = 2; i < ops.length; i++) {
      min = ops[i - 1] + 1;
      if (i % 2 == 0) {
        min = Math.min(min, ops[i / 2] + 1);
      }
      if (i % 3 == 0) {
        min = Math.min(min, ops[i / 3] + 1);
      }
      ops[i] = min;
    }
    List<Integer> result = new ArrayList<>();
    int i = n;
    result.add(i);
    while (i > 1) {
      if (ops[i] == ops[i - 1] + 1) {
        --i;
        result.add(i);
      } else if (i % 2 == 0 && ops[i] == ops[i / 2] + 1) {
        i /= 2;
        result.add(i);
      } else if (i % 3 == 0 && ops[i] == ops[i / 3] + 1) {
        i /= 3;
        result.add(i);
      }

    }
    Collections.reverse(result);
    return result;
  }

  static List<Integer> optimal_sequence1(int n) {
    List<Integer> sequence = new ArrayList<Integer>();
    while (n >= 1) {
      sequence.add(n);
      if (n % 3 == 0) {
        n /= 3;
      } else if (n % 2 == 0) {
        n /= 2;
      } else {
        n -= 1;
      }
    }
    Collections.reverse(sequence);
    return sequence;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    List<Integer> sequence = optimal_sequence(n);
    System.out.println(sequence.size() - 1);
    for (Integer x : sequence) {
      System.out.print(x + " ");
    }
  }
}

