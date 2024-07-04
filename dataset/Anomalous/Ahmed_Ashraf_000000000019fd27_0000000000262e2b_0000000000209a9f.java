import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder(input);

        int firstDigit = Character.getNumericValue(result.charAt(0));
        while (firstDigit > 0) {
            result.insert(0, '(');
            firstDigit--;
        }

        int lastDigit = Character.getNumericValue(result.charAt(result.length() - 1));
        while (lastDigit > 0) {
            result.append(')');
            lastDigit--;
        }

        for (int i = 0; i < result.length() - 1; i++) {
            if (result.charAt(i) == ')' || result.charAt(i) == '(') {
                continue;
            }

            int currentDigit = Character.getNumericValue(result.charAt(i));
            int nextIndex = i + 1;
            while (nextIndex < result.length() && (result.charAt(nextIndex) == ')' || result.charAt(nextIndex) == '(')) {
                nextIndex++;
            }

            if (nextIndex < result.length()) {
                int nextDigit = Character.getNumericValue(result.charAt(nextIndex));
                int difference = Math.abs(currentDigit - nextDigit);
                char bracket = currentDigit > nextDigit ? ')' : '(';

                for (int j = 0; j < difference; j++) {
                    result.insert(i + 1, bracket);
                }
            }
        }

        System.out.println(result.toString());
        scanner.close();
    }
}