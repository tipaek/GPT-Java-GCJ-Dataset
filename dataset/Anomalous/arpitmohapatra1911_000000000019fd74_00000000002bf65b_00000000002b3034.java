package com.jackson;

import java.util.*;

public class SolutionPatternMatching {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new SolutionPatternMatching().getAnswer(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAnswer(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        List<String> patterns = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            patterns.add(scanner.next());
        }

        patterns.sort(Comparator.comparingInt(String::length));

        patterns.forEach(System.out::println);

        boolean isPatternValid = true;
        String firstPattern = patterns.get(0);
        int starIndex = firstPattern.indexOf('*');
        String leftPart = firstPattern.substring(0, starIndex);
        String rightPart = starIndex < firstPattern.length() ? firstPattern.substring(starIndex + 1) : "";

        System.out.printf("Initial leftPart = %s, rightPart = %s%n", leftPart, rightPart);

        for (String pattern : patterns) {
            starIndex = pattern.indexOf('*');
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

            System.out.printf("Updated leftPart = %s, rightPart = %s%n", leftPart, rightPart);
        }

        String result = isPatternValid ? leftPart + rightPart : "*";
        System.out.printf(OUTPUT_FORMAT, caseNum, result);
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
        int prevLength = prev.length();
        int currLength = curr.length();
        int minLength = Math.min(prevLength, currLength);
        for (int i = 0; i < minLength; i++) {
            if (prev.charAt(prevLength - 1 - i) != curr.charAt(currLength - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}