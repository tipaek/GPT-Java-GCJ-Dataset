import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; ++i) {
            String input = scanner.nextLine();
            String result = processInput(input);
            result += appendRightBrackets(input.charAt(input.length() - 1) - '0');
            System.out.println("Case #" + i + ": " + result);
        }
    }

    static String processInput(String input) {
        char[] inputChars = input.toCharArray();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < inputChars.length; i++) {
            if (i == 0) {
                result.append(appendLeftBrackets(inputChars[i] - '0')).append(inputChars[i]);
                continue;
            }

            int current = inputChars[i] - '0';
            int previous = inputChars[i - 1] - '0';

            if (previous > current) {
                result.append(appendRightBrackets(previous - current)).append(inputChars[i]);
            } else if (previous == current) {
                result.append(current);
            } else {
                result.append(appendLeftBrackets(current - previous)).append(inputChars[i]);
            }
        }

        return result.toString();
    }

    static String appendLeftBrackets(int count) {
        StringBuilder result = new StringBuilder();
        while (count > 0) {
            result.append("(");
            count--;
        }
        return result.toString();
    }

    static String appendRightBrackets(int count) {
        StringBuilder result = new StringBuilder();
        while (count > 0) {
            result.append(")");
            count--;
        }
        return result.toString();
    }
}