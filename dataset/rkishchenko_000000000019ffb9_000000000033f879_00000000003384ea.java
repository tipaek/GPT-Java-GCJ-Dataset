import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            long[] parameters = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();
            String solution = solve(parameters[0], parameters[1]);
            System.out.println("Case #" + (i + 1) + ": " + solution);
        }
    }

    private static String solve(long left, long right) {
        long i = 1;
        while (i <= Math.max(left, right)) {
            if (left >= right) {
                long target = left - right;
                long n = Math.max(find(i, target, target), 1);
                long sum = sum(i, n);
                if (sum > left) {
                    sum = sum(i, n - 1);
                    n = n - 1;
                }
                left -= sum;
                i += n;
            } else {
                long target = right - left;
                long n = Math.max(find(i, target, target), 1);
                long sum = sum(i, n);
                if (sum > right) {
                    sum = sum(i, n - 1);
                    n = n - 1;
                }
                right -= sum;
                i += n;
            }
        }

        return (i - 1) + " " + left + " " + right;
    }

    private static long find(long a, long n, long target) {
        long l = 0;
        long r = n;
        while (l < r) {
            long m = l + (r - l) / 2;
            long sum = sum(a, m);
            if (sum == target) {
                return m;
            }
            if (sum < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l;
    }

    private static long sum(long a, long n) {
        BigDecimal multiplier = BigDecimal.valueOf(n).divide(BigDecimal.valueOf(2));
        BigDecimal right = BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(2)).add(BigDecimal.valueOf(n - 1));
        return multiplier.multiply(right).longValue();
    }

}
