package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Nesting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        ArrayList<String> results = new ArrayList<>();

        for (int i = 0; i < testCases; i++) {
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
            int difference = currentDigit - previousDigit;

            if (difference > 0) {
                output.append("(".repeat(difference));
            } else if (difference < 0) {
                output.append(")".repeat(-difference));
            }

            output.append(ch);
            previousDigit = currentDigit;
        }

        output.append(")".repeat(previousDigit));
        return output.toString();
    }
}