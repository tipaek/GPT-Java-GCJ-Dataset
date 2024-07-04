import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);

        long numberOfCases = scanner.nextLong();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            String result = "Case #" + caseNumber + ": ";

            long left = scanner.nextLong();
            long right = scanner.nextLong();

            long difference = Math.abs(left - right);
            long steps = (long) Math.sqrt(2 * difference);

            // Adjust steps to ensure it does not exceed the difference
            if ((steps * (steps + 1)) / 2 > difference) steps--;
            if ((steps * (steps + 1)) / 2 > difference) System.exit(1);
            if (((steps + 1) * (steps + 2)) / 2 <= difference) System.exit(2);

            if (right > left) {
                right -= (steps * (steps + 1)) / 2;
            } else {
                left -= (steps * (steps + 1)) / 2;
            }

            long maxStepsRight, maxStepsLeft;

            if (right > left) {
                maxStepsRight = findMaxSteps(right, steps + 1);
                maxStepsLeft = findMaxSteps(left, steps + 2);
                right -= (steps + 1 + maxStepsRight - 1) * maxStepsRight;
                left -= (steps + 2 + maxStepsLeft - 1) * maxStepsLeft;
                steps += maxStepsLeft + maxStepsRight;
            } else {
                maxStepsLeft = findMaxSteps(left, steps + 1);
                maxStepsRight = findMaxSteps(right, steps + 2);
                left -= (steps + 1 + maxStepsLeft - 1) * maxStepsLeft;
                right -= (steps + 2 + maxStepsRight - 1) * maxStepsRight;
                steps += maxStepsLeft + maxStepsRight;
            }

            writer.println(result + steps + " " + left + " " + right);
        }

        scanner.close();
        writer.close();
    }

    // Binary search to find the maximum number of steps possible
    static long findMaxSteps(long target, long start) {
        long low = 0;
        long high = target / start;
        while (low + 1 < high) {
            long mid = (low + high + 1) / 2;
            long value = (start + mid - 1) * mid;
            if (value > target) {
                high = mid;
            } else if (value < target) {
                low = mid;
            } else {
                return mid;
            }
        }
        return low;
    }
}