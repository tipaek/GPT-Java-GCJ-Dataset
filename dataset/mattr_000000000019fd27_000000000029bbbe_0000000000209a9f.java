package com.isograd.exercise;

import java.util.Scanner;


import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static int main(String[] argv) throws Exception {
        solve(new Scanner(System.in));
        
        return 0;
    }

    public static void solve(Scanner scanner) {
        int nbCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= nbCases; i++) {
            doCase(scanner, i);
        }
    }

    private static void doCase(Scanner sc, int caseNumber) {
        String line = sc.nextLine();
        LinkedList<Integer> inputs = new LinkedList<>();
        for (int i = 0; i < line.length(); i++){
            char c = line.charAt(i);
            try {
                int x = Integer.parseInt(Character.toString(c));
                inputs.addLast(x);
            } catch (Exception e) {
                continue;
            }
        }

        StringBuilder sb = new StringBuilder();
        int depth = 0;

        for (Integer i : inputs) {
            if (i == depth) {
                sb.append(i);
            } else if (i > depth) {
                for (int j = depth; j < i; j++) {
                    sb.append("(");
                    depth++;
                }
                sb.append(i);
            } else {
                for (int j = i; j < depth; j++) {
                    sb.append(")");
                    depth--;
                }
                sb.append(i);
            }
        }

        for (int j = 0; j < depth; j++) {
            sb.append(")");
        }

        System.out.println("Case #" + Integer.toString(caseNumber) + ": " + sb.toString());
    }

}
