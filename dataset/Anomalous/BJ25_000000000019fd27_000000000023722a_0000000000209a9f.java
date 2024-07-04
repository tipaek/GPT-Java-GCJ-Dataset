import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        StringBuilder output = new StringBuilder();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String input = scanner.next();
            String result = generateParentheses(input);
            output.append(formatResult(caseNum, result));
        }

        scanner.close();
        System.out.print(output.toString());
    }

    private static String generateParentheses(String input) {
        StringBuilder result = new StringBuilder();
        int openParentheses = 0;
        int previousDigit = 0;

        for (char ch : input.toCharArray()) {
            int currentDigit = Character.getNumericValue(ch);

            if (currentDigit > previousDigit) {
                result.append("(".repeat(currentDigit - previousDigit));
                openParentheses += currentDigit - previousDigit;
            } else if (currentDigit < previousDigit) {
                result.append(")".repeat(previousDigit - currentDigit));
                openParentheses -= previousDigit - currentDigit;
            }

            result.append(currentDigit);
            previousDigit = currentDigit;
        }

        result.append(")".repeat(openParentheses));
        return result.toString();
    }

    private static String formatResult(int caseNum, String result) {
        return "Case #" + caseNum + ": " + result + "\n";
    }
}