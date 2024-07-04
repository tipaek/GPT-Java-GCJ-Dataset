import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            StringBuilder output = new StringBuilder();
            int previousDigit = 0;

            for (int j = 0; j < input.length(); j++) {
                int currentDigit = input.charAt(j) - '0';

                while (previousDigit < currentDigit) {
                    output.append('(');
                    previousDigit++;
                }

                while (previousDigit > currentDigit) {
                    output.append(')');
                    previousDigit--;
                }

                output.append(currentDigit);
            }

            while (previousDigit > 0) {
                output.append(')');
                previousDigit--;
            }

            System.out.println("Case #" + (i + 1) + ": " + output.toString());
        }

        scanner.close();
    }
}