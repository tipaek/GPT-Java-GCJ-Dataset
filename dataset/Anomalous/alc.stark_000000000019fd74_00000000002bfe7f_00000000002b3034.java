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

        boolean isPatternValid = true;
        String prevPattern = patterns.get(0);
        int starIndex = prevPattern.indexOf("*");
        String prevLeft = prevPattern.substring(0, starIndex);
        String prevRight = (starIndex < prevPattern.length() - 1) ? prevPattern.substring(starIndex + 1) : "";

        System.out.printf("11 prevLeft = %s , prevRight = %s%n", prevLeft, prevRight);

        for (String pattern : patterns) {
            starIndex = pattern.indexOf("*");
            String curLeft = pattern.substring(0, starIndex);
            String curRight = (starIndex < pattern.length() - 1) ? pattern.substring(starIndex + 1) : "";

            if (!isPrefixMatching(prevLeft, curLeft) || !isSuffixMatching(prevRight, curRight)) {
                isPatternValid = false;
                break;
            }

            if (curLeft.length() > prevLeft.length()) {
                prevLeft = curLeft;
            }

            if (curRight.length() > prevRight.length()) {
                prevRight = curRight;
            }

            System.out.printf("22 prevLeft = %s , prevRight = %s%n", prevLeft, prevRight);
        }

        String result = isPatternValid ? prevLeft + prevRight : "*";
        System.out.printf(OUTPUT_FORMAT, caseNum, result);
    }

    private boolean isPrefixMatching(String prevLeft, String curLeft) {
        int minLength = Math.min(prevLeft.length(), curLeft.length());
        for (int i = 0; i < minLength; i++) {
            if (prevLeft.charAt(i) != curLeft.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSuffixMatching(String prevRight, String curRight) {
        int minLength = Math.min(prevRight.length(), curRight.length());
        for (int i = 0; i < minLength; i++) {
            if (prevRight.charAt(prevRight.length() - 1 - i) != curRight.charAt(curRight.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}