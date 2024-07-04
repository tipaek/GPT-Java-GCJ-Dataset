import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder output = new StringBuilder();

        for (int testCase = 0; testCase < testCases; testCase++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            for (int i = 0; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));

                if (currentDigit == 0 && openBrackets > 0) {
                    result.append(repeat(openBrackets, ")"));
                    openBrackets = 0;
                } else if (currentDigit > openBrackets) {
                    result.append(repeat(currentDigit - openBrackets, "("));
                    openBrackets = currentDigit;
                } else if (currentDigit < openBrackets) {
                    result.append(repeat(openBrackets - currentDigit, ")"));
                    openBrackets = currentDigit;
                }

                result.append(currentDigit);
            }

            if (openBrackets > 0) {
                result.append(repeat(openBrackets, ")"));
            }

            output.append("Case #").append(testCase + 1).append(": ").append(result);
            if (testCase + 1 < testCases) {
                output.append("\n");
            }
        }

        System.out.println(output.toString());
    }

    private static String repeat(int count, String str) {
        StringBuilder repeated = new StringBuilder();
        for (int i = 0; i < count; i++) {
            repeated.append(str);
        }
        return repeated.toString();
    }
}