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
                int n = Character.getNumericValue(input.charAt(i));

                if (n == 0 && openBrackets > 0) {
                    result.append(repeat(openBrackets, ')'));
                    openBrackets = 0;
                } else if (n > openBrackets) {
                    result.append(repeat(n - openBrackets, '('));
                    openBrackets = n;
                } else if (n < openBrackets) {
                    result.append(repeat(openBrackets - n, ')'));
                    openBrackets = n;
                }

                result.append(n);
            }

            if (openBrackets > 0) {
                result.append(repeat(openBrackets, ')'));
            }

            output.append("Case #").append(testCase + 1).append(": ").append(result);
            if (testCase + 1 < testCases) {
                output.append("\n");
            }
        }

        System.out.println(output);
    }

    private static String repeat(int count, char ch) {
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }
}