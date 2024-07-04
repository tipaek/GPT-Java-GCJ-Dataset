import java.io.*;
import java.util.*;

public class Solution {
    public static int startIndex = 0;
    public static int endIndex = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        int cases = Integer.parseInt(reader.readLine().trim());

        for (int i = 0; i < cases; i++) {
            int n = Integer.parseInt(reader.readLine().trim());
            String[] patterns = new String[n];

            for (int j = 0; j < n; j++) {
                patterns[j] = reader.readLine().trim();
            }

            String start = handleStart(patterns[0]);
            String end = handleEnd(patterns[0]);
            StringBuilder mid = new StringBuilder(handleMid(patterns[0]));
            boolean finished = false;

            for (int j = 1; j < n; j++) {
                startIndex = 0;
                endIndex = 0;
                String pattern = patterns[j];

                if (!matchStart(pattern, start)) {
                    writer.println("Case #" + (i + 1) + ": *");
                    finished = true;
                    break;
                }

                if (!matchEnd(pattern, end)) {
                    writer.println("Case #" + (i + 1) + ": *");
                    finished = true;
                    break;
                }

                mid.append(extractMid(pattern));
            }

            if (!finished) {
                writer.println("Case #" + (i + 1) + ": " + start + mid + end);
            }
        }

        writer.close();
    }

    public static String handleStart(String pattern) {
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

    public static String handleMid(String pattern) {
        StringBuilder ans = new StringBuilder();
        for (int f = startIndex; f <= endIndex; f++) {
            if (pattern.charAt(f) != '*') {
                ans.append(pattern.charAt(f));
            }
        }
        return ans.toString();
    }

    public static String handleEnd(String pattern) {
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

    public static boolean matchStart(String pattern, String start) {
        for (int f = 0; f < pattern.length(); f++) {
            if (pattern.charAt(f) == '*') {
                startIndex = f;
                break;
            }
            if (f >= start.length() || pattern.charAt(f) != start.charAt(f)) {
                return false;
            }
        }
        return true;
    }

    public static boolean matchEnd(String pattern, String end) {
        for (int f = pattern.length() - 1; f >= 0; f--) {
            if (pattern.charAt(f) == '*') {
                endIndex = f;
                break;
            }
            int endOffset = end.length() - (pattern.length() - f);
            if (endOffset < 0 || pattern.charAt(f) != end.charAt(endOffset)) {
                return false;
            }
        }
        return true;
    }

    public static String extractMid(String pattern) {
        StringBuilder mid = new StringBuilder();
        for (int f = startIndex; f < endIndex; f++) {
            if (pattern.charAt(f) != '*') {
                mid.append(pattern.charAt(f));
            }
        }
        return mid.toString();
    }
}