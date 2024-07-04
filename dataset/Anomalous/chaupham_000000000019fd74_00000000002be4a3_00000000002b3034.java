import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        List<String> results = new ArrayList<>();

        for (int i = 1; i <= numberOfTestCases; i++) {
            int numberOfPatterns = scanner.nextInt();
            scanner.nextLine(); // consume the remaining newline
            List<String> patterns = new ArrayList<>();
            
            for (int j = 0; j < numberOfPatterns; j++) {
                String pattern = scanner.nextLine().trim();
                patterns.add(pattern);
            }
            results.add(solve(patterns, i));
        }

        results.forEach(System.out::println);
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
                if (endWith.isEmpty() || lastPart.contains(endWith)) {
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
            result = startWith + String.join("", middleParts) + endWith;
        } else {
            result = exactString;
        }

        return formatSolution(testCaseNumber, result.isEmpty() ? "*" : result);
    }

    private static String formatSolution(int testCaseNumber, String result) {
        return String.format("Case #%d: %s", testCaseNumber, result);
    }
}