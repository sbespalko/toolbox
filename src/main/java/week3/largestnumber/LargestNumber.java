package week3.largestnumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LargestNumber {
  static String largestNumber(String[] a) {
    List<String> nums = Arrays.stream(a).collect(Collectors.toList());

    StringBuilder answer = new StringBuilder();
    while (!nums.isEmpty()) {
      String maxDigit = "0";
      for (String num : nums) {
        if (isGreater(num, maxDigit)) {
          maxDigit = num;
        }
      }
      answer.append(maxDigit);
      nums.remove(maxDigit);
    }
    return answer.toString();
  }

  private static boolean isGreater(String num, String maxDigit) {
    if (num.length() == maxDigit.length()) {
      return Integer.valueOf(num) > Integer.valueOf(maxDigit);
    }

    boolean result;
    if (num.length() > maxDigit.length()) {
      result = isGreaterThen(num, maxDigit);
    } else {
      result = !isGreaterThen(maxDigit, num);
    }

    return result;
  }

  private static boolean isGreaterThen(String num, String maxDigit) {
    if (num.length() == 0) {
      return false;
    }
    String firstPartNum = num.substring(0, maxDigit.length());
    int compare = Integer.compare(Integer.valueOf(firstPartNum), Integer.valueOf(maxDigit));
    if (compare > 0) {
      return true;
    }
    if (compare < 0) {
      return false;
    }
    int minLength = Math.min(num.length(), maxDigit.length() * 2) - maxDigit.length();
    StringBuilder filler = new StringBuilder();
    for (int i = 0; i < minLength; i++) {
      filler.append(maxDigit.charAt(i));
    }
    return isGreaterThen(num.substring(maxDigit.length()), filler.toString());
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    String[] a = new String[n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.next();
    }
    System.out.println(largestNumber(a));
  }
}

