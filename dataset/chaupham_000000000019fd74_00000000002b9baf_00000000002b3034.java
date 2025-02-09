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
import java.util.Scanner;

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
        
        for (String solution: solutions) {
            System.out.println(solution);
        }
    }
    
    private static String solve(List<String> patterns, final int testCaseNumber) {
        String result = null;
        //////////////////////
        int minLength = Integer.MAX_VALUE;
        for (String pattern: patterns) {
            int curMinLength = pattern.replaceAll("\\*", "").length();
            if (curMinLength < minLength) {
                minLength = curMinLength;
            }
        }
        
        String startWith = "*";
        String endWith = "*";
        List<String> middleParts = new ArrayList();
        String exactString = "*";
        for (String pattern: patterns) {
            String[] patternParts = pattern.split("\\*", -1);
            
            if (patternParts.length == 1 && !exactString.equals("*") && !exactString.equals(pattern)) {
                return printSolution(testCaseNumber, "*");
            } 
            
            if (patternParts.length == 1) {
                exactString = pattern;
                continue;
            }
            
            if (!patternParts[0].isEmpty()) {
                if (patternParts[0].length() > startWith.length() && patternParts[0].contains(startWith.replaceAll("\\*", ""))) {
                    startWith = patternParts[0];
                } else if (patternParts[0].length() <= startWith.length() && startWith.contains(patternParts[0])) {
                    //do nothing
                } else {
                    return printSolution(testCaseNumber, "*");
                }
            }
            
            String lastPart = patternParts[patternParts.length - 1];
            if (!lastPart.isEmpty()) {
                if (lastPart.length() > endWith.length() && lastPart.contains(endWith.replaceAll("\\*", ""))) {
                    endWith = lastPart;
                } else if (lastPart.length() <= endWith.length() && endWith.contains(lastPart)) {
                    //do nothing
                } else {
                    return printSolution(testCaseNumber, "*");
                }
            }
            
            for (int i = 1; i < patternParts.length - 1; i++) {
                if (!patternParts[i].isEmpty())  {
                    middleParts.add(patternParts[i]);
                }
            }
        }
        
        if (exactString.equals("*")) {
            result = String.format("%s%s%s", startWith, String.join("", middleParts), endWith);
        } else {
            result = exactString;
        }
        
        // Print solution here
        return printSolution(testCaseNumber, result);
    }
    
    public static String printSolution(int testCaseNumber, String result) {
        return String.format("Case #%d: %s", testCaseNumber, result);
    }
    
    
}
