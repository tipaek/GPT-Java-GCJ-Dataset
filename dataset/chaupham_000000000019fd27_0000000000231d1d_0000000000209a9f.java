/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
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
            String s = in.nextLine();
            while (s.trim().length() == 0) {
                s = in.nextLine();
            }
            solutions.add(solve(s, i));
        }
        
        for (String solution: solutions) {
            System.out.println(solution);
        }
    }
    
    private static String solve(String s, int testcaseNumber) {
        String resultStr = null;
        ///////////////////////////////////////////////
        int[][] stringArray = new int[s.length()][3];
        for (int c = 0; c < s.length(); c++) {
            int number = Integer.parseInt(s.substring(c, c+1));
            stringArray[c][0] = number; // number value
            stringArray[c][1] = number; // left parenthesis
            stringArray[c][2] = number; // right parenthesis
        }
        
        for (int c = 1; c < s.length(); c++) {
            int difference = stringArray[c][1] - stringArray[c-1][2];
            if (difference == 0) {
                stringArray[c-1][2] = 0;
                stringArray[c][1] = 0;
            } else if (difference > 0) {
                stringArray[c-1][2] = 0;
                stringArray[c][1] = difference;
            } else {
                stringArray[c][1] = 0;
                stringArray[c-1][2] = -difference;
            }
        }
        
        StringBuilder stringBuilder = new StringBuilder();
        for (int c = 0; c < s.length(); c++) {
            stringBuilder.append(printParenthesis(stringArray[c][1], true));
            stringBuilder.append(String.valueOf(stringArray[c][0]));
            stringBuilder.append(printParenthesis(stringArray[c][2], false));
        } 
        resultStr = stringBuilder.toString();
        ///////////////////////////////////////////////
        return printSolution(testcaseNumber, resultStr);
    }
    
    private static String printParenthesis(int number, boolean isOpen) {
        if (number == 0) {
            return "";
        }
        
        StringBuilder stringBuilder = new StringBuilder();
        String parenthesis = isOpen ? "(" : ")";
        for (int i = 0; i < number; i++) {
            stringBuilder.append(parenthesis);
        }
        return stringBuilder.toString();
    }
    
    public static String printSolution(int testCaseNumber, String result) {
        return String.format("Case #%d: %s", testCaseNumber, result);
    }
    
    
}
