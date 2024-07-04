import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfCases; i++) {
            String inputString = scanner.nextLine();
            int currentLevel = 0;
            int nextLevel = 0;
            int nestingLevel = 0;

            System.out.print("Case #" + (i + 1) + ": ");

            for (int j = 0; j < inputString.length(); j++) {
                currentLevel = Character.getNumericValue(inputString.charAt(j));

                // Opening brackets for increasing levels
                for (int k = 0; k < currentLevel - nestingLevel; k++) {
                    System.out.print("(");
                }

                System.out.print(currentLevel);

                // Peek forward to the next character
                if (j < inputString.length() - 1) {
                    nextLevel = Character.getNumericValue(inputString.charAt(j + 1));
                } else {
                    nextLevel = 0;
                }

                // Handle consecutive same level characters
                while (currentLevel == nextLevel && j < inputString.length() - 1) {
                    System.out.print(currentLevel);
                    j++;
                    if (j < inputString.length() - 1) {
                        nextLevel = Character.getNumericValue(inputString.charAt(j + 1));
                    }
                }

                nestingLevel = currentLevel;

                // Closing brackets for decreasing levels
                for (int k = 0; k < currentLevel - nextLevel; k++) {
                    System.out.print(")");
                    nestingLevel--;
                }
            }
            System.out.println();
        }
    }
}