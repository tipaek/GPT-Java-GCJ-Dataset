import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = scanner.next();
            String result = addMinimumParentheses(inputString);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static String addMinimumParentheses(String input) {
        StringBuilder resultBuilder = new StringBuilder();
        int openParentheses = 0;

        for (char ch : input.toCharArray()) {
            int digit = Character.getNumericValue(ch);

            while (openParentheses < digit) {
                resultBuilder.append("(");
                openParentheses++;
            }

            while (openParentheses > digit) {
                resultBuilder.append(")");
                openParentheses--;
            }

            resultBuilder.append(digit);
        }

        while (openParentheses > 0) {
            resultBuilder.append(")");
            openParentheses--;
        }

        return resultBuilder.toString();
    }
}