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
        int n = scanner.nextInt();
        List<String> firstParts = new ArrayList<>();
        List<String> lastParts = new ArrayList<>();
        List<String> patterns = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String pattern = "A" + scanner.next() + "Z";
            patterns.add(pattern);
            String[] splitPattern = pattern.split("\\*");
            firstParts.add(splitPattern[0]);
            lastParts.add(splitPattern[splitPattern.length - 1]);
        }

        String longestFirstPart = getLongestString(firstParts);
        String longestLastPart = getLongestString(lastParts);

        if (!allPartsMatch(firstParts, longestFirstPart, true) || !allPartsMatch(lastParts, longestLastPart, false)) {
            return "*";
        }

        StringBuilder result = new StringBuilder(longestFirstPart);
        for (String pattern : patterns) {
            String[] splitPattern = pattern.split("\\*");
            for (int i = 1; i < splitPattern.length - 1; i++) {
                result.append(splitPattern[i]);
            }
        }
        result.append(longestLastPart);

        return result.substring(1, result.length() - 1);
    }

    private static String getLongestString(List<String> parts) {
        String longest = "";
        for (String part : parts) {
            if (part.length() > longest.length()) {
                longest = part;
            }
        }
        return longest;
    }

    private static boolean allPartsMatch(List<String> parts, String longestPart, boolean isFirstPart) {
        for (String part : parts) {
            if (isFirstPart) {
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