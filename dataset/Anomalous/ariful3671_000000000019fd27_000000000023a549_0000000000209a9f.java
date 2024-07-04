import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        int caseNo = 1;

        while (t > 0) {
            String s = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int previousDigit = 0;

            for (int i = 0; i < s.length(); i++) {
                int currentDigit = Character.getNumericValue(s.charAt(i));

                if (i == 0) {
                    appendParentheses(result, currentDigit);
                } else {
                    if (currentDigit > previousDigit) {
                        appendParentheses(result, currentDigit - previousDigit);
                    } else if (currentDigit < previousDigit) {
                        appendClosingParentheses(result, previousDigit - currentDigit);
                    }
                }

                result.append(s.charAt(i));
                previousDigit = currentDigit;
            }

            appendClosingParentheses(result, previousDigit);
            System.out.println("Case #" + caseNo + ": " + result.toString());
            caseNo++;
            t--;
        }
    }

    private static void appendParentheses(StringBuilder result, int count) {
        for (int j = 0; j < count; j++) {
            result.append("(");
        }
    }

    private static void appendClosingParentheses(StringBuilder result, int count) {
        for (int j = 0; j < count; j++) {
            result.append(")");
        }
    }
}