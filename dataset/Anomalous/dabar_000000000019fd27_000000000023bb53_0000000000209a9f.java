import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfCases; i++) {
            TestCase testCase = new TestCase(scanner.nextLine());
            System.out.println("Case #" + (i + 1) + ": " + testCase.getResult());
        }
    }

    public static class TestCase {
        private final String data;
        private final int length;

        public TestCase(String data) {
            this.data = data;
            this.length = data.length();
        }

        public String getResult() {
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            for (int i = 0; i < length; i++) {
                int currentDigit = Character.getNumericValue(data.charAt(i));

                if (currentDigit > openBrackets) {
                    int diff = currentDigit - openBrackets;
                    result.append("(".repeat(diff));
                    openBrackets += diff;
                } else if (currentDigit < openBrackets) {
                    int diff = openBrackets - currentDigit;
                    result.append(")".repeat(diff));
                    openBrackets -= diff;
                }

                result.append(currentDigit);
            }

            result.append(")".repeat(openBrackets));

            return result.toString();
        }
    }
}