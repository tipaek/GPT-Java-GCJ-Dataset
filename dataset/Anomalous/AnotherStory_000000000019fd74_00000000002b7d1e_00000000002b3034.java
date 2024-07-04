import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            String[] patterns = new String[n];
            for (int i = 0; i < n; i++) {
                patterns[i] = scanner.next();
            }

            List<String> prefixes = new ArrayList<>();
            List<String> suffixes = new ArrayList<>();

            for (String pattern : patterns) {
                int asteriskIndex = pattern.indexOf('*');
                if (asteriskIndex != -1) {
                    if (asteriskIndex > 0) {
                        prefixes.add(pattern.substring(0, asteriskIndex));
                    }
                    if (asteriskIndex < pattern.length() - 1) {
                        suffixes.add(pattern.substring(asteriskIndex + 1));
                    }
                }
            }

            String longestPrefix = findLongestCommonPart(prefixes);
            String longestSuffix = findLongestCommonPart(suffixes);

            if (longestPrefix == null || longestSuffix == null) {
                System.out.println("Case #" + caseNumber + ": *");
            } else {
                System.out.println("Case #" + caseNumber + ": " + longestPrefix + longestSuffix);
            }
        }
    }

    private static String findLongestCommonPart(List<String> parts) {
        if (parts.isEmpty()) {
            return "";
        }

        String longestPart = parts.get(0);
        for (String part : parts) {
            if (!longestPart.contains(part)) {
                return null;
            }
        }

        return longestPart;
    }
}