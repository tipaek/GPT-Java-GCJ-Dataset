package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Nesting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> answers = new ArrayList<>();
        Solver solver = new Solver();
        
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            answers.add(solver.solve(input));
        }

        for (int i = 0; i < answers.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + answers.get(i));
        }
    }
}

class Solver {
    public String solve(String s) {
        StringBuilder output = new StringBuilder();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            int digit = Character.getNumericValue(s.charAt(i));
            output.append("(".repeat(digit));
            output.append(s.charAt(i));
            output.append(")".repeat(digit));
        }

        List<Character> characters = new ArrayList<>();
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

        output.setLength(0);
        for (char c : characters) {
            output.append(c);
        }

        return output.toString();
    }
}