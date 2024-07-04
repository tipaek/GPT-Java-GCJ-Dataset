import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        List<String> solutions = new ArrayList<>();

        for (int i = 1; i <= numberOfTestCases; i++) {
            int numberOfPatterns = scanner.nextInt();
            scanner.nextLine(); // Consume the newline
            List<String> patterns = new ArrayList<>();
            for (int j = 0; j < numberOfPatterns; j++) {
                patterns.add(scanner.nextLine());
            }
            solutions.add(solve(patterns, i));
        }

        for (String solution : solutions) {
            System.out.println(solution);
        }
    }

    private static String solve(List<String> patterns, int testCaseNumber) {
        String result;
        int minLength = Integer.MAX_VALUE;

        for (String pattern : patterns) {
            int curMinLength = pattern.replaceAll("\\*", "").length();
            if (curMinLength < minLength) {
                minLength = curMinLength;
            }
        }

        String startWith = "*";
        String endWith = "*";
        List<String> middleParts = new ArrayList<>();
        String exactString = "*";

        for (String pattern : patterns) {
            String[] patternParts = pattern.split("\\*", -1);

            if (patternParts.length == 1) {
                if (!exactString.equals("*") && !exactString.equals(pattern)) {
                    return formatSolution(testCaseNumber, "*");
                }
                exactString = pattern;
                continue;
            }

            if (!patternParts[0].isEmpty()) {
                String startWithoutAsterisk = startWith.replace("*", "");
                if (startWith.equals("*")) {
                    startWith = patternParts[0];
                } else if (patternParts[0].length() > startWithoutAsterisk.length() && patternParts[0].contains(startWithoutAsterisk)) {
                    startWith = patternParts[0];
                } else if (startWithoutAsterisk.contains(patternParts[0])) {
                    // Do nothing
                } else {
                    return formatSolution(testCaseNumber, "*");
                }
            }

            String lastPart = patternParts[patternParts.length - 1];
            if (!lastPart.isEmpty()) {
                String endWithoutAsterisk = endWith.replace("*", "");
                if (endWith.equals("*")) {
                    endWith = lastPart;
                } else if (lastPart.length() > endWithoutAsterisk.length() && lastPart.contains(endWithoutAsterisk)) {
                    endWith = lastPart;
                } else if (endWithoutAsterisk.contains(lastPart)) {
                    // Do nothing
                } else {
                    return formatSolution(testCaseNumber, "*");
                }
            }

            for (int i = 1; i < patternParts.length - 1; i++) {
                if (!patternParts[i].isEmpty()) {
                    middleParts.add(patternParts[i]);
                }
            }
        }

        if (exactString.equals("*")) {
            if (middleParts.isEmpty()) {
                if (startWith.equals(endWith)) {
                    result = startWith;
                } else if (startWith.contains(endWith)) {
                    result = startWith;
                } else if (endWith.contains(startWith)) {
                    result = endWith;
                } else {
                    result = startWith + endWith;
                }
            } else {
                result = startWith + String.join("", middleParts) + endWith;
            }
        } else {
            result = exactString;
        }

        return formatSolution(testCaseNumber, result);
    }

    private static String formatSolution(int testCaseNumber, String result) {
        return String.format("Case #%d: %s", testCaseNumber, result);
    }
}