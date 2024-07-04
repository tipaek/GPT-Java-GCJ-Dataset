import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            int[] digits = new int[input.length()];
            for (int j = 0; j < input.length(); j++) {
                digits[j] = input.charAt(j) - '0';
            }
            StringBuilder result = new StringBuilder();
            int currentDepth = digits[0];
            result.append(repeat("(", currentDepth));
            result.append(digits[0]);
            for (int j = 1; j < input.length(); j++) {
                int difference = digits[j] - currentDepth;
                if (difference > 0) {
                    result.append(repeat("(", difference));
                } else if (difference < 0) {
                    result.append(repeat(")", -difference));
                }
                result.append(digits[j]);
                currentDepth = digits[j];
            }
            result.append(repeat(")", currentDepth));
            System.out.println("Case #" + i + ": " + result);
        }
        scanner.close();
    }

    private static String repeat(String str, int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(str);
        }
        return builder.toString();
    }
}