import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCaseCount; caseNumber++) {
            int regexCount = scanner.nextInt();
            scanner.nextLine();
            List<String> regexList = new ArrayList<>();

            for (int j = 0; j < regexCount; j++) {
                regexList.add(scanner.nextLine());
            }

            String result = solve(regexList);
            if (result.isEmpty()) {
                result = "A";
            }
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    public static String solve(List<String> regexList) {
        String prefix = "";
        String suffix = "";
        List<String> remainingPatterns = new ArrayList<>();

        for (String pattern : regexList) {
            String patternPrefix = "";
            String patternSuffix = "";

            if (pattern.contains("*")) {
                patternPrefix = pattern.substring(0, pattern.indexOf('*'));
                patternSuffix = pattern.substring(pattern.lastIndexOf('*') + 1);
            } else {
                return pattern;
            }

            if (prefix.isEmpty()) {
                prefix = patternPrefix;
            }
            if (suffix.isEmpty()) {
                suffix = patternSuffix;
            }

            if (prefix.contains(patternPrefix) || patternPrefix.contains(prefix)) {
                prefix = prefix.length() >= patternPrefix.length() ? prefix : patternPrefix;
            } else {
                return "*";
            }

            if (suffix.contains(patternSuffix) || patternSuffix.contains(suffix)) {
                suffix = suffix.length() >= patternSuffix.length() ? suffix : patternSuffix;
            } else {
                return "*";
            }

            String middlePart = extractMiddlePart(pattern, patternPrefix, patternSuffix);
            if (!middlePart.isEmpty() && !middlePart.equals("*")) {
                remainingPatterns.add(middlePart);
            }
        }

        if (remainingPatterns.isEmpty()) {
            return prefix + suffix;
        } else {
            return prefix + solve(remainingPatterns) + suffix;
        }
    }

    private static String extractMiddlePart(String pattern, String patternPrefix, String patternSuffix) {
        if (patternPrefix.isEmpty() || patternSuffix.isEmpty()) {
            if (patternPrefix.isEmpty() && patternSuffix.isEmpty()) {
                return pattern.substring(1, pattern.length() - 1);
            } else if (patternPrefix.isEmpty()) {
                return pattern.substring(1, pattern.indexOf(patternSuffix));
            } else {
                return pattern.substring(pattern.indexOf(patternPrefix) + 1, pattern.length() - 1);
            }
        } else {
            return pattern.substring(pattern.indexOf(patternPrefix) + 1, pattern.indexOf(patternSuffix));
        }
    }
}