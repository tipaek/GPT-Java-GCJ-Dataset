package com.jackson;

import java.util.Scanner;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            Solution solution = new Solution();
            for (int caseNum = 1; caseNum <= testCases; caseNum++) {
                solution.processCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processCase(int caseNum, Scanner scanner) {
        char[] inputChars = scanner.next().toCharArray();
        int[] digits = new int[inputChars.length];
        for (int i = 0; i < inputChars.length; i++) {
            digits[i] = inputChars[i] - '0';
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0) {
                result.append('0');
            } else {
                if (i == 0 || digits[i - 1] == 0) {
                    result.append('(');
                }
                result.append('1');
                if (i == digits.length - 1 || digits[i + 1] == 0) {
                    result.append(')');
                }
            }
        }

        System.out.printf(OUTPUT_FORMAT, caseNum, result.toString());
        System.out.println();
    }
}