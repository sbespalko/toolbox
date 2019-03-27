package week2.lcm;

import java.util.Scanner;

public class LCM {
    static long lcm_naive(int a, int b) {
        for (long l = 1; l <= (long) a * b; ++l)
            if (l % a == 0 && l % b == 0)
                return l;

        return (long) a * b;
    }

    static long lcm_faster(int a, int b) {
        long gcd = gcd(a, b);
        return  ((long) a * b) / gcd;
    }

    private static long gcd(int a, int b) {
        long bigger = a > b ? a : b;
        long smaller = a > b ? b : a;
        while (smaller != 0) {
            long remainder = bigger % smaller;
            bigger = smaller;
            smaller = remainder;
        }
        return bigger;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(lcm_faster(a, b));
    }
}
