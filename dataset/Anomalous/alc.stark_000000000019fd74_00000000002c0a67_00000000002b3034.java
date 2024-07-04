package com.jackson;

import java.util.*;

public class SolutionPatternMatching {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int caseNum = 1; caseNum <= testCases; caseNum++) {
                new SolutionPatternMatching().processCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processCase(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        List<String> patterns = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            patterns.add(scanner.next());
        }

        patterns.sort(Comparator.comparingInt(String::length));

        for (String pattern : patterns) {
            System.out.println(pattern);
        }

        boolean isPatternValid = true;
        String firstPattern = patterns.get(0);
        int asteriskIndex = firstPattern.indexOf("*");
        String leftPart = firstPattern.substring(0, asteriskIndex);
        String rightPart = asteriskIndex < firstPattern.length() ? firstPattern.substring(asteriskIndex + 1) : "";

        System.out.printf("Initial leftPart: %s, rightPart: %s%n", leftPart, rightPart);

        for (String pattern : patterns) {
            asteriskIndex = pattern.indexOf("*");
            String currentLeft = pattern.substring(0, asteriskIndex);
            String currentRight = asteriskIndex < pattern.length() ? pattern.substring(asteriskIndex + 1) : "";

            if (!matchParts(leftPart, currentLeft)) {
                isPatternValid = false;
                break;
            }

            if (currentLeft.length() > leftPart.length()) {
                leftPart = currentLeft;
            }

            if (!matchParts(new StringBuilder(rightPart).reverse().toString(), new StringBuilder(currentRight).reverse().toString())) {
                isPatternValid = false;
                break;
            }

            if (currentRight.length() > rightPart.length()) {
                rightPart = currentRight;
            }

            System.out.printf("Updated leftPart: %s, rightPart: %s%n", leftPart, rightPart);
        }

        String result = isPatternValid ? leftPart + rightPart : "*";
        System.out.printf(OUTPUT_FORMAT, caseNum, result);
    }

    private boolean matchParts(String part1, String part2) {
        int len1 = part1.length(), len2 = part2.length();
        for (int i = 0; i < Math.min(len1, len2); i++) {
            if (part1.charAt(i) != part2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}