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

                if (currentDigit > previousDigit) {
                    for (int k = 0; k < currentDigit - previousDigit; k++) {
                        output.append('(');
                    }
                } else if (currentDigit < previousDigit) {
                    for (int k = 0; k < previousDigit - currentDigit; k++) {
                        output.append(')');
                    }
                }

                output.append(currentDigit);
                previousDigit = currentDigit;
            }

            for (int k = 0; k < previousDigit; k++) {
                output.append(')');
            }

            System.out.println("Case #" + (i + 1) + ": " + output.toString());
        }
    }
}