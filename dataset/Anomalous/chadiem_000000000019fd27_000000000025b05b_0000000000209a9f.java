import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        List<TestCase> testCases = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            int numberOfTestCases = scanner.nextInt();
            for (int i = 0; i < numberOfTestCases; i++) {
                TestCase testCase = new TestCase();
                testCase.parse(scanner);
                testCases.add(testCase);
            }
        }

        for (int i = 0; i < testCases.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + testCases.get(i).solve());
        }
    }

    private static class TestCase {
        private String input;

        public void parse(Scanner scanner) {
            input = scanner.next();
        }

        public String solve() {
            StringBuilder result = new StringBuilder();
            int previousValue = 0;

            for (char ch : input.toCharArray()) {
                int currentValue = Character.getNumericValue(ch);

                if (currentValue > previousValue) {
                    result.append(repeat("(", currentValue - previousValue));
                } else if (currentValue < previousValue) {
                    result.append(repeat(")", previousValue - currentValue));
                }

                result.append(currentValue);
                previousValue = currentValue;
            }

            result.append(repeat(")", previousValue));
            return result.toString();
        }

        private String repeat(String str, int count) {
            return String.join("", Collections.nCopies(count, str));
        }
    }
}