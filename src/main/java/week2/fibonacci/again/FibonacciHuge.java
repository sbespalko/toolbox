package week2.fibonacci.again;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciHuge {
    static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }

    static long getFibonacciHugeFaster(long n, long m) {
        if (n <= 1)
            return n;

        List<Long> seqFib = getPisanoPeriod(m);
        int pisanoPeriod = seqFib.size() - 2;
        return seqFib.get((int) (n % pisanoPeriod));
    }

    private static List<Long> getPisanoPeriod(long m) {
        List<Long> seq = new ArrayList<>();
        seq.add(0L);
        seq.add(1L);
        for (int i = 2; i < 6 * m; i++) {
            long fib = seq.get(i - 1) + seq.get(i - 2);
            seq.add(fib % m);
            if (seq.get(i) == 1 && seq.get(i - 1) == 0) {
                break;
            }

        }
        return seq;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeFaster(n, m));
    }
}

