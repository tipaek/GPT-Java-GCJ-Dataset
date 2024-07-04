package com.company;

import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        ArrayList<String> results = new ArrayList<>();

        for (int i = 0; i < numberOfCases; i++) {
            String input = scanner.next();
            results.add(Solver.solve(input));
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }
}

class Solver {
    public static String solve(String input) {
        StringBuilder output = new StringBuilder();
        int length = input.length();

        for (int i = 0; i < length; i++) {
            int digit = Character.getNumericValue(input.charAt(i));
            output.append("(".repeat(digit));
            output.append(digit);
            output.append(")".repeat(digit));
        }

        StringBuilder cleanedOutput = new StringBuilder();
        char[] outputChars = output.toString().toCharArray();
        int openBrackets = 0;

        for (char ch : outputChars) {
            if (ch == '(') {
                openBrackets++;
            } else if (ch == ')') {
                openBrackets--;
            }
            cleanedOutput.append(ch);
            if (openBrackets < 0) {
                cleanedOutput.setLength(cleanedOutput.length() - 1);
                openBrackets = 0;
            }
        }

        return cleanedOutput.toString();
    }
}