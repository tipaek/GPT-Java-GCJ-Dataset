import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char digitChar : input.toCharArray()) {
                int digit = Character.getNumericValue(digitChar);

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

            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}