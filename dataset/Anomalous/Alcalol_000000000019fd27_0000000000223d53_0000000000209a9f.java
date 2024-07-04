import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // Set up input scanner
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // Receive first line (How many cases?)
        int numberOfCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            // Pass input to processCase method
            processCase(caseNumber, scanner);
        }
    }

    public static void processCase(int caseNumber, Scanner scanner) {
        String input = scanner.next();
        StringBuilder output = new StringBuilder();
        int currentLevel = 0;

        for (int i = 0; i < input.length(); i++) {
            int requiredLevel = Character.getNumericValue(input.charAt(i));

            if (requiredLevel > currentLevel) {
                output.append("(".repeat(requiredLevel - currentLevel));
                currentLevel = requiredLevel;
            } else if (requiredLevel < currentLevel) {
                output.append(")".repeat(currentLevel - requiredLevel));
                currentLevel = requiredLevel;
            }

            output.append(requiredLevel);
        }

        if (currentLevel > 0) {
            output.append(")".repeat(currentLevel));
        }

        printResult(caseNumber, output.toString());
    }

    public static void printResult(int caseNumber, String output) {
        // Print result
        System.out.println("Case #" + caseNumber + ": " + output);
    }
}