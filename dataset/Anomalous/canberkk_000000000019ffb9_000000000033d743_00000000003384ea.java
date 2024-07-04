import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);

        long numberOfCases = scanner.nextLong();

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            String resultPrefix = "Case #" + caseIndex + ": ";

            long leftPile = scanner.nextLong();
            long rightPile = scanner.nextLong();

            long difference = Math.abs(leftPile - rightPile);
            long steps = (long) Math.sqrt(difference * 2);

            // Sanity checks
            if ((steps * (steps + 1)) / 2 > difference) steps--;
            if ((steps * (steps + 1)) / 2 > difference) System.exit(1);
            if (((steps + 1) * (steps + 2)) / 2 <= difference) System.exit(2);

            if (rightPile > leftPile) {
                rightPile -= (steps * (steps + 1)) / 2;
            } else {
                leftPile -= (steps * (steps + 1)) / 2;
            }

            long maxRightSteps, maxLeftSteps;

            if (rightPile > leftPile) {
                maxRightSteps = calculateMaxSteps(rightPile, steps + 1);
                maxLeftSteps = calculateMaxSteps(leftPile, steps + 2);
                rightPile -= ((steps + 1) + maxRightSteps - 1) * maxRightSteps;
                leftPile -= ((steps + 2) + maxLeftSteps - 1) * maxLeftSteps;
                steps += maxLeftSteps + maxRightSteps;
            } else {
                maxLeftSteps = calculateMaxSteps(leftPile, steps + 1);
                maxRightSteps = calculateMaxSteps(rightPile, steps + 2);
                leftPile -= ((steps + 1) + maxLeftSteps - 1) * maxLeftSteps;
                rightPile -= ((steps + 2) + maxRightSteps - 1) * maxRightSteps;
                steps += maxLeftSteps + maxRightSteps;
            }

            writer.println(resultPrefix + steps + " " + leftPile + " " + rightPile);
        }

        scanner.close();
        writer.close();
    }

    // Binary search to determine the maximum number of possible steps
    static long calculateMaxSteps(long target, long startStep) {
        long low = 0;
        long high = target / startStep;
        while (low + 1 < high) {
            long mid = (low + high + 1) / 2;
            long value = (startStep + mid - 1) * mid;
            if (value > target) {
                high = mid;
            } else if (value < target) {
                low = mid;
            } else {
                return mid;
            }
        }
        return (startStep + low) * (low + 1) <= target ? low + 1 : low;
    }
}