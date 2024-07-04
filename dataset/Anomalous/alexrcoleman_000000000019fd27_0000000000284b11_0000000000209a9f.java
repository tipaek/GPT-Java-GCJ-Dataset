import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int balance = 0;

            for (int i = 0; i < input.length(); i++) {
                int currentDigit = input.charAt(i) - '0';

                while (balance < currentDigit) {
                    result.append('(');
                    balance++;
                }
                while (balance > currentDigit) {
                    result.append(')');
                    balance--;
                }

                result.append(currentDigit);
            }

            while (balance > 0) {
                result.append(')');
                balance--;
            }

            System.out.printf("Case #%d: %s\n", testCase, result.toString());
        }

        scanner.close();
    }
}