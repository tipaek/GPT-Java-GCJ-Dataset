import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        StringBuilder result = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            String input = scanner.nextLine();
            StringBuilder formattedString = new StringBuilder();

            input = "0" + input + "0";

            for (int i = 1; i < input.length() - 1; i++) {
                int currentDigit = input.charAt(i) - '0';
                int previousDigit = input.charAt(i - 1) - '0';
                int nextDigit = input.charAt(i + 1) - '0';

                if (currentDigit > previousDigit) {
                    formattedString.append("(".repeat(currentDigit - previousDigit));
                }

                formattedString.append(currentDigit);

                if (currentDigit > nextDigit) {
                    formattedString.append(")".repeat(currentDigit - nextDigit));
                }
            }

            result.append("Case #").append(t).append(": ").append(formattedString).append("\n");
        }

        System.out.print(result);
    }
}