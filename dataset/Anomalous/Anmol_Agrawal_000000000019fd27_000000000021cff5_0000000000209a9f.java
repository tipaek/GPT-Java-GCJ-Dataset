import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();

            int previousDigit = 0;
            for (char ch : input.toCharArray()) {
                int currentDigit = ch - '0';

                while (previousDigit < currentDigit) {
                    result.append('(');
                    previousDigit++;
                }
                while (previousDigit > currentDigit) {
                    result.append(')');
                    previousDigit--;
                }

                result.append(ch);
            }

            while (previousDigit > 0) {
                result.append(')');
                previousDigit--;
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }
}