import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            List<String> patterns = new ArrayList<>();
            int patternCount = scanner.nextInt();
            
            for (int j = 0; j < patternCount; j++) {
                patterns.add(scanner.next());
            }
            
            solve(i, patterns);
        }
    }

    public static void solve(int testCaseNumber, List<String> patterns) {
        StringBuilder prefix = new StringBuilder();
        StringBuilder suffix = new StringBuilder();
        boolean isPossible = true;

        for (String pattern : patterns) {
            String[] parts = splitPattern(pattern);

            if (!mergePrefix(prefix, parts[0]) || !mergeSuffix(suffix, parts[1])) {
                isPossible = false;
                break;
            }
        }

        System.out.println("Case #" + testCaseNumber + ": " + (isPossible ? prefix.toString() + suffix.toString() : "*"));
    }

    private static String[] splitPattern(String pattern) {
        String[] parts = new String[2];

        if (pattern.startsWith("*")) {
            parts[0] = "";
            parts[1] = pattern.substring(1);
        } else if (pattern.endsWith("*")) {
            parts[0] = pattern.substring(0, pattern.length() - 1);
            parts[1] = "";
        } else {
            parts = pattern.split("\\*", 2);
        }

        return parts;
    }

    private static boolean mergePrefix(StringBuilder prefix, String part) {
        if (prefix.length() == 0 || part.length() == 0) {
            prefix.append(part);
        } else if (part.length() >= prefix.length()) {
            if (part.startsWith(prefix.toString())) {
                prefix.setLength(0);
                prefix.append(part);
            } else {
                return false;
            }
        } else if (!prefix.toString().startsWith(part)) {
            return false;
        }
        return true;
    }

    private static boolean mergeSuffix(StringBuilder suffix, String part) {
        if (suffix.length() == 0 || part.length() == 0) {
            suffix.append(part);
        } else if (part.length() >= suffix.length()) {
            if (part.endsWith(suffix.toString())) {
                suffix.setLength(0);
                suffix.append(part);
            } else {
                return false;
            }
        } else if (!suffix.toString().endsWith(part)) {
            return false;
        }
        return true;
    }
}