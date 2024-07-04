import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            String result = solve(scanner);
            System.out.println("Case #" + i + ": " + result);
        }
        scanner.close();
    }

    public static String solve(Scanner scanner) {
        int patternCount = scanner.nextInt();
        List<String> firstParts = new ArrayList<>();
        List<String> lastParts = new ArrayList<>();
        List<String> patterns = new ArrayList<>();

        for (int i = 0; i < patternCount; i++) {
            String pattern = scanner.next();
            patterns.add(pattern);
            String[] parts = pattern.split("\\*");
            firstParts.add(parts[0]);
            lastParts.add(parts[parts.length - 1]);
        }

        String longestFirstPart = findLongestPart(firstParts);
        String longestLastPart = findLongestPart(lastParts);

        if (!matchesAllPatterns(firstParts, longestFirstPart, true) || 
            !matchesAllPatterns(lastParts, longestLastPart, false)) {
            return "*";
        }

        StringBuilder resultBuilder = new StringBuilder(longestFirstPart);
        for (String pattern : patterns) {
            String[] parts = pattern.split("\\*");
            for (int i = 1; i < parts.length - 1; i++) {
                resultBuilder.append(parts[i]);
            }
        }
        resultBuilder.append(longestLastPart);
        return resultBuilder.toString();
    }

    private static String findLongestPart(List<String> parts) {
        String longestPart = "";
        for (String part : parts) {
            if (part.length() > longestPart.length()) {
                longestPart = part;
            }
        }
        return longestPart;
    }

    private static boolean matchesAllPatterns(List<String> parts, String longestPart, boolean fromStart) {
        for (String part : parts) {
            if (fromStart) {
                if (!longestPart.startsWith(part)) {
                    return false;
                }
            } else {
                if (!longestPart.endsWith(part)) {
                    return false;
                }
            }
        }
        return true;
    }
}