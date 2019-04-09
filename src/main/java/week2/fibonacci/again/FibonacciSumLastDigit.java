package week2.fibonacci.again;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciSumLastDigit {
    static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current = 1;
        long sum = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }

    static long getFibonacciSum(long n) {
        if (n <= 1) {
            return n;
        }

        List<Long> seq = getPisanoPeriod(10);
        int period = seq.size();

        int seqSum = (int) (seq.stream().mapToLong(Long::longValue).sum() % 10);
        long countPeriods = n / period;
        long countElem = n % period + 1;

        int sum = (int) ((seqSum * countPeriods) % 10);
        sum += seq.stream().limit(countElem).mapToLong(Long::longValue).sum();

        return sum % 10;
    }

    private static List<Long> getPisanoPeriod(long m) {
        List<Long> seq = new ArrayList<>();
        seq.add(0L);
        seq.add(1L);
        for (int i = 2; i < 6 * m + 2; i++) {
            long fib = seq.get(i - 1) + seq.get(i - 2);
            seq.add(fib % m);
            if (seq.get(i) == 1 && seq.get(i - 1) == 0) {
                break;
            }

        }
        seq.remove(seq.size() - 1);
        seq.remove(seq.size() - 1);
        return seq;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSum(n);
        System.out.println(s);
    }
}

