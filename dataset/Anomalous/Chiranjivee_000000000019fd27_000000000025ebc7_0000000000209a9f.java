import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.nextLine();
            StringBuilder output = new StringBuilder();
            int previousDigit = 0;

            for (char ch : input.toCharArray()) {
                int currentDigit = ch - '0';
                int difference = currentDigit - previousDigit;

                if (difference > 0) {
                    for (int i = 0; i < difference; i++) {
                        output.append('(');
                    }
                } else if (difference < 0) {
                    for (int i = 0; i < -difference; i++) {
                        output.append(')');
                    }
                }

                output.append(currentDigit);
                previousDigit = currentDigit;
            }

            for (int i = 0; i < previousDigit; i++) {
                output.append(')');
            }

            System.out.println("Case #" + caseNumber + ": " + output.toString());
        }

        scanner.close();
    }
}