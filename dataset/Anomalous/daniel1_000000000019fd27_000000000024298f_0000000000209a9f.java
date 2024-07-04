import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static String solve(String s) {
        StringBuilder result = new StringBuilder();
        int openParentheses = 0;

        for (int i = 0; i < s.length(); i++) {
            int currentDigit = s.charAt(i) - '0';

            while (openParentheses > currentDigit) {
                result.append(')');
                openParentheses--;
            }
            while (openParentheses < currentDigit) {
                result.append('(');
                openParentheses++;
            }
            result.append(currentDigit);
        }

        while (openParentheses > 0) {
            result.append(')');
            openParentheses--;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            String input = scanner.next();
            String result = solve(input);
            System.out.println("Case #" + t + ": " + result);
        }
    }
}