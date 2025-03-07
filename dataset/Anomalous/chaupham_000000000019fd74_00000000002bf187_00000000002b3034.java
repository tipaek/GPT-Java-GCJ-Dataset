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
            scanner.nextLine(); // Consume the newline character
            List<String> patterns = new ArrayList<>();
            for (int j = 0; j < numberOfPatterns; j++) {
                String line;
                do {
                    line = scanner.nextLine();
                } while (line.isEmpty());
                patterns.add(line);
            }
            solutions.add(solve(patterns, i));
        }

        solutions.forEach(System.out::println);
    }

    private static String solve(List<String> patterns, int testCaseNumber) {
        String result = null;
        int minLength = Integer.MAX_VALUE;

        for (String pattern : patterns) {
            int curMinLength = pattern.replaceAll("\\*", "").length();
            if (curMinLength < minLength) {
                minLength = curMinLength;
            }
        }

        String startWith = "";
        String endWith = "";
        List<String> middleParts = new ArrayList<>();
        String exactString = "*";

        for (String pattern : patterns) {
            String[] patternParts = pattern.trim().split("\\*", -1);

            if (patternParts.length == 1 && !exactString.equals("*") && !exactString.equals(pattern)) {
                return formatSolution(testCaseNumber, "*");
            }

            if (patternParts.length == 1) {
                exactString = pattern;
                continue;
            }

            String firstPart = patternParts[0];
            if (!firstPart.isEmpty()) {
                if (startWith.isEmpty() || firstPart.contains(startWith)) {
                    startWith = firstPart;
                } else if (!startWith.contains(firstPart)) {
                    return formatSolution(testCaseNumber, "*");
                }
            }

            String lastPart = patternParts[patternParts.length - 1];
            if (!lastPart.isEmpty()) {
                if (endWith.equals("*") || lastPart.contains(endWith)) {
                    endWith = lastPart;
                } else if (!endWith.contains(lastPart)) {
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
                if (startWith.equals(endWith) || startWith.contains(endWith) || endWith.contains(startWith)) {
                    result = startWith + endWith;
                } else {
                    result = startWith + endWith;
                }
            } else {
                result = startWith + String.join("", middleParts) + endWith;
            }
        } else {
            result = exactString;
        }

        return result.isEmpty() ? formatSolution(testCaseNumber, "*") : formatSolution(testCaseNumber, result);
    }

    private static String formatSolution(int testCaseNumber, String result) {
        return String.format("Case #%d: %s", testCaseNumber, result);
    }
}