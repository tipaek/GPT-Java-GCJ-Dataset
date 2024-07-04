import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= numberOfTests; testCase++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int previousValue = 0;

            for (char ch : input.toCharArray()) {
                int currentValue = ch - '0';

                if (currentValue > previousValue) {
                    for (int i = 0; i < currentValue - previousValue; i++) {
                        result.append('(');
                    }
                } else if (currentValue < previousValue) {
                    for (int i = 0; i < previousValue - currentValue; i++) {
                        result.append(')');
                    }
                }

                result.append(currentValue);
                previousValue = currentValue;
            }

            for (int i = 0; i < previousValue; i++) {
                result.append(')');
            }

            System.out.println("Case #" + testCase + ": " + result.toString());
        }

        scanner.close();
    }
}