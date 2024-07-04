import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        StringBuilder output = new StringBuilder();

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            for (char c : input.toCharArray()) {
                int digit = Character.getNumericValue(c);

                while (openBrackets < digit) {
                    result.append("(");
                    openBrackets++;
                }

                while (openBrackets > digit) {
                    result.append(")");
                    openBrackets--;
                }

                result.append(digit);
            }

            while (openBrackets > 0) {
                result.append(")");
                openBrackets--;
            }

            output.append("Case #").append(testCase).append(": ").append(result);
            if (testCase < testCaseCount) {
                output.append("\n");
            }
        }

        System.out.println(output.toString());
    }
}