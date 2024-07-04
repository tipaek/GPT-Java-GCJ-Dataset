import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTests = scanner.nextInt();
        
        for (int i = 0; i < numTests; i++) {
            String testCaseInput = scanner.next();
            System.out.println("Case #" + (i + 1) + ": " + insertNestingParens(testCaseInput));
        }
        
        scanner.close();
    }

    private static String insertNestingParens(String input) {
        StringBuilder result = new StringBuilder();
        int currentLevel = 0;

        for (char ch : input.toCharArray()) {
            int digit = Character.getNumericValue(ch);
            result.append(generateParens(digit - currentLevel)).append(digit);
            currentLevel = digit;
        }
        
        result.append(generateParens(-currentLevel));
        return result.toString();
    }

    private static String generateParens(int count) {
        StringBuilder parens = new StringBuilder();
        char parenChar = count < 0 ? ')' : '(';
        
        for (int i = 0; i < Math.abs(count); i++) {
            parens.append(parenChar);
        }
        
        return parens.toString();
    }
}