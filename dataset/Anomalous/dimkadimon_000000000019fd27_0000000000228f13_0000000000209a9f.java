import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.nextLine();
            String result = solve(input);
            System.out.println("Case #" + caseNumber + ": " + result);
        }

        scanner.close();
    }

    public static String solve(String input) {
        StringBuilder output = new StringBuilder();
        int openParentheses = 0;

        for (int i = 0; i < input.length(); i++) {
            int currentDigit = input.charAt(i) - '0';
            if (currentDigit > openParentheses) {
                for (int j = 0; j < currentDigit - openParentheses; j++) {
                    output.append('(');
                }
            } else if (currentDigit < openParentheses) {
                for (int j = 0; j < openParentheses - currentDigit; j++) {
                    output.append(')');
                }
            }
            openParentheses = currentDigit;
            output.append(currentDigit);
        }

        for (int i = 0; i < openParentheses; i++) {
            output.append(')');
        }

        return output.toString();
    }
}