import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfCases; i++) {
            String inputString = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int previousValue = 0;

            for (int j = 0; j < inputString.length(); j++) {
                int currentValue = inputString.charAt(j) - '0';
                int difference = currentValue - previousValue;

                if (difference > 0) {
                    for (int k = 0; k < difference; k++) {
                        result.append("(");
                    }
                } else if (difference < 0) {
                    for (int k = 0; k < -difference; k++) {
                        result.append(")");
                    }
                }

                result.append(currentValue);
                previousValue = currentValue;
            }

            for (int k = 0; k < previousValue; k++) {
                result.append(")");
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }

        scanner.close();
    }
}