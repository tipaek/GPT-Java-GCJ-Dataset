import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        scanner.nextLine();

        for (int test = 0; test < numberOfTests; ++test) {
            String digits = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            LinkedList<Character> closingBrackets = new LinkedList<>();
            int previousDigit = 0;

            for (int i = 0; i < digits.length(); ++i) {
                int currentDigit = digits.charAt(i) - '0';

                if (i == 0) {
                    for (int j = 0; j < currentDigit; ++j) {
                        result.append('(');
                        closingBrackets.addLast(')');
                    }
                } else {
                    int difference = previousDigit - currentDigit;

                    if (difference > 0) {
                        for (int j = 0; j < difference; ++j) {
                            result.append(closingBrackets.removeFirst());
                        }
                    } else {
                        for (int j = 0; j < -difference; ++j) {
                            result.append('(');
                            closingBrackets.addLast(')');
                        }
                    }
                }

                result.append(currentDigit);
                previousDigit = currentDigit;
            }

            while (!closingBrackets.isEmpty()) {
                result.append(closingBrackets.removeFirst());
            }

            System.out.println("Case #" + (test + 1) + ": " + result.toString());
        }

        scanner.close();
    }
}