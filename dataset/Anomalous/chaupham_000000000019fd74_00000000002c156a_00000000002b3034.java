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
                String line;
                do {
                    line = scanner.nextLine().trim();
                } while (line.isEmpty());
                patterns.add(line);
            }

            results.add(processPatterns(patterns, i));
        }

        results.forEach(System.out::println);
    }

    private static String processPatterns(List<String> patterns, int testCaseNumber) {
        String prefix = "";
        String suffix = "";
        List<String> middleParts = new ArrayList<>();
        String exactMatch = "*";

        for (String pattern : patterns) {
            String[] parts = pattern.split("\\*", -1);

            if (parts.length == 1) {
                exactMatch = pattern;
                break;
            }

            String firstPart = parts[0];
            if (!firstPart.isEmpty()) {
                if (prefix.isEmpty() || firstPart.startsWith(prefix)) {
                    prefix = firstPart;
                } else if (!prefix.startsWith(firstPart)) {
                    return formatSolution(testCaseNumber, "*");
                }
            }

            String lastPart = parts[parts.length - 1];
            if (!lastPart.isEmpty()) {
                if (suffix.equals("*") || lastPart.endsWith(suffix)) {
                    suffix = lastPart;
                } else if (!suffix.endsWith(lastPart)) {
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
        if (exactMatch.equals("*")) {
            result = prefix + String.join("", middleParts) + suffix;
        } else {
            result = exactMatch;
            for (String pattern : patterns) {
                if (!exactMatch.equals(pattern.replace("*", ""))) {
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