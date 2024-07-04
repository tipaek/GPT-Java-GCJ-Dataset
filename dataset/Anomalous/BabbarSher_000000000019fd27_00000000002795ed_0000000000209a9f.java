import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringJoiner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            scanner.nextLine();
            for (int i = 1; i <= testCases; i++) {
                String input = scanner.nextLine();
                String result = solve(input);
                System.out.println("Case #" + i + ": " + result);
            }
        }
    }

    private static String solve(String input) {
        StringBuilder result = new StringBuilder();
        int openedBraces = 0;

        for (char ch : input.toCharArray()) {
            int digit = Character.getNumericValue(ch);
            while (openedBraces < digit) {
                result.append('(');
                openedBraces++;
            }
            while (openedBraces > digit) {
                result.append(')');
                openedBraces--;
            }
            result.append(ch);
        }

        while (openedBraces > 0) {
            result.append(')');
            openedBraces--;
        }

        return result.toString();
    }
}