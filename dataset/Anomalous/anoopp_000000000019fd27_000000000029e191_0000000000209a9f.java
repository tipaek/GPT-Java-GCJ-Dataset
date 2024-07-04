import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCaseCount = scanner.nextInt();
            for (int i = 1; i <= testCaseCount; i++) {
                String inputString = scanner.next();
                printFormattedString(inputString, i);
            }
        }
    }

    private static void printFormattedString(String input, int caseNumber) {
        StringBuilder result = new StringBuilder();
        int previousDigit = -1;
        int openBracketsCount = 0;

        for (int i = 0; i < input.length(); i++) {
            int currentDigit = Character.getNumericValue(input.charAt(i));

            if (currentDigit != previousDigit) {
                if (currentDigit > openBracketsCount) {
                    int bracketsToAdd = currentDigit - openBracketsCount;
                    result.append("(".repeat(bracketsToAdd));
                    openBracketsCount = currentDigit;
                } else {
                    int bracketsToClose = openBracketsCount - currentDigit;
                    result.append(")".repeat(bracketsToClose));
                    openBracketsCount = currentDigit;
                }
            }
            result.append(currentDigit);
            previousDigit = currentDigit;
        }

        result.append(")".repeat(openBracketsCount));

        System.out.println("Case #" + caseNumber + ": " + result);
    }
}