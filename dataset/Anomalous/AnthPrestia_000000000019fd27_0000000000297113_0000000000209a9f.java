import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static String generateParentheses(String input) {
        StringBuilder result = new StringBuilder();
        int openParentheses = 0;

        for (int i = 0; i < input.length(); i++) {
            int currentDigit = Character.getNumericValue(input.charAt(i));
            while (openParentheses > currentDigit) {
                result.append(")");
                openParentheses--;
            }
            while (currentDigit > openParentheses) {
                result.append("(");
                openParentheses++;
            }
            result.append(input.charAt(i));
        }
        while (openParentheses > 0) {
            result.append(")");
            openParentheses--;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            String output = generateParentheses(input);
            System.out.println("Case #" + i + ": " + output);
        }
    }
}