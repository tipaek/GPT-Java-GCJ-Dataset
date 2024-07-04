import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int previousDigit = Character.getNumericValue(input.charAt(0));

            for (int i = 0; i < previousDigit; i++) {
                result.append("(");
            }
            result.append(previousDigit);

            for (int i = 1; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));
                int difference = currentDigit - previousDigit;

                if (difference > 0) {
                    for (int j = 0; j < difference; j++) {
                        result.append("(");
                    }
                } else {
                    for (int j = 0; j < -difference; j++) {
                        result.append(")");
                    }
                }

                result.append(currentDigit);
                previousDigit = currentDigit;
            }

            for (int i = 0; i < previousDigit; i++) {
                result.append(")");
            }

            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
        scanner.close();
    }
}