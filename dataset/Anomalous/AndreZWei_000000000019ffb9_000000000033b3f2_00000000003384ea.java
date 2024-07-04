import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            long left = scanner.nextLong();
            long right = scanner.nextLong();
            System.out.println("Case #" + i + ": " + solve(left, right));
        }
    }

    public static String solve(long left, long right) {
        long difference = Math.abs(right - left);
        long[] result = findSum(difference);

        long[] leftSolution = new long[2], rightSolution = new long[2];
        long leftRemaining = left, rightRemaining = right;

        if (left > right) {
            leftRemaining = left - result[1];
            leftSolution = findPartialSum(result[0] + 1, leftRemaining);
            rightSolution = findPartialSum(result[0] + 2, rightRemaining);
        } else {
            rightRemaining = right - result[1];
            if (leftRemaining == rightRemaining) {
                leftSolution = findPartialSum(result[0] + 1, leftRemaining);
                rightSolution = findPartialSum(result[0] + 2, rightRemaining);
            } else {
                leftSolution = findPartialSum(result[0] + 2, leftRemaining);
                rightSolution = findPartialSum(result[0] + 1, rightRemaining);
            }
        }

        long totalCount = result[0] + leftSolution[0] + rightSolution[0];
        return totalCount + " " + (leftRemaining - leftSolution[1]) + " " + (rightRemaining - rightSolution[1]);
    }

    private static long[] findSum(long target) {
        long low = 0, high = (long) 1e10;
        while (low < high) {
            long mid = high - (high - low) / 2;
            long sum = (1 + mid) * mid / 2;
            if (sum <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return new long[]{low, (1 + low) * low / 2};
    }

    private static long[] findPartialSum(long start, long target) {
        long low = 0, high = (long) 1e10;
        while (low < high) {
            long mid = high - (high - low) / 2;
            long sum = (start + mid - 1) * mid;
            if (sum > target) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        return new long[]{low, (start + low - 1) * low};
    }
}