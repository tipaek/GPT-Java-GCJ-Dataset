import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = sc.nextInt();

        for (int i = 1; i <= numCases; i++) {
            String inputString = sc.next();
            String primeString = nestString(0, inputString);
            System.out.println("Case #" + i + ": " + primeString);
        }

        sc.close();
    }

    private static String nestString(int depth, String inputString) {
        if (inputString.isEmpty()) {
            return closeParentheses(depth);
        }

        int currentDigit = inputString.charAt(0) - '0';
        String remainingString = inputString.substring(1);

        if (currentDigit == depth) {
            return currentDigit + nestString(depth, remainingString);
        } else if (currentDigit > depth) {
            return "(" + nestString(depth + 1, inputString);
        } else {
            return ")" + nestString(depth - 1, inputString);
        }
    }

    private static String closeParentheses(int depth) {
        StringBuilder closing = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            closing.append(")");
        }
        return closing.toString();
    }
}