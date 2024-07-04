import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        final boolean DEBUG = false;
        Scanner scanner = null;
        try {
            if (DEBUG) {
                scanner = new Scanner(new FileInputStream("test.in"));
            } else {
                scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            System.out.println("Case #" + i + ": " + calculateNestingDepth(input));
        }
    }

    private static String calculateNestingDepth(String input) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char c : input.toCharArray()) {
            int digit = Character.getNumericValue(c);

            while (currentDepth < digit) {
                result.append('(');
                currentDepth++;
            }

            while (currentDepth > digit) {
                result.append(')');
                currentDepth--;
            }

            result.append(digit);
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        return result.toString();
    }
}