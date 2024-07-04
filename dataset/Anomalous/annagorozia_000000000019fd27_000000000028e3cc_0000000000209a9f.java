import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        short testCases = Short.parseShort(scanner.nextLine());

        for (int i = 0; i < testCases; i++) {
            String input = scanner.nextLine();
            String result = addParentheses(input);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }

        scanner.close();
    }

    private static String addParentheses(String input) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char c : input.toCharArray()) {
            int num = Character.getNumericValue(c);

            while (currentDepth < num) {
                result.append('(');
                currentDepth++;
            }
            while (currentDepth > num) {
                result.append(')');
                currentDepth--;
            }

            result.append(num);
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        return result.toString();
    }
}