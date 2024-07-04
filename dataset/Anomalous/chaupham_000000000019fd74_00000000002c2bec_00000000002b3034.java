import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        List<String> solutions = new ArrayList<>();

        for (int i = 1; i <= numberOfTestCases; ++i) {
            int numberOfPatterns = scanner.nextInt();
            scanner.nextLine(); // consume the remaining newline
            List<String> patterns = new ArrayList<>();
            for (int j = 0; j < numberOfPatterns; j++) {
                patterns.add(scanner.nextLine().trim());
            }
            solutions.add(solve(patterns, i));
        }

        for (String solution : solutions) {
            System.out.println(solution);
        }
    }

    private static String solve(List<String> patterns, int testCaseNumber) {
        String startWith = "";
        String endWith = "";
        List<String> middleParts = new ArrayList<>();
        String exactString = "*";
        Set<String> patternSet = new HashSet<>(patterns);

        for (String pattern : patternSet) {
            if (pattern.equals("*")) {
                continue;
            }

            String[] patternParts = pattern.split("\\*", -1);

            if (patternParts.length == 1) {
                exactString = pattern;
                break;
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

        String result;
        if (exactString.equals("*")) {
            result = startWith + String.join("", middleParts) + endWith;
        } else {
            result = exactString;
            for (String pattern : patterns) {
                if (!pattern.equals("*") && !exactString.contains(pattern.replace("*", ""))) {
                    result = "*";
                    break;
                }
            }
        }

        return formatSolution(testCaseNumber, result.isEmpty() ? "*" : result);
    }

    private static String formatSolution(int testCaseNumber, String result) {
        return String.format("Case #%d: %s", testCaseNumber, result);
    }
}