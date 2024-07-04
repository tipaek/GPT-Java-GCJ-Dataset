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

        for (int i = 1; i <= numberOfTestCases; ++i) {
            int numberOfPatterns = scanner.nextInt();
            List<String> patterns = new ArrayList<>();
            scanner.nextLine(); // Consume the remaining newline

            for (int j = 0; j < numberOfPatterns; j++) {
                String line;
                while ((line = scanner.nextLine()).isEmpty());
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
            String[] parts = pattern.split("\\*", -1);

            if (parts.length == 1) {
                if (!exactString.equals("*") && !exactString.equals(pattern)) {
                    return formatSolution(testCaseNumber, "*");
                }
                exactString = pattern;
                continue;
            }

            String firstPart = parts[0];
            if (!firstPart.isEmpty()) {
                if (startWith.isEmpty() || firstPart.contains(startWith)) {
                    startWith = firstPart;
                } else if (!startWith.contains(firstPart)) {
                    return formatSolution(testCaseNumber, "*");
                }
            }

            String lastPart = parts[parts.length - 1];
            if (!lastPart.isEmpty()) {
                if (endWith.equals("*") || lastPart.contains(endWith)) {
                    endWith = lastPart;
                } else if (!endWith.contains(lastPart)) {
                    return formatSolution(testCaseNumber, "*");
                }
            }

            for (int i = 1; i < parts.length - 1; i++) {
                if (!parts[i].isEmpty()) {
                    middleParts.add(parts[i]);
                }
            }
        }

        String result;
        if (exactString.equals("*")) {
            result = (startWith + String.join("", middleParts) + endWith).replace("*", "");
        } else {
            result = exactString;
        }

        return formatSolution(testCaseNumber, result.isEmpty() ? "*" : result);
    }

    private static String formatSolution(int testCaseNumber, String result) {
        return String.format("Case #%d: %s", testCaseNumber, result);
    }
}