import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int previousDigit = Character.getNumericValue(input.charAt(0));

            // Add opening parentheses for the first digit
            for (int j = 0; j < previousDigit; j++) {
                result.append("(");
            }
            result.append(input.charAt(0));

            // Process the rest of the digits
            for (int j = 1; j < input.length(); j++) {
                int currentDigit = Character.getNumericValue(input.charAt(j));
                if (currentDigit > previousDigit) {
                    for (int k = 0; k < currentDigit - previousDigit; k++) {
                        result.append("(");
                    }
                } else if (currentDigit < previousDigit) {
                    for (int k = 0; k < previousDigit - currentDigit; k++) {
                        result.append(")");
                    }
                }
                result.append(input.charAt(j));
                previousDigit = currentDigit;
            }

            // Add closing parentheses for the last digit
            for (int j = 0; j < previousDigit; j++) {
                result.append(")");
            }

            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }
    }
}