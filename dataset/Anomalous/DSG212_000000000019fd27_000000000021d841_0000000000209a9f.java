import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            System.out.println("Case #" + i + ": " + createNestedString(input));
        }
        
        scanner.close();
    }

    private static String createNestedString(String input) {
        StringBuilder nestedString = new StringBuilder();
        int[] digits = input.chars().map(Character::getNumericValue).toArray();
        
        for (int i = 0; i < digits.length; i++) {
            if (i == 0) {
                nestedString.append(generateParentheses(digits[i], digits[i]));
            } else {
                int previousDigit = digits[i - 1];
                int currentDigit = digits[i];
                if (currentDigit > previousDigit) {
                    int diff = currentDigit - previousDigit;
                    String prefix = nestedString.substring(0, nestedString.length() - previousDigit);
                    String suffix = nestedString.substring(nestedString.length() - previousDigit);
                    String middle = generateParentheses(currentDigit, diff);
                    nestedString = new StringBuilder(prefix + middle + suffix);
                } else {
                    String prefix = nestedString.substring(0, nestedString.length() - currentDigit);
                    String suffix = nestedString.substring(nestedString.length() - currentDigit);
                    nestedString = new StringBuilder(prefix + currentDigit + suffix);
                }
            }
        }
        
        return nestedString.toString();
    }

    private static String generateParentheses(int number, int parenthesesCount) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < parenthesesCount; i++) {
            result.append('(');
        }
        
        result.append(number);
        
        for (int i = 0; i < parenthesesCount; i++) {
            result.append(')');
        }
        
        return result.toString();
    }
}