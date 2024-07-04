package com.jackson;

import java.util.*;

public class Solution_PatternMatching {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Solution_PatternMatching().processCase(caseNum, scanner);
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

        boolean isMatching = true;
        String firstPattern = patterns.get(0);
        int starIndex = firstPattern.indexOf("*");
        String leftPart = firstPattern.substring(0, starIndex);
        String rightPart = starIndex < firstPattern.length() ? firstPattern.substring(starIndex + 1) : "";

        System.out.println(String.format("Initial leftPart = %s, rightPart = %s", leftPart, rightPart));

        for (String pattern : patterns) {
            starIndex = pattern.indexOf("*");
            String currentLeft = pattern.substring(0, starIndex);
            String currentRight = starIndex < pattern.length() ? pattern.substring(starIndex + 1) : "";

            if (!isPrefixMatching(leftPart, currentLeft) || !isSuffixMatching(rightPart, currentRight)) {
                isMatching = false;
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

        String result = isMatching ? leftPart + rightPart : "*";
        System.out.println(String.format(OUTPUT_FORMAT, caseNum, result));
    }

    private boolean isPrefixMatching(String prev, String current) {
        int minLength = Math.min(prev.length(), current.length());
        for (int i = 0; i < minLength; i++) {
            if (prev.charAt(i) != current.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSuffixMatching(String prev, String current) {
        int prevLength = prev.length();
        int currentLength = current.length();
        int minLength = Math.min(prevLength, currentLength);
        for (int i = 1; i <= minLength; i++) {
            if (prev.charAt(prevLength - i) != current.charAt(currentLength - i)) {
                return false;
            }
        }
        return true;
    }
}