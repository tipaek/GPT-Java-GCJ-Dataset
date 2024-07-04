package com.google.codejam.round1a.qa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numOfCases = scanner.nextInt();

            for (int i = 0; i < numOfCases; i++) {
                List<String> patterns = new ArrayList<>();
                int n = scanner.nextInt();
                for (int j = 0; j < n; j++) {
                    patterns.add(scanner.next());
                }

                System.out.println("Case #" + (i + 1) + ": " + findPattern(patterns));
            }
        }
    }

    private static String findPattern(List<String> patterns) {
        patterns.sort(Comparator.comparingInt(String::length).reversed());

        String referencePattern = patterns.get(0);
        for (String pattern : patterns) {
            if (!referencePattern.matches(pattern.replace("*", "[A-Z*]*"))) {
                return "*";
            }
        }

        return referencePattern.replace("*", "");
    }
}