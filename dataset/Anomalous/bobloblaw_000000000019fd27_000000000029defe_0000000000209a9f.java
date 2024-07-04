import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        
        for (int testCase = 1; testCase <= numberOfTests; testCase++) {
            String input = scanner.next();
            System.out.printf("Case #%d: %s\n", testCase, generateNestedString(input, 0));
        }
    }

    private static String generateNestedString(String input, int outerLevel) {
        if (input.length() == 1) {
            int digit = Character.getNumericValue(input.charAt(0));
            return createRepeatedString('(', digit - outerLevel) + input + createRepeatedString(')', digit - outerLevel);
        }

        int minDigit = input.chars().map(Character::getNumericValue).min().orElse(-1);
        int firstDigit = Character.getNumericValue(input.charAt(0));

        if (firstDigit <= minDigit) {
            return createRepeatedString('(', minDigit - outerLevel) 
                    + input.charAt(0) 
                    + generateNestedString(input.substring(1), minDigit) 
                    + createRepeatedString(')', minDigit - outerLevel);
        } else {
            return createRepeatedString('(', minDigit - outerLevel) 
                    + createRepeatedString('(', firstDigit - minDigit) 
                    + input.charAt(0) 
                    + createRepeatedString(')', firstDigit - minDigit) 
                    + generateNestedString(input.substring(1), minDigit) 
                    + createRepeatedString(')', minDigit - outerLevel);
        }
    }

    private static String createRepeatedString(char character, int count) {
        StringBuilder repeatedString = new StringBuilder();
        for (int i = 0; i < count; i++) {
            repeatedString.append(character);
        }
        return repeatedString.toString();
    }
}