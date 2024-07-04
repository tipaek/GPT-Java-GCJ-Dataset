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
        List<String> results = new ArrayList<>();

        for (int i = 1; i <= numberOfTestCases; i++) {
            int numberOfPatterns = scanner.nextInt();
            List<String> patterns = new ArrayList<>();
            scanner.nextLine(); // Consume the newline

            for (int j = 0; j < numberOfPatterns; j++) {
                String line = scanner.nextLine().trim();
                while (line.isEmpty()) {
                    line = scanner.nextLine().trim();
                }
                patterns.add(line);
            }
            results.add(solve(patterns, i));
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static String solve(List<String> patterns, int testCaseNumber) {
        Set<String> patternSet = new HashSet<>();
        for (String pattern : patterns) {
            patternSet.add(pattern.substring(1));
        }

        String result = "*";
        for (String pattern : patternSet) {
            if (result.equals("*")) {
                result = pattern;
                continue;
            }

            if (result.endsWith(pattern) || pattern.endsWith(result)) {
                result = pattern.length() > result.length() ? pattern : result;
            } else {
                result = "*";
                break;
            }
        }

        if (result.isEmpty()) {
            result = "*";
        }

        return formatSolution(testCaseNumber, result);
    }

    private static String formatSolution(int testCaseNumber, String result) {
        return String.format("Case #%d: %s", testCaseNumber, result);
    }
}