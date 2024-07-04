import java.util.*;
import java.util.stream.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numTests = input.nextInt();
        
        for (int i = 0; i < numTests; i++) {
            String inputString = input.next();
            int[] digits = parseDigits(inputString);
            String result = generateParenthesesString(digits);
            System.out.println(result);
        }
    }

    private static int[] parseDigits(String input) {
        return input.chars()
                    .map(Character::getNumericValue)
                    .toArray();
    }

    private static String generateParenthesesString(int[] digits) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (int digit : digits) {
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