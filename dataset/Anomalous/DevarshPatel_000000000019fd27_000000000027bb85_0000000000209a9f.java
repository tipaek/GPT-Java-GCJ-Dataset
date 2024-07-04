package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
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
            output.append("(".repeat(digit))
                  .append(digit)
                  .append(")".repeat(digit));
        }

        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < output.length(); i++) {
            characters.add(output.charAt(i));
        }

        for (int i = 0; i < characters.size() - 1; i++) {
            if (characters.get(i) == ')' && characters.get(i + 1) == '(') {
                characters.remove(i);
                characters.remove(i);
                i = -1;
            }
        }

        StringBuilder finalOutput = new StringBuilder();
        for (Character ch : characters) {
            finalOutput.append(ch);
        }

        return finalOutput.toString();
    }
}