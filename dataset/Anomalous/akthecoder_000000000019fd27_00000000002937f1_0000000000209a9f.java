import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            String number = scanner.nextLine();
            System.out.println("Case #" + (i + 1) + ": " + calculateNestingDepth(number));
        }

        scanner.close();
    }

    public static String calculateNestingDepth(String number) {
        StringBuilder result = new StringBuilder();
        int previousDigit = 0;

        for (int i = 0; i < number.length(); i++) {
            int currentDigit = Character.getNumericValue(number.charAt(i));

            if (currentDigit > previousDigit) {
                result.append("(".repeat(currentDigit - previousDigit));
            } else if (currentDigit < previousDigit) {
                result.append(")".repeat(previousDigit - currentDigit));
            }

            result.append(currentDigit);
            previousDigit = currentDigit;
        }

        result.append(")".repeat(previousDigit));

        return result.toString();
    }
}