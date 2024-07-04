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

    private static String solve(long left, long right) {
        long difference = Math.abs(right - left);
        long[] result = binarySearchForSum(difference);

        long[] solution = new long[2];
        long remainingLeft = left, remainingRight = right;

        if (left > right) {
            remainingLeft = left - result[1];
            solution = binarySearchForPartialSum(result[0] + 1, remainingLeft);
            if (solution[0] != 0) {
                remainingRight -= (solution[1] - solution[0]);
                remainingLeft -= solution[1];
            }
        } else {
            remainingRight = right - result[1];
            solution = binarySearchForPartialSum(result[0] + 2, remainingRight);
            if (solution[0] != 0) {
                remainingLeft -= (solution[1] - solution[0]);
                remainingRight -= solution[1];
            }
        }

        long count = result[0] + 2 * solution[0];
        if (remainingLeft >= result[0] + 2 * solution[0] + 1) {
            remainingLeft -= result[0] + 2 * solution[0] + 1;
            count++;
        }
        if (remainingRight >= result[0] + 2 * solution[0] + 1) {
            remainingRight -= result[0] + 2 * solution[0] + 1;
            count++;
        }

        return count + " " + remainingLeft + " " + remainingRight;
    }

    private static long[] binarySearchForSum(long target) {
        long left = 0, right = (long) 1e10;
        while (left < right) {
            long mid = left + (right - left) / 2;
            long sum = (1 + mid) * mid / 2;
            if (sum >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return new long[]{left, (1 + left) * left / 2};
    }

    private static long[] binarySearchForPartialSum(long start, long target) {
        long left = 0, right = (long) 1e10;
        while (left < right) {
            long mid = right - (right - left) / 2;
            long sum = (start + mid - 1) * mid;
            if (sum > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return new long[]{left, (start + left - 1) * left};
    }
}