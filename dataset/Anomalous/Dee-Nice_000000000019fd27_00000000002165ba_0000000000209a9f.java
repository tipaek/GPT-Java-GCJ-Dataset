import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= testCases; i++) {
            processTestCase(scanner, i);
        }
    }

    private static void processTestCase(Scanner scanner, int testCaseNumber) {
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        int initialDigit = input.charAt(0) - '0';
        result.append(repeatCharacter('(', initialDigit)).append(initialDigit);

        for (int i = 1; i < input.length(); i++) {
            int currentDigit = input.charAt(i) - '0';
            int previousDigit = input.charAt(i - 1) - '0';

            if (currentDigit > previousDigit) {
                result.append(repeatCharacter('(', currentDigit - previousDigit)).append(currentDigit);
            } else if (currentDigit < previousDigit) {
                result.append(repeatCharacter(')', previousDigit - currentDigit)).append(currentDigit);
            } else {
                result.append(currentDigit);
            }
        }

        result.append(repeatCharacter(')', input.charAt(input.length() - 1) - '0'));
        System.out.println("Case #" + testCaseNumber + ": " + result.toString());
    }

    private static String repeatCharacter(char character, int count) {
        char[] characters = new char[count];
        Arrays.fill(characters, character);
        return new String(characters);
    }
}