import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            input = "0" + input + "0";
            StringBuilder result = new StringBuilder();

            char[] characters = input.toCharArray();

            for (int j = 0; j < characters.length - 1; j++) {
                int currentDigit = Character.getNumericValue(characters[j]);
                int nextDigit = Character.getNumericValue(characters[j + 1]);
                int difference = nextDigit - currentDigit;
                char bracket = '(';

                result.append(currentDigit);

                if (difference < 0) {
                    bracket = ')';
                    difference = -difference;
                }

                for (int k = 0; k < difference; k++) {
                    result.append(bracket);
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + result.substring(1));
        }

        scanner.close();
    }
}