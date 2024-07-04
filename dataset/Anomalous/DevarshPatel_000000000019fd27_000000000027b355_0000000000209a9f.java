package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Nesting {
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
        StringBuilder output = new StringBuilder();
        int previousDigit = 0;

        for (char ch : input.toCharArray()) {
            int currentDigit = Character.getNumericValue(ch);
            while (previousDigit < currentDigit) {
                output.append('(');
                previousDigit++;
            }
            while (previousDigit > currentDigit) {
                output.append(')');
                previousDigit--;
            }
            output.append(ch);
        }

        while (previousDigit > 0) {
            output.append(')');
            previousDigit--;
        }

        return output.toString();
    }
}