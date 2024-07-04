import java.util.*;
import java.io.*;

public class Solution {

    public static long estimateDifference(long l, long r) {
        long difference = Math.abs(l - r);
        if (difference == 0) {
            return 0;
        }
        long estimate = (long) Math.sqrt(difference * 2);
        while ((estimate * (estimate + 1) / 2) > difference) {
            estimate--;
        }
        return estimate;
    }

    public static long calculateDoubleSum(long start, long end) {
        if (start % 2 != end % 2) {
            throw new IllegalStateException();
        }
        long n = (end - start) / 2;
        return (n + 1) * start + n * (n + 1);
    }

    public static long calculateCalls(long initialValue, long startStep) {
        long estimate = (long) Math.sqrt(initialValue);
        while (calculateDoubleSum(startStep, startStep + 2 * estimate) > initialValue) {
            estimate--;
        }
        estimate++;
        return estimate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        for (int i = 1; i <= testCaseCount; ++i) {
            long l = scanner.nextLong();
            long r = scanner.nextLong();

            long newL, newR, totalCalls, estimate;
            if (l > r) {
                estimate = estimateDifference(l, r);
                newL = l - estimate * (estimate + 1) / 2;
                newR = r;
            } else {
                estimate = estimateDifference(l, r);
                newL = l;
                newR = r - estimate * (estimate + 1) / 2;
            }

            if (newR > newL) {
                long callsL = calculateCalls(newL, estimate + 2);
                long callsR = calculateCalls(newR, estimate + 1);

                newL -= calculateDoubleSum(estimate + 2, estimate + 2 + 2 * (callsL - 1));
                newR -= calculateDoubleSum(estimate + 1, estimate + 1 + 2 * (callsR - 1));

                totalCalls = estimate + callsL + callsR;
            } else {
                long callsL = calculateCalls(newL, estimate + 1);
                long callsR = calculateCalls(newR, estimate + 2);

                newL -= calculateDoubleSum(estimate + 1, estimate + 1 + 2 * (callsL - 1));
                newR -= calculateDoubleSum(estimate + 2, estimate + 2 + 2 * (callsR - 1));

                totalCalls = estimate + callsL + callsR;
            }

            System.out.println("Case #" + i + ": " + totalCalls + " " + newL + " " + newR);
        }
    }
}