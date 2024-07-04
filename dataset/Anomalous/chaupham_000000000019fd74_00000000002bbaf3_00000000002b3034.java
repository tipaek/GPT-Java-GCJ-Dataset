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
            scanner.nextLine(); // Consume the newline
            List<String> patterns = new ArrayList<>();
            for (int j = 0; j < numberOfPatterns; j++) {
                patterns.add(scanner.nextLine().trim());
            }
            results.add(solve(patterns, i));
        }

        results.forEach(System.out::println);
    }

    private static String solve(List<String> patterns, int testCaseNumber) {
        String start = "", end = "", exactMatch = "";
        List<String> middleParts = new ArrayList<>();

        for (String pattern : patterns) {
            String[] parts = pattern.split("\\*", -1);

            if (parts.length == 1) {
                if (!exactMatch.isEmpty() && !exactMatch.equals(pattern)) {
                    return formatResult(testCaseNumber, "*");
                }
                exactMatch = pattern;
                continue;
            }

            if (!parts[0].isEmpty()) {
                if (start.isEmpty() || parts[0].startsWith(start) || start.startsWith(parts[0])) {
                    start = parts[0].length() > start.length() ? parts[0] : start;
                } else {
                    return formatResult(testCaseNumber, "*");
                }
            }

            if (!parts[parts.length - 1].isEmpty()) {
                if (end.isEmpty() || parts[parts.length - 1].endsWith(end) || end.endsWith(parts[parts.length - 1])) {
                    end = parts[parts.length - 1].length() > end.length() ? parts[parts.length - 1] : end;
                } else {
                    return formatResult(testCaseNumber, "*");
                }
            }

            for (int i = 1; i < parts.length - 1; i++) {
                if (!parts[i].isEmpty()) {
                    middleParts.add(parts[i]);
                }
            }
        }

        if (exactMatch.isEmpty()) {
            StringBuilder result = new StringBuilder(start);
            middleParts.forEach(result::append);
            result.append(end);
            return formatResult(testCaseNumber, result.toString());
        } else {
            return formatResult(testCaseNumber, exactMatch);
        }
    }

    private static String formatResult(int testCaseNumber, String result) {
        return String.format("Case #%d: %s", testCaseNumber, result);
    }
}