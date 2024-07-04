import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String number = scanner.nextLine();
            processNumberWithBraces(number, caseNumber);
        }
    }

    private static void processNumberWithBraces(String number, int caseNumber) {
        StringBuilder result = new StringBuilder();
        int previousDigit = Character.getNumericValue(number.charAt(0));

        if (previousDigit == 1) {
            result.append("(").append(previousDigit);
        } else {
            result.append(previousDigit);
        }

        for (int i = 1; i < number.length(); i++) {
            int currentDigit = Character.getNumericValue(number.charAt(i));

            if (currentDigit == 0) {
                if (previousDigit == 1) {
                    result.append(")");
                }
                result.append(currentDigit);
            } else {
                if (previousDigit == 0) {
                    result.append("(");
                }
                result.append(currentDigit);
            }

            previousDigit = currentDigit;
        }

        if (previousDigit == 1) {
            result.append(")");
        }

        System.out.println("Case #" + caseNumber + ": " + result);
    }
}