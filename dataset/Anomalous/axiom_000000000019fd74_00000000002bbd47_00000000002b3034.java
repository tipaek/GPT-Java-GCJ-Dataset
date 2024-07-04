import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            String[] patterns = new String[n];
            for (int j = 0; j < n; j++) {
                patterns[j] = scanner.next();
            }
            String result = solve(patterns);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String solve(String[] patterns) {
        String prefix = "";
        String suffix = "";

        List<List<String>> splitPatterns = new ArrayList<>();
        for (String pattern : patterns) {
            String[] parts = pattern.split("\\*");
            List<String> partsList = new ArrayList<>();
            for (String part : parts) {
                partsList.add(part);
            }
            if (pattern.endsWith("*")) {
                partsList.add("");
            }
            splitPatterns.add(partsList);

            if (parts[0].length() > prefix.length()) {
                prefix = parts[0];
            }
            if (parts[parts.length - 1].length() > suffix.length()) {
                suffix = parts[parts.length - 1];
            }
        }

        List<String> middleParts = new ArrayList<>();
        int totalLength = prefix.length() + suffix.length();

        for (List<String> patternParts : splitPatterns) {
            String startPart = patternParts.get(0);
            String endPart = patternParts.get(patternParts.size() - 1);

            if (!prefix.startsWith(startPart)) {
                return "*";
            }
            if (!suffix.endsWith(endPart)) {
                return "*";
            }

            for (int j = 1; j < patternParts.size() - 1; j++) {
                String middlePart = patternParts.get(j);
                boolean found = false;
                for (int k = 0; k < middleParts.size(); k++) {
                    String existingPart = middleParts.get(k);
                    if (existingPart.contains(middlePart)) {
                        found = true;
                        break;
                    }
                    if (middlePart.contains(existingPart)) {
                        middleParts.set(k, middlePart);
                        totalLength += (middlePart.length() - existingPart.length());
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    middleParts.add(middlePart);
                    totalLength += middlePart.length();
                }
                if (totalLength > 10000) {
                    return "*";
                }
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(prefix);
        for (String middlePart : middleParts) {
            result.append(middlePart);
        }
        result.append(suffix);
        return result.toString();
    }
}