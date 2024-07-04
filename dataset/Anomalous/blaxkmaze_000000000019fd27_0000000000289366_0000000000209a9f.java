import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static String nestingDepth(String input) {
        StringBuilder result = new StringBuilder();
        int openBrackets = 0;

        for (char ch : input.toCharArray()) {
            int digit = ch - '0';

            while (openBrackets < digit) {
                result.append('(');
                openBrackets++;
            }
            while (openBrackets > digit) {
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
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.nextLine();
            String output = nestingDepth(input);
            System.out.println("Case #" + i + ": " + output);
        }

        scanner.close();
    }
}