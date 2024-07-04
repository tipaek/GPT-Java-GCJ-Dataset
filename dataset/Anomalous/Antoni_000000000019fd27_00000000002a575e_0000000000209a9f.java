import java.util.Scanner;

public class Solution {

    private static int openParenthesesCount = 0;

    public static void main(String[] args) {
        processCodeJam();
    }

    public static void processCodeJam() {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            openParenthesesCount = 0;
            String inputLine = scanner.nextLine();
            StringBuilder resultBuilder = new StringBuilder();
            resultBuilder.append("Case #").append(caseIndex + 1).append(": ");
            processLine(inputLine, resultBuilder);
        }

        scanner.close();
    }

    private static void processLine(String line, StringBuilder resultBuilder) {
        int previousDigit = 0;

        for (int charIndex = 0; charIndex < line.length(); charIndex++) {
            int currentDigit = Character.getNumericValue(line.charAt(charIndex));
            adjustParentheses(currentDigit - openParenthesesCount, resultBuilder);
            resultBuilder.append(currentDigit);

            int nextDigit = (charIndex < line.length() - 1) ? Character.getNumericValue(line.charAt(charIndex + 1)) : 0;
            adjustParentheses(openParenthesesCount - nextDigit, resultBuilder);

            previousDigit = currentDigit;
        }

        System.out.println(resultBuilder);
    }

    private static void adjustParentheses(int difference, StringBuilder resultBuilder) {
        for (int i = 0; i < Math.abs(difference); i++) {
            if (difference > 0) {
                resultBuilder.append("(");
                openParenthesesCount++;
            } else {
                resultBuilder.append(")");
                openParenthesesCount--;
            }
        }
    }
}