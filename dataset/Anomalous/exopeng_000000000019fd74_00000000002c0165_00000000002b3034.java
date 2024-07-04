import java.io.*;
import java.util.*;

public class Solution {
    public static int startIndex = 0;
    public static int endIndex = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        int cases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < cases; i++) {
            int n = Integer.parseInt(reader.readLine());
            String[] patterns = new String[n];

            for (int j = 0; j < n; j++) {
                patterns[j] = reader.readLine();
            }

            String result = processCase(patterns);
            writer.println("Case #" + (i + 1) + ": " + result);
        }
        writer.close();
    }

    private static String processCase(String[] patterns) {
        String start = handleStart(patterns[0]);
        String end = handleEnd(patterns[0]);
        StringBuilder mid = new StringBuilder(handleMid(patterns[0]));

        for (int j = 1; j < patterns.length; j++) {
            startIndex = 0;
            endIndex = 0;
            String pattern = patterns[j];

            if (!validateAndUpdateStart(pattern, start) || !validateAndUpdateEnd(pattern, end)) {
                return "*";
            }

            mid.append(extractMid(pattern));
        }

        return start + mid + end;
    }

    private static String handleStart(String pattern) {
        StringBuilder ans = new StringBuilder();
        for (int f = 0; f < pattern.length(); f++) {
            if (pattern.charAt(f) == '*') {
                startIndex = f;
                break;
            } else {
                ans.append(pattern.charAt(f));
            }
        }
        return ans.toString();
    }

    private static String handleMid(String pattern) {
        StringBuilder ans = new StringBuilder();
        for (int f = startIndex; f <= endIndex; f++) {
            if (pattern.charAt(f) != '*') {
                ans.append(pattern.charAt(f));
            }
        }
        return ans.toString();
    }

    private static String handleEnd(String pattern) {
        StringBuilder ans = new StringBuilder();
        for (int f = pattern.length() - 1; f >= 0; f--) {
            if (pattern.charAt(f) == '*') {
                endIndex = f;
                break;
            } else {
                ans.insert(0, pattern.charAt(f));
            }
        }
        return ans.toString();
    }

    private static boolean validateAndUpdateStart(String pattern, String start) {
        for (int f = 0; f < pattern.length(); f++) {
            if (pattern.charAt(f) == '*') {
                startIndex = f;
                break;
            }
            if (f >= start.length()) {
                start += pattern.charAt(f);
            } else if (pattern.charAt(f) != start.charAt(f)) {
                return false;
            }
        }
        return true;
    }

    private static boolean validateAndUpdateEnd(String pattern, String end) {
        for (int f = pattern.length() - 1; f >= 0; f--) {
            if (pattern.charAt(f) == '*') {
                endIndex = f;
                break;
            }
            if (pattern.length() - f > end.length()) {
                end = pattern.charAt(f) + end;
            } else if (pattern.charAt(f) != end.charAt(end.length() - (pattern.length() - f))) {
                return false;
            }
        }
        return true;
    }

    private static String extractMid(String pattern) {
        StringBuilder mid = new StringBuilder();
        for (int f = startIndex; f < endIndex; f++) {
            if (pattern.charAt(f) != '*') {
                mid.append(pattern.charAt(f));
            }
        }
        return mid.toString();
    }
}