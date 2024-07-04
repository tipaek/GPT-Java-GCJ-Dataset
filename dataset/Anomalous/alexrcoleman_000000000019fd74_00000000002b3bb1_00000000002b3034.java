import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            List<String> prefixes = new ArrayList<>();
            List<String> suffixes = new ArrayList<>();
            List<String> middleParts = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String pattern = scanner.next();
                String[] parts = pattern.split("\\*");
                
                if (pattern.endsWith("*")) {
                    parts = Arrays.copyOf(parts, parts.length + 1);
                    parts[parts.length - 1] = "";
                }

                prefixes.add(parts[0]);
                suffixes.add(parts[parts.length - 1]);
                for (int j = 1; j < parts.length - 1; j++) {
                    middleParts.add(parts[j]);
                }
            }

            String longestPrefix = findLongestMatch(prefixes, true);
            String longestSuffix = findLongestMatch(suffixes, false);

            String result = "*";
            if (longestPrefix != null && longestSuffix != null) {
                StringBuilder sb = new StringBuilder(longestPrefix);
                for (String middle : middleParts) {
                    sb.append(middle);
                }
                sb.append(longestSuffix);
                result = sb.toString();
            }

            System.out.printf("Case #%d: %s\n", t, result);
        }
        scanner.close();
    }

    private static String findLongestMatch(List<String> list, boolean isPrefix) {
        String longest = "";
        for (String s : list) {
            if (s.length() > longest.length()) {
                longest = s;
            }
        }

        for (String s : list) {
            if (isPrefix) {
                if (!longest.startsWith(s)) {
                    return null;
                }
            } else {
                if (!longest.endsWith(s)) {
                    return null;
                }
            }
        }
        return longest;
    }
}