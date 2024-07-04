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
            scanner.nextLine(); // Consume newline
            List<String> patterns = new ArrayList<>();

            for (int j = 0; j < numberOfPatterns; j++) {
                patterns.add(scanner.nextLine());
            }

            results.add(processTestCase(patterns, i));
        }

        results.forEach(System.out::println);
    }

    private static String processTestCase(List<String> patterns, int testCaseNumber) {
        String start = "", end = "", exact = "*";
        List<String> middleParts = new ArrayList<>();

        for (String pattern : patterns) {
            String[] parts = pattern.split("\\*", -1);

            if (parts.length == 1) {
                if (!exact.equals("*") && !exact.equals(pattern)) {
                    return formatResult(testCaseNumber, "*");
                }
                exact = pattern;
                continue;
            }

            String firstPart = parts[0];
            if (!firstPart.isEmpty()) {
                if (start.isEmpty() || firstPart.contains(start)) {
                    start = firstPart;
                } else if (!start.contains(firstPart)) {
                    return formatResult(testCaseNumber, "*");
                }
            }

            String lastPart = parts[parts.length - 1];
            if (!lastPart.isEmpty()) {
                if (end.equals("*") || lastPart.contains(end)) {
                    end = lastPart;
                } else if (!end.contains(lastPart)) {
                    return formatResult(testCaseNumber, "*");
                }
            }

            for (int i = 1; i < parts.length - 1; i++) {
                if (!parts[i].isEmpty()) {
                    middleParts.add(parts[i]);
                }
            }
        }

        String result;
        if (exact.equals("*")) {
            result = start + String.join("", middleParts) + end;
        } else {
            result = exact;
        }

        return formatResult(testCaseNumber, result);
    }

    private static String formatResult(int testCaseNumber, String result) {
        return String.format("Case #%d: %s", testCaseNumber, result);
    }
}