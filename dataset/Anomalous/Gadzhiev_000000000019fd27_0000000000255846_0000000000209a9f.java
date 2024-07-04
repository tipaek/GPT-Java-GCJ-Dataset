import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            String inputString = scanner.nextLine();
            processBrackets(inputString, caseNumber);
        }
    }

    private static void processBrackets(String inputString, int caseNumber) {
        int openBracketsCount = 0;
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < inputString.length(); index++) {
            int currentDigit = Character.getNumericValue(inputString.charAt(index));
            if (currentDigit > openBracketsCount) {
                result.append("(".repeat(currentDigit - openBracketsCount));
                openBracketsCount = currentDigit;
            } else if (currentDigit < openBracketsCount) {
                result.append(")".repeat(openBracketsCount - currentDigit));
                openBracketsCount = currentDigit;
            }
            result.append(currentDigit);
        }
        result.append(")".repeat(openBracketsCount));
        System.out.println("Case #" + caseNumber + ": " + result);
    }
}