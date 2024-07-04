import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static final int ZERO_ASCII = '0';

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfCases = scanner.nextInt();
            for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
                String inputString = scanner.next();
                System.out.println("Case #" + caseNumber + ": " + solve(inputString));
            }
        }
    }

    private static String solve(String input) {
        StringBuilder result = new StringBuilder();
        int openBrackets = 0;

        for (char c : input.toCharArray()) {
            int number = c - ZERO_ASCII;

            while (openBrackets < number) {
                result.append('(');
                openBrackets++;
            }
            while (openBrackets > number) {
                result.append(')');
                openBrackets--;
            }

            result.append(number);
        }

        while (openBrackets > 0) {
            result.append(')');
            openBrackets--;
        }

        return result.toString();
    }
}