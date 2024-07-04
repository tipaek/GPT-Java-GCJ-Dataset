import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    private static String solve(String s) {
        StringBuilder result = new StringBuilder();
        int openBrackets = 0;

        for (char ch : s.toCharArray()) {
            int currentDigit = ch - '0';

            while (openBrackets < currentDigit) {
                result.append('(');
                openBrackets++;
            }

            while (openBrackets > currentDigit) {
                result.append(')');
                openBrackets--;
            }

            result.append(ch);
        }

        while (openBrackets > 0) {
            result.append(')');
            openBrackets--;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.nextLine().trim();
            String result = solve(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}