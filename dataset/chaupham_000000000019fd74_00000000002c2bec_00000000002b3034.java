/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.exit;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        List<String> solutions = new ArrayList();

        for (int i = 1; i <= numberOfTestCases; ++i) {
            final int numberOfPattern = in.nextInt();
            List<String> patterns = new ArrayList<>();
            for (int row = 0; row < numberOfPattern; row++) {
                String line = in.nextLine();
                while (line.isEmpty()) {
                    line = in.nextLine();
                }
                patterns.add(line);
            }
            solutions.add(solve(patterns, i));
        }

        for (String solution : solutions) {
            System.out.println(solution);
        }
    }

    private static String solve(List<String> patterns, final int testCaseNumber) {
        String result = null;
        //////////////////////
        String startWith = "";
        String endWith = "";
        List<String> middleParts = new ArrayList();
        String exactString = "*";
        
        Set<String> patternSet = new HashSet();
        for (String pattern : patterns) {
            patternSet.add(pattern);
        }

        for (String pattern : patternSet) {
            if (pattern.equals("*")) {
                continue;
            }

            String[] patternParts = pattern.trim().split("\\*", -1);

            if (patternParts.length == 1) {
                exactString = pattern;
                break;
            }

            String firstPart = patternParts[0];
            if (!firstPart.isEmpty()) {
                if (startWith.isEmpty()) {
                    startWith = patternParts[0];
                } else if (firstPart.contains(startWith)) {
                    startWith = patternParts[0];
                } else if (startWith.contains(firstPart)) {
                    //do nothing
                } else {
                    return printSolution(testCaseNumber, "*");
                }
            }

            String lastPart = patternParts[patternParts.length - 1];
            if (!lastPart.isEmpty()) {
                if (endWith.equals("*")) {
                    endWith = lastPart;
                } else if (lastPart.contains(endWith)) {
                    endWith = lastPart;
                } else if (lastPart.length() <= endWith.length() && endWith.contains(lastPart)) {
                    //do nothing
                } else {
                    return printSolution(testCaseNumber, "*");
                }
            }

            for (int i = 1; i < patternParts.length - 1; i++) {
                if (!patternParts[i].isEmpty()) {
                    middleParts.add(patternParts[i]);
                }
            }
        }

        if (exactString.equals("*")) {
            if (middleParts.size() == 0) {
                result = (startWith + endWith).replaceAll("\\*", "");
            } else {
                result = String.format("%s%s%s", startWith, String.join("", middleParts), endWith);
            }
        } else {
            result = exactString;
            for (String pattern : patterns) {
                if (pattern.equals("*")) {
                    continue;
                }

                if (!exactString.contains(pattern.replaceAll("\\*", ""))) {
                    result = "*";
                }
            }
        }

        if (result.isEmpty()) {
            result = "*";
        }

        // Print solution here
        return printSolution(testCaseNumber, result);
    }

    public static String printSolution(int testCaseNumber, String result) {
        return String.format("Case #%d: %s", testCaseNumber, result);
    }

}
