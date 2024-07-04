import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= numCases; i++) {
            String inputString = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int previousDigit = Character.getNumericValue(inputString.charAt(0));
            appendBrackets(result, '(', previousDigit);

            for (int j = 0; j < inputString.length() - 1; j++) {
                int currentDigit = Character.getNumericValue(inputString.charAt(j));
                int nextDigit = Character.getNumericValue(inputString.charAt(j + 1));

                if (currentDigit < previousDigit) {
                    // appendClose(result, previousDigit - currentDigit);
                } else if (currentDigit > previousDigit) {
                    appendBrackets(result, '(', currentDigit - previousDigit);
                }

                result.append(currentDigit);

                if (currentDigit < nextDigit) {
                    appendBrackets(result, '(', nextDigit - currentDigit);
                } else if (currentDigit > nextDigit) {
                    appendBrackets(result, ')', currentDigit - nextDigit);
                }

                previousDigit = currentDigit;
            }

            int lastDigit = Character.getNumericValue(inputString.charAt(inputString.length() - 1));
            result.append(lastDigit);
            appendBrackets(result, ')', lastDigit);

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }

    private static void appendBrackets(StringBuilder builder, char bracketType, int count) {
        for (int i = 0; i < count; i++) {
            builder.append(bracketType);
        }
    }
}