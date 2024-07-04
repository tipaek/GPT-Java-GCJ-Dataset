import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    static String inputString;

    public Solution() {}

    public static String solve() {
        StringBuilder result = new StringBuilder();
        int depth = 0;
        int previousValue = 0;

        for (int i = 0; i <= inputString.length(); i++) {
            int currentValue = (i < inputString.length()) ? Character.getNumericValue(inputString.charAt(i)) : 0;
            int delta = currentValue - previousValue;

            if (delta > 0) {
                result.append("(".repeat(delta));
                depth += delta;
            } else if (delta < 0) {
                result.append(")".repeat(-delta));
                depth += delta;
            }

            if (i < inputString.length()) {
                result.append(inputString.charAt(i));
            }

            previousValue = currentValue;
        }

        return result.toString();
    }

    public static final int DEBUG_TEST_CASE = 0;
    public static final boolean SIMULATE_TEST_CASES = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            inputString = scanner.next();

            if (DEBUG_TEST_CASE <= 0 || testCase == DEBUG_TEST_CASE) {
                String result = solve();
                System.out.println("Case #" + testCase + ": " + result);
            }
        }
    }
}