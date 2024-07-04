import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<String> strings = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            strings.add(scanner.next());
        }

        for (int i = 0; i < n; i++) {
            String input = strings.get(i);
            StringBuilder result = new StringBuilder();
            int previousDigit = input.charAt(0) - '0';

            // Append initial opening parentheses
            result.append("(".repeat(previousDigit));
            result.append(previousDigit);

            for (int j = 1; j < input.length(); j++) {
                int currentDigit = input.charAt(j) - '0';

                if (currentDigit > previousDigit) {
                    result.append("(".repeat(currentDigit - previousDigit));
                } else if (currentDigit < previousDigit) {
                    result.append(")".repeat(previousDigit - currentDigit));
                }

                result.append(currentDigit);
                previousDigit = currentDigit;
            }

            // Append closing parentheses for the last digit
            result.append(")".repeat(previousDigit));

            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
}