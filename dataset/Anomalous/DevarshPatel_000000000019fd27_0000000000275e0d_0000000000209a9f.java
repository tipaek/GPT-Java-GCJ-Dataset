package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Nesting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseCount = scanner.nextInt();
        ArrayList<String> results = new ArrayList<>();
        
        for (int i = 0; i < caseCount; i++) {
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
        int currentDepth = 0;

        for (char c : input.toCharArray()) {
            int digit = Character.getNumericValue(c);
            
            while (currentDepth < digit) {
                output.append('(');
                currentDepth++;
            }
            while (currentDepth > digit) {
                output.append(')');
                currentDepth--;
            }
            output.append(c);
        }

        while (currentDepth > 0) {
            output.append(')');
            currentDepth--;
        }
        
        return output.toString();
    }
}