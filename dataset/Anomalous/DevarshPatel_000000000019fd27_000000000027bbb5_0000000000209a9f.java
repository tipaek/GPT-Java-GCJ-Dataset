package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        List<String> results = new ArrayList<>();

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
        StringBuilder result = new StringBuilder();
        int length = input.length();

        for (int i = 0; i < length; i++) {
            int digit = Character.getNumericValue(input.charAt(i));
            result.append("(".repeat(digit))
                  .append(digit)
                  .append(")".repeat(digit));
        }

        StringBuilder finalResult = new StringBuilder();
        int openParentheses = 0;

        for (int i = 0; i < result.length(); i++) {
            char currentChar = result.charAt(i);
            if (currentChar == '(') {
                openParentheses++;
                finalResult.append(currentChar);
            } else if (currentChar == ')') {
                if (openParentheses > 0) {
                    openParentheses--;
                    finalResult.append(currentChar);
                }
            } else {
                finalResult.append(currentChar);
            }
        }

        return finalResult.toString();
    }
}