package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Nesting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> answers = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            answers.add(Solver.solve(input));
        }

        for (int i = 0; i < answers.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + answers.get(i));
        }
    }
}

class Solver {
    public static String solve(String s) {
        StringBuilder output = new StringBuilder();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            int digit = Character.getNumericValue(s.charAt(i));
            
            for (int j = 0; j < digit; j++) {
                output.append('(');
            }
            output.append(s.charAt(i));
            for (int j = 0; j < digit; j++) {
                output.append(')');
            }
        }

        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < output.length(); i++) {
            characters.add(output.charAt(i));
        }

        for (int i = 0; i < characters.size() - 1; i++) {
            if (characters.get(i) == ')' && characters.get(i + 1) == '(') {
                characters.remove(i);
                characters.remove(i);
                i = -1; // reset the loop to recheck from the start
            }
        }

        StringBuilder finalOutput = new StringBuilder();
        for (char ch : characters) {
            finalOutput.append(ch);
        }

        return finalOutput.toString();
    }
}