import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int i = 1; i <= testCases; i++) {
                int patternCount = scanner.nextInt();
                String[] patterns = new String[patternCount];
                for (int j = 0; j < patternCount; j++) {
                    patterns[j] = scanner.next();
                }
                String result = solve(patterns);
                System.out.println("Case #" + i + ": " + result);
            }
        }
    }

    private static String solve(String[] patterns) {
        String prefix = "";
        String suffix = "";

        List<List<String>> splitPatterns = new ArrayList<>(patterns.length);
        for (String pattern : patterns) {
            String[] splitPattern = pattern.split("\\*");
            List<String> patternList = new ArrayList<>();
            for (String part : splitPattern) {
                patternList.add(part);
            }
            if (pattern.endsWith("*")) {
                patternList.add("");
            }
            splitPatterns.add(patternList);

            if (patternList.get(0).length() > prefix.length()) {
                prefix = patternList.get(0);
            }
            if (patternList.get(patternList.size() - 1).length() > suffix.length()) {
                suffix = patternList.get(patternList.size() - 1);
            }
        }

        List<String> middleParts = new ArrayList<>();
        int totalLength = prefix.length() + suffix.length();

        for (List<String> pattern : splitPatterns) {
            String patternPrefix = pattern.get(0);
            String patternSuffix = pattern.get(pattern.size() - 1);

            if (!prefix.startsWith(patternPrefix) || !suffix.endsWith(patternSuffix)) {
                return "*";
            }

            for (int j = 1; j < pattern.size() - 1; j++) {
                String part = pattern.get(j);
                boolean partFound = false;

                for (int k = 0; k < middleParts.size(); k++) {
                    String existingPart = middleParts.get(k);
                    if (existingPart.contains(part)) {
                        partFound = true;
                        break;
                    }
                    if (part.contains(existingPart)) {
                        middleParts.set(k, part);
                        totalLength += (part.length() - existingPart.length());
                        partFound = true;
                        break;
                    }
                }

                if (!partFound) {
                    middleParts.add(part);
                    totalLength += part.length();
                }

                if (totalLength > 10000) {
                    return "*";
                }
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(prefix);
        for (String part : middleParts) {
            result.append(part);
        }
        result.append(suffix);
        return result.toString();
    }
}