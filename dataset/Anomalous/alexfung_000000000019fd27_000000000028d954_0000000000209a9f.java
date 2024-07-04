import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            String inputString = scanner.next();
            StringBuilder result = new StringBuilder();
            int previousValue = 0;

            for (int i = 0; i < inputString.length(); i++) {
                int currentValue = Character.getNumericValue(inputString.charAt(i));
                int difference = currentValue - previousValue;

                if (difference > 0) {
                    result.append("(".repeat(difference));
                } else if (difference < 0) {
                    result.append(")".repeat(-difference));
                }

                result.append(inputString.charAt(i));
                previousValue = currentValue;
            }

            result.append(")".repeat(previousValue));

            System.out.println(String.format("Case #%d: %s", testCase, result));
        }

        scanner.close();
    }
}