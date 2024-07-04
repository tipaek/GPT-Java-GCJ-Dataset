package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
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
        int length = input.length();
        
        for (int i = 0; i < length; i++) {
            int digit = Character.getNumericValue(input.charAt(i));
            output.append("(".repeat(digit));
            output.append(digit);
            output.append(")".repeat(digit));
        }
        
        StringBuilder finalOutput = new StringBuilder();
        int balance = 0;
        
        for (int i = 0; i < output.length(); i++) {
            char currentChar = output.charAt(i);
            if (currentChar == '(') {
                balance++;
                finalOutput.append(currentChar);
            } else if (currentChar == ')') {
                if (balance > 0 && i + 1 < output.length() && output.charAt(i + 1) == '(') {
                    balance--;
                    i++; // Skip the next '('
                } else {
                    balance--;
                    finalOutput.append(currentChar);
                }
            } else {
                finalOutput.append(currentChar);
            }
        }
        
        return finalOutput.toString();
    }
}