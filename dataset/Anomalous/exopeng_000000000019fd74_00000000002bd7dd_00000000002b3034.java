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
            boolean finished = false;

            String start = "", end = "", mid = "";
            String firstPattern = reader.readLine().trim();
            start = extractStart(firstPattern);
            end = extractEnd(firstPattern);
            mid = extractMid(firstPattern);

            for (int j = 1; j < n; j++) {
                startIndex = 0;
                endIndex = 0;
                String pattern = reader.readLine().trim();

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

                mid += extractMid(pattern);
            }

            if (!finished) {
                writer.println("Case #" + (i + 1) + ": " + start + mid + end);
            }
        }
        writer.close();
    }

    private static String extractStart(String pattern) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == '*') {
                startIndex = i;
                break;
            }
            result.append(pattern.charAt(i));
        }
        return result.toString();
    }

    private static String extractMid(String pattern) {
        StringBuilder result = new StringBuilder();
        for (int i = startIndex; i <= endIndex; i++) {
            if (pattern.charAt(i) != '*') {
                result.append(pattern.charAt(i));
            }
        }
        return result.toString();
    }

    private static String extractEnd(String pattern) {
        StringBuilder result = new StringBuilder();
        for (int i = pattern.length() - 1; i >= 0; i--) {
            if (pattern.charAt(i) == '*') {
                endIndex = i;
                break;
            }
            result.insert(0, pattern.charAt(i));
        }
        return result.toString();
    }

    private static boolean matchStart(String pattern, String start) {
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == '*') {
                startIndex = i;
                break;
            }
            if (i >= start.length() || pattern.charAt(i) != start.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean matchEnd(String pattern, String end) {
        for (int i = pattern.length() - 1; i >= 0; i--) {
            if (pattern.charAt(i) == '*') {
                endIndex = i;
                break;
            }
            int endIdx = end.length() - (pattern.length() - i);
            if (endIdx < 0 || pattern.charAt(i) != end.charAt(endIdx)) {
                return false;
            }
        }
        return true;
    }
}