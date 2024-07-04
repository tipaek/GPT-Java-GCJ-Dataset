import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numCases; i++) {
            String input = scanner.nextLine();
            System.out.print("Case #" + (i + 1) + ": ");
            processString(input);
            if (i < numCases - 1) {
                System.out.println();
            }
        }
        scanner.close();
    }

    private static void processString(String input) {
        int currentLevel = 0;

        for (int j = 0; j < input.length(); j++) {
            int digit = Character.getNumericValue(input.charAt(j));
            if (digit > currentLevel) {
                printCharacters('(', digit - currentLevel);
            } else if (digit < currentLevel) {
                printCharacters(')', currentLevel - digit);
            }
            System.out.print(digit);
            currentLevel = digit;
        }

        printCharacters(')', currentLevel);
    }

    private static void printCharacters(char ch, int count) {
        for (int k = 0; k < count; k++) {
            System.out.print(ch);
        }
    }
}