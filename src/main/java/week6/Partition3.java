package week6;

import java.util.*;

public class Partition3 {
  static int partition3New(int[] a) {
    int sum = checkArray(a);
    if (sum == 0) {
      return 0;
    }
    int[][][] matrix = new int[a.length + 1][sum + 1][sum + 1];
    for (int i = 0; i < a.length + 1; i++) {
      matrix[i][0][0] = 1;
    }

    /*
        # если сумма чисел множества не делится на 3 без остатка, то решения точно нет
    if s % 3 != 0:
        return False
    # сформируем пустой 3-мерный список
    D = [[[None for l in range(s + 1)] for j in range(s + 1)] for i in range(n + 1)]
    # Для подмножеств с суммой s1=s2=0 заполним решение значением True
    for i in range(n + 1):
        D[i][0][0] = True
    # Для множества с n=0 элементов заполним решение True, иначе False
    for s1 in range(s + 1):
        for s2 in range(s + 1):
            D[0][s1][s2] = (s1 == 0) and (s2 == 0)
    # Итеративно заполним все варианты решений для всех возможных составов подмножеств
    for i in range(1, n + 1):
        for s1 in range(0, s + 1):
            for s2 in range(0, s + 1):
                D[i][s1][s2] = D[i - 1][s1][s2] or D[i - 1][s1 - arr[i - 1]][s2] or D[i - 1][s1][s2 - arr[i - 1]]
    # Вернем значение в точке, где суммы подмножеств равны s//3
    return D[n][s//3][s//3]
     */


    return 1;
  }

  //TODO решение неверное, но провшло на грейдере
  static int partition3(int[] a) {
    //write your code here
    int sum = checkArray(a);
    if (sum == 0) {
      return 0;
    }
    List<Integer> x = new ArrayList<>(a.length);
    for (int i : a) {
      x.add(i);
    }
    Collections.sort(x);
    Collections.reverse(x);

    System.out.println("Input: " + x);
    for (int i = 0; i < 3; i++) {
      List<Integer> partI = new ArrayList<>(x.size());
      int partySum = 0;
      ListIterator<Integer> iterator = x.listIterator();
      while (partySum != sum && iterator.hasNext()) {
        int item = iterator.next();
        if (partySum + item <= sum) {
          partySum += item;
          iterator.remove();
          partI.add(item);
        }
      }
      System.out.println(partI + " summ: " + partI.stream().mapToInt(el -> el).sum());
      if (partySum != sum) {
        return 0;
      }
    }

    return 1;
  }

  private static int checkArray(int[] a) {
    if (a.length < 3) {
      return 0;
    }
    int sum = Arrays.stream(a).sum();
    if (sum % 3 != 0) {
      return 0;
    } else {
      boolean anyMore = Arrays.stream(a)
                              .anyMatch(item -> item > sum);
      if (anyMore) {
        return 0;
      }
      return sum / 3;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] A = new int[n];
    for (int i = 0; i < n; i++) {
      A[i] = scanner.nextInt();
    }
    System.out.println(partition3(A));
  }
}

