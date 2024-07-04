import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < testCases; t++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();

            char[] digits = input.toCharArray();
            int previousValue = 0;
            int openBrackets = 0;

            for (char digit : digits) {
                int currentValue = Character.getNumericValue(digit);

                if (currentValue > previousValue) {
                    for (int i = 0; i < (currentValue - previousValue); i++) {
                        result.append("(");
                        openBrackets++;
                    }
                } else if (currentValue < previousValue) {
                    for (int i = 0; i < (previousValue - currentValue); i++) {
                        result.append(")");
                        openBrackets--;
                    }
                }

                result.append(currentValue);
                previousValue = currentValue;
            }

            for (int i = 0; i < openBrackets; i++) {
                result.append(")");
            }

            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }
}