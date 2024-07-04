import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = in.nextInt();
        List<String> solutions = new ArrayList<>();

        for (int i = 1; i <= numberOfTestCases; ++i) {
            int numberOfPattern = in.nextInt();
            in.nextLine(); // Consume the newline character
            List<String> patterns = new ArrayList<>();

            for (int row = 0; row < numberOfPattern; row++) {
                String line = in.nextLine().trim();
                while (line.isEmpty()) {
                    line = in.nextLine().trim();
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
        String startWith = "";
        String endWith = "";
        List<String> middleParts = new ArrayList<>();
        String exactString = "*";

        for (String pattern : patterns) {
            if (pattern.equals("*")) continue;

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
                    return printSolution(testCaseNumber, "*");
                }
            }

            String lastPart = patternParts[patternParts.length - 1];
            if (!lastPart.isEmpty()) {
                if (endWith.isEmpty() || lastPart.contains(endWith)) {
                    endWith = lastPart;
                } else if (!endWith.contains(lastPart)) {
                    return printSolution(testCaseNumber, "*");
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
                if (!pattern.equals("*") && !exactString.equals(pattern.replace("*", ""))) {
                    result = "*";
                    break;
                }
            }
        }

        return result.isEmpty() ? printSolution(testCaseNumber, "*") : printSolution(testCaseNumber, result);
    }

    private static String printSolution(int testCaseNumber, String result) {
        return String.format("Case #%d: %s", testCaseNumber, result);
    }
}