import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private String solveUsingSubtraction(long l, long r) {
        int k = 1;
        while (l >= k || r >= k) {
            if (l >= r) {
                l -= k;
            } else {
                r -= k;
            }
            k++;
        }
        return (k - 1) + " " + l + " " + r;
    }

    private String solve(Scanner in) {
        long l = in.nextLong();
        long r = in.nextLong();
        return solveUsingMath(l, r);
    }

    private String solveUsingMath(long l, long r) {
        long distance = 2 * Math.abs(l - r);
        long k = (long) Math.floor(Math.sqrt(distance)) - 1;
        while ((k + 1) * (k + 2) <= distance) {
            k++;
        }
        if (l < r) {
            return calculateSolution(l, r, k, true);
        }
        return calculateSolution(r, l, k, false);
    }

    private String calculateSolution(long l, long r, long k, boolean left) {
        r -= k * (k + 1) / 2;
        if (r == l) {
            left = false;
        }
        long maxR = findMax(r, k, 0);
        r -= maxR * maxR + maxR * k;
        long maxL = findMax(l, k, 1);
        l -= maxL * (maxL + 1) + maxL * k;
        if (!left) {
            long temp = r;
            r = l;
            l = temp;
        }
        if (maxR == maxL) {
            return (k + 2 * maxL) + " " + l + " " + r;
        }
        return (k + 2 * maxR - 1) + " " + l + " " + r;
    }

    private long findMax(long target, long k, int c) {
        long low = 0;
        long high = (long) Math.sqrt(target) + 1;
        while (low + 1 < high) {
            long mid = (low + high) / 2;
            long temp = mid * (mid + c) + mid * k;
            if (temp > target) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return low;
    }

    private void runTests() {
        for (int l = 1; l <= 1000; ++l) {
            for (int r = 1; r <= 1000; ++r) {
                System.out.println(l + " " + r);
                String result1 = solveUsingMath(l, r);
                String result2 = solveUsingSubtraction(l, r);
                if (!result1.equals(result2)) {
                    System.out.println(l + " " + r + " " + result1 + " " + result2);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        Solution sol = new Solution();
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + sol.solve(in));
        }
    }
}