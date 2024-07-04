package com.jackson;

import java.util.*;

public class Main {
    private static final String OUTPUT_TEMPLATE = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Main().processCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processCase(int caseNum, Scanner scanner) {
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
        String initialPattern = patterns.get(0);
        int starIndex = initialPattern.indexOf("*");
        String leftPart = initialPattern.substring(0, starIndex);
        String rightPart = starIndex < initialPattern.length() ? initialPattern.substring(starIndex + 1) : "";

        System.out.println(String.format("Initial leftPart = %s, rightPart = %s", leftPart, rightPart));

        for (String pattern : patterns) {
            starIndex = pattern.indexOf("*");
            String currentLeft = pattern.substring(0, starIndex);
            String currentRight = starIndex < pattern.length() ? pattern.substring(starIndex + 1) : "";

            if (!isPrefixMatching(leftPart, currentLeft) || !isSuffixMatching(rightPart, currentRight)) {
                isPatternValid = false;
                break;
            }

            if (currentLeft.length() > leftPart.length()) {
                leftPart = currentLeft;
            }
            if (currentRight.length() > rightPart.length()) {
                rightPart = currentRight;
            }

            System.out.println(String.format("Updated leftPart = %s, rightPart = %s", leftPart, rightPart));
        }

        String result = isPatternValid ? leftPart + rightPart : "*";
        System.out.println(String.format(OUTPUT_TEMPLATE, caseNum, result));
    }

    private boolean isPrefixMatching(String prev, String curr) {
        int minLength = Math.min(prev.length(), curr.length());
        for (int i = 0; i < minLength; i++) {
            if (prev.charAt(i) != curr.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSuffixMatching(String prev, String curr) {
        int minLength = Math.min(prev.length(), curr.length());
        for (int i = 0; i < minLength; i++) {
            if (prev.charAt(prev.length() - 1 - i) != curr.charAt(curr.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}