import java.util.Scanner;

public class Solution {

    private static int getDigitAt(String number, int index) {
        return Character.getNumericValue(number.charAt(index));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int currentDepth = 0;
            String numberString = scanner.nextLine();
            StringBuilder resultBuilder = new StringBuilder();

            for (int i = 0; i < numberString.length(); i++) {
                int currentDigit = getDigitAt(numberString, i);

                // Increase depth
                while (currentDigit > currentDepth) {
                    resultBuilder.append('(');
                    currentDepth++;
                }

                // Decrease depth
                while (currentDigit < currentDepth) {
                    resultBuilder.append(')');
                    currentDepth--;
                }

                // Append the current digit
                resultBuilder.append(currentDigit);
            }

            // Close remaining open parentheses
            while (currentDepth > 0) {
                resultBuilder.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + caseNumber + ": " + resultBuilder.toString());
        }

        scanner.close();
    }
}