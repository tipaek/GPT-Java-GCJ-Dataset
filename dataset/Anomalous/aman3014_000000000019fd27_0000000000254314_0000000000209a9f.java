import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int currentOpenBrackets = 0;

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);

                if (digit > currentOpenBrackets) {
                    result.append(repeatCharacter('(', digit - currentOpenBrackets));
                } else if (digit < currentOpenBrackets) {
                    result.append(repeatCharacter(')', currentOpenBrackets - digit));
                }

                result.append(digit);
                currentOpenBrackets = digit;
            }

            result.append(repeatCharacter(')', currentOpenBrackets));

            System.out.printf("Case #%d: %s\n", caseNumber, result);
        }

        scanner.close();
    }

    private static String repeatCharacter(char character, int count) {
        StringBuilder repeatedString = new StringBuilder();
        for (int i = 0; i < count; i++) {
            repeatedString.append(character);
        }
        return repeatedString.toString();
    }
}