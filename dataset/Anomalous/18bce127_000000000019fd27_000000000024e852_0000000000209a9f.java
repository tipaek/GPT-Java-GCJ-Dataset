import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            String inputString = scanner.nextLine();
            StringBuilder output = new StringBuilder();
            char[] characters = inputString.toCharArray();

            int initialDigit = characters[0] - '0';
            appendCharacters(output, '(', initialDigit);

            for (int i = 0; i < characters.length - 1; i++) {
                output.append(characters[i]);
                int currentDigit = characters[i] - '0';
                int nextDigit = characters[i + 1] - '0';

                if (nextDigit < currentDigit) {
                    appendCharacters(output, ')', currentDigit - nextDigit);
                } else {
                    appendCharacters(output, '(', nextDigit - currentDigit);
                }
            }

            output.append(characters[characters.length - 1]);
            int lastDigit = characters[characters.length - 1] - '0';
            appendCharacters(output, ')', lastDigit);

            System.out.println("Case #" + (caseIndex + 1) + ": " + output);
        }

        scanner.close();
    }

    private static void appendCharacters(StringBuilder builder, char character, int count) {
        for (int i = 0; i < count; i++) {
            builder.append(character);
        }
    }
}