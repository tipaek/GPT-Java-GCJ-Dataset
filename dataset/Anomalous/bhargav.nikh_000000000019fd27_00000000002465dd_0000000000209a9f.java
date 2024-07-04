import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        new Solution().processCases();
    }

    public void processCases() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCases = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= numberOfCases; i++) {
            processCase(i, reader);
        }
    }

    public void processCase(int caseNumber, BufferedReader reader) throws Exception {
        String inputString = reader.readLine();
        processCase(caseNumber, inputString);
    }

    public void processCase(int caseNumber, String inputString) {
        StringBuilder resultBuilder = new StringBuilder();
        int currentParenthesesCount = 0;
        int previousDigit = 0;

        for (int i = 0; i < inputString.length(); i++) {
            int currentDigit = Character.getNumericValue(inputString.charAt(i));
            ParenthesesState newState = updateParentheses(currentDigit, previousDigit, currentParenthesesCount, resultBuilder);
            currentParenthesesCount = newState.currentParenthesesCount;
            previousDigit = newState.previousDigit;

            if (i == inputString.length() - 1) {
                closeParentheses(currentParenthesesCount, resultBuilder);
            }
        }
        System.out.println("Case #" + caseNumber + ": " + resultBuilder.toString());
    }

    public ParenthesesState updateParentheses(int currentDigit, int previousDigit, int currentParenthesesCount, StringBuilder resultBuilder) {
        int newParenthesesCount = 0;
        int newPreviousDigit = 0;

        if (currentDigit > previousDigit) {
            closeParentheses(currentParenthesesCount, resultBuilder);
            openParentheses(currentDigit, resultBuilder);
            resultBuilder.append(currentDigit);

            newParenthesesCount = currentDigit;
            newPreviousDigit = currentDigit;
        } else {
            int difference = currentDigit - currentParenthesesCount;
            if (difference <= 0) {
                closeParentheses(Math.abs(difference), resultBuilder);
                resultBuilder.append(currentDigit);
            } else {
                openParentheses(difference, resultBuilder);
                resultBuilder.append(currentDigit);
            }

            newParenthesesCount = currentParenthesesCount + difference;
            newPreviousDigit = previousDigit;
        }
        return new ParenthesesState(newParenthesesCount, newPreviousDigit);
    }

    public void openParentheses(int count, StringBuilder resultBuilder) {
        for (int i = 0; i < count; i++) {
            resultBuilder.append("(");
        }
    }

    public void closeParentheses(int count, StringBuilder resultBuilder) {
        for (int i = 0; i < count; i++) {
            resultBuilder.append(")");
        }
    }

    private static class ParenthesesState {
        int currentParenthesesCount;
        int previousDigit;

        public ParenthesesState(int currentParenthesesCount, int previousDigit) {
            this.currentParenthesesCount = currentParenthesesCount;
            this.previousDigit = previousDigit;
        }
    }
}