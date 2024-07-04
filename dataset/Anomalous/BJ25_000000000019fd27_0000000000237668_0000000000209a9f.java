import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        StringBuilder resultBuilder = new StringBuilder();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String inputString = scanner.next();
            String parenthesesString = generateParentheses(inputString);
            resultBuilder.append(formatResult(caseNum, parenthesesString));
        }

        scanner.close();
        System.out.print(resultBuilder.toString());
    }

    private static String generateParentheses(String s) {
        StringBuilder parenthesesBuilder = new StringBuilder();
        int openParentheses = 0;
        int previousDigit = 0;

        for (char c : s.toCharArray()) {
            int currentDigit = Character.getNumericValue(c);

            if (currentDigit > previousDigit) {
                for (int j = 0; j < currentDigit - previousDigit; j++) {
                    parenthesesBuilder.append("(");
                    openParentheses++;
                }
            } else if (currentDigit < previousDigit) {
                for (int j = 0; j < previousDigit - currentDigit; j++) {
                    parenthesesBuilder.append(")");
                    openParentheses--;
                }
            }

            parenthesesBuilder.append(c);
            previousDigit = currentDigit;
        }

        for (int j = 0; j < openParentheses; j++) {
            parenthesesBuilder.append(")");
        }

        return parenthesesBuilder.toString();
    }

    private static String formatResult(int caseNum, String result) {
        return "Case #" + caseNum + ": " + result + "\n";
    }
}