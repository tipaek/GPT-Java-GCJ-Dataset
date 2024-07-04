package com.company;

import java.util.ArrayList;
import java.util.Scanner;

class Nesting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        ArrayList<String> results = new ArrayList<>();

        for (int i = 0; i < numberOfCases; i++) {
            String input = scanner.nextLine();
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
        int previousDepth = 0;

        for (char ch : input.toCharArray()) {
            int currentDepth = Character.getNumericValue(ch);

            while (previousDepth < currentDepth) {
                output.append('(');
                previousDepth++;
            }

            while (previousDepth > currentDepth) {
                output.append(')');
                previousDepth--;
            }

            output.append(ch);
        }

        while (previousDepth > 0) {
            output.append(')');
            previousDepth--;
        }

        return output.toString();
    }
}