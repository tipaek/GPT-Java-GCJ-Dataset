package com.jackson;

import java.util.*;

public class Main {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
                new Main().processCase(caseNum, scanner);
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
        String rightPart = firstPattern.substring(asteriskIndex + 1);

        System.out.printf("Initial leftPart = %s, rightPart = %s%n", leftPart, rightPart);

        for (String pattern : patterns) {
            asteriskIndex = pattern.indexOf("*");
            String currentLeft = pattern.substring(0, asteriskIndex);
            String currentRight = pattern.substring(asteriskIndex + 1);

            if (!leftPart.startsWith(currentLeft)) {
                isPatternValid = false;
                break;
            }

            if (currentLeft.length() > leftPart.length()) {
                leftPart = currentLeft;
            }

            if (!rightPart.endsWith(currentRight)) {
                isPatternValid = false;
                break;
            }

            if (currentRight.length() > rightPart.length()) {
                rightPart = currentRight;
            }

            System.out.printf("Updated leftPart = %s, rightPart = %s%n", leftPart, rightPart);
        }

        String result = isPatternValid ? leftPart + rightPart : "*";
        System.out.printf(OUTPUT_FORMAT, caseNum, result);
    }
}