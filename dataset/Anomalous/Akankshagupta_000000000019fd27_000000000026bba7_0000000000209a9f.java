import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            String inputString = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int previousValue = 0;

            for (int index = 0; index < inputString.length(); index++) {
                int currentValue = inputString.charAt(index) - '0';

                if (currentValue > previousValue) {
                    result.append("(".repeat(currentValue - previousValue));
                } else if (currentValue < previousValue) {
                    result.append(")".repeat(previousValue - currentValue));
                }

                result.append(currentValue);
                previousValue = currentValue;
            }

            result.append(")".repeat(previousValue));
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}