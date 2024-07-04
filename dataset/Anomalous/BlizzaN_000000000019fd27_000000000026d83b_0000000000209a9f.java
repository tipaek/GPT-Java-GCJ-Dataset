import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static String solve(String input) {
        StringBuilder sb = new StringBuilder();
        char[] chars = input.toCharArray();
        int length = chars.length;

        // Add opening brackets for the first character
        int firstDigit = Character.getNumericValue(chars[0]);
        for (int i = 0; i < firstDigit; i++) {
            sb.append("(");
        }
        sb.append(chars[0]);

        // Process the rest of the characters
        for (int i = 1; i < length; i++) {
            int currentDigit = Character.getNumericValue(chars[i]);
            int previousDigit = Character.getNumericValue(chars[i - 1]);
            int diff = currentDigit - previousDigit;

            if (diff > 0) {
                for (int j = 0; j < diff; j++) {
                    sb.append("(");
                }
            } else {
                for (int j = 0; j < -diff; j++) {
                    sb.append(")");
                }
            }
            sb.append(chars[i]);
        }

        // Add closing brackets for the last character
        for (int i = 0; i < firstDigit; i++) {
            sb.append(")");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        InputStream is = System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                String input = scanner.next();
                System.out.println("Case #" + testNumber + ": " + solve(input));
            }
        }
    }
}