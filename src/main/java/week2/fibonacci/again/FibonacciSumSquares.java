package week2.fibonacci.again;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FibonacciSumSquares {
    static long getFibonacciSumSquaresNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current = 1;
        long sum = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current * current;
        }

        return sum % 10;
    }

    static long getFibonacciSumSquares(long n) {
        List<Long> seq = getPisanoPeriodSquares(10);
        int period = seq.size();

        int seqSum = (int) (seq.stream().mapToLong(Long::longValue).sum() % 10);
        long countPeriods = n / period;
        long countElem = n % period + 1;

        int sum = (int) ((seqSum * countPeriods) % 10);
        sum += seq.stream().limit(countElem).mapToLong(Long::longValue).sum();

        return sum % 10;
    }

    private static List<Long> getPisanoPeriodSquares(long m) {
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
        return seq.stream()
                .map(l -> l * l)
                .map(l -> l % m)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquares(n);
        System.out.println(s);
    }
}

