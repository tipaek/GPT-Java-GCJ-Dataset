package com.jackson;

import java.util.Scanner;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int caseNum = 1; caseNum <= testCases; caseNum++) {
                new Solution().processCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processCase(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        StringBuilder result = new StringBuilder();
        int count = 0;

        if (n <= 500) {
            for (int i = 1; i <= n; i++) {
                result.append(String.format("%n%d 1", i));
                count++;
            }
        } else if (n == 501) {
            result.append("\n1 1")
                  .append("\n2 1")
                  .append("\n3 2")
                  .append("\n3 1");
            count = 4;
            for (int i = 4; i <= 499; i++) {
                result.append(String.format("%n%d 1", i));
                count++;
            }
        }

        System.out.println(String.format("cnt = %d", count));
        // Uncomment the line below to print the final result
        // System.out.println(String.format(OUTPUT_FORMAT, caseNum, result.toString()));
    }
}