import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        new Solution().processCases();
    }

    private void processCases() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCases = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= numberOfCases; i++) {
            processCase(i, reader);
        }
    }

    private void processCase(int caseNumber, BufferedReader reader) throws Exception {
        String input = reader.readLine();
        processCase(caseNumber, input);
    }

    private void processCase(int caseNumber, String input) {
        StringBuilder result = new StringBuilder();
        int openBracketsCount = 0;
        int previousDigit = 0;

        for (int i = 0; i < input.length(); i++) {
            int currentDigit = Character.getNumericValue(input.charAt(i));
            BracketInfo bracketInfo = adjustBrackets(currentDigit, previousDigit, openBracketsCount, result);
            openBracketsCount = bracketInfo.openBracketsCount;
            previousDigit = bracketInfo.previousDigit;

            if (i == input.length() - 1) {
                addClosingBrackets(openBracketsCount, result);
            }
        }

        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }

    private BracketInfo adjustBrackets(int currentDigit, int previousDigit, int openBracketsCount, StringBuilder result) {
        if (currentDigit > previousDigit) {
            addOpeningBrackets(currentDigit - openBracketsCount, result);
            result.append(currentDigit);
            return new BracketInfo(currentDigit, currentDigit);
        } else {
            int difference = currentDigit - openBracketsCount;
            if (difference <= 0) {
                addClosingBrackets(-difference, result);
            } else {
                addOpeningBrackets(difference, result);
            }
            result.append(currentDigit);
            return new BracketInfo(openBracketsCount + difference, previousDigit);
        }
    }

    private void addOpeningBrackets(int count, StringBuilder result) {
        for (int i = 0; i < count; i++) {
            result.append("(");
        }
    }

    private void addClosingBrackets(int count, StringBuilder result) {
        for (int i = 0; i < count; i++) {
            result.append(")");
        }
    }

    private static class BracketInfo {
        int openBracketsCount;
        int previousDigit;

        BracketInfo(int openBracketsCount, int previousDigit) {
            this.openBracketsCount = openBracketsCount;
            this.previousDigit = previousDigit;
        }
    }
}