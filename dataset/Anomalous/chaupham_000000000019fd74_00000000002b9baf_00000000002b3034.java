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
            scanner.nextLine(); // consume the newline
            List<String> patterns = new ArrayList<>();

            for (int j = 0; j < numberOfPatterns; j++) {
                String line = scanner.nextLine();
                while (line.isEmpty()) {
                    line = scanner.nextLine();
                }
                patterns.add(line);
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
                if (patternParts[0].length() > startWith.length() && patternParts[0].contains(startWith.replace("*", ""))) {
                    startWith = patternParts[0];
                } else if (startWith.contains(patternParts[0])) {
                    // do nothing
                } else {
                    return formatSolution(testCaseNumber, "*");
                }
            }

            String lastPart = patternParts[patternParts.length - 1];
            if (!lastPart.isEmpty()) {
                if (lastPart.length() > endWith.length() && lastPart.contains(endWith.replace("*", ""))) {
                    endWith = lastPart;
                } else if (endWith.contains(lastPart)) {
                    // do nothing
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
            result = startWith + String.join("", middleParts) + endWith;
        } else {
            result = exactString;
        }

        return formatSolution(testCaseNumber, result);
    }

    private static String formatSolution(int testCaseNumber, String result) {
        return String.format("Case #%d: %s", testCaseNumber, result);
    }
}