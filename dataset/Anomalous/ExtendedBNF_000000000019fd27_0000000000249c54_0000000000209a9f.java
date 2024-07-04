import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        for (int testCase = 1; testCase <= numberOfTests; testCase++) {
            System.out.print("Case #" + testCase + ": ");
            processTestCase(scanner);
        }
    }

    private static void processTestCase(Scanner scanner) {
        String input = scanner.next();
        StringBuilder output = new StringBuilder();
        int previousDigit = 0;

        for (int index = 0; index < input.length(); index++) {
            int currentDigit = Character.getNumericValue(input.charAt(index));
            int difference = currentDigit - previousDigit;

            if (difference > 0) {
                output.append("(".repeat(difference));
            } else if (difference < 0) {
                output.append(")".repeat(-difference));
            }

            output.append(currentDigit);
            previousDigit = currentDigit;
        }

        output.append(")".repeat(previousDigit));
        System.out.println(output);
    }
}