import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // Read number of test cases
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {

            // Read size of data
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            boolean isPossible = false;
            double valueIfSamePossible = (double) k / n;
            int minimalPossibleValue = n * (n + 1) / 2;

            System.err.println(valueIfSamePossible);
            System.err.println(minimalPossibleValue);

            if (valueIfSamePossible == Math.floor(valueIfSamePossible) && !Double.isInfinite(valueIfSamePossible)) {
                isPossible = true;
                System.out.println("Case #" + testCase + ": POSSIBLE");

                for (int row = 0; row < n; row++) {
                    for (int col = 0; col < n; col++) {
                        System.out.print((int) ((valueIfSamePossible - 1 - row + col + n) % n + 1) + " ");
                    }
                    System.out.println();
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }
}