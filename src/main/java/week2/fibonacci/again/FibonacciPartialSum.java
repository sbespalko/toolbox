package week2.fibonacci.again;

import java.util.*;

public class FibonacciPartialSum {
    static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }

        return sum % 10;
    }

    static long getFibonacciPartialSum(long from, long to) {
        long sumFrom = getFibonacciSum(from - 1);
        long sumTo = getFibonacciSum(to);

        return (sumTo + 10 - sumFrom) % 10;
    }

    static long getFibonacciSum(long n) {
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
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSum(from, to));
    }
}

