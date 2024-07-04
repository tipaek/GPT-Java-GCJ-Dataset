package com.company;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            int length = input.length();
            StringBuilder result = new StringBuilder();

            int previousDigit = 0;

            for (int j = 0; j < length; j++) {
                int currentDigit = Character.getNumericValue(input.charAt(j));

                if (currentDigit > previousDigit) {
                    for (int k = 0; k < currentDigit - previousDigit; k++) {
                        result.append("(");
                    }
                } else if (currentDigit < previousDigit) {
                    for (int k = 0; k < previousDigit - currentDigit; k++) {
                        result.append(")");
                    }
                }

                result.append(currentDigit);
                previousDigit = currentDigit;
            }

            for (int k = 0; k < previousDigit; k++) {
                result.append(")");
            }

            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
}