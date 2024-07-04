import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        String[] results = new String[testCases];
        
        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            results[i] = createBalancedString(input);
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }

    public static String createBalancedString(String input) {
        char[] chars = input.toCharArray();
        StringBuilder result = new StringBuilder();
        int balance = 0;

        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                for (int k = '0'; k < chars[i]; k++) {
                    result.append("(");
                    balance++;
                }
            }

            result.append(chars[i]);

            if (i != chars.length - 1) {
                if (chars[i] < chars[i + 1]) {
                    for (int k = chars[i]; k < chars[i + 1]; k++) {
                        result.append("(");
                        balance++;
                    }
                } else if (chars[i] > chars[i + 1]) {
                    for (int k = chars[i + 1]; k < chars[i]; k++) {
                        result.append(")");
                        balance--;
                    }
                }
            }

            if (i == chars.length - 1) {
                while (balance > 0) {
                    result.append(")");
                    balance--;
                }
            }
        }

        return result.toString();
    }
}