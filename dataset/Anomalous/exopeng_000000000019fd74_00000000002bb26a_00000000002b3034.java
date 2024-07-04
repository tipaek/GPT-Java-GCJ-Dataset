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
            String start = "", end = "", mid = "";
            boolean finished = false;

            start = handleStart(reader.readLine().trim());
            end = handleEnd(reader.readLine().trim());
            mid = handleMid(reader.readLine().trim());

            for (int j = 1; j < n; j++) {
                startIndex = 0;
                endIndex = 0;
                String pattern = reader.readLine().trim();

                if (!processPatternStart(pattern, start)) {
                    writer.println("Case #" + (i + 1) + ": *");
                    finished = true;
                    break;
                }

                if (!processPatternEnd(pattern, end)) {
                    writer.println("Case #" + (i + 1) + ": *");
                    finished = true;
                    break;
                }

                mid += extractMiddle(pattern);
            }

            if (!finished) {
                writer.println("Case #" + (i + 1) + ": " + start + mid + end);
            }
        }

        writer.close();
    }

    public static String handleStart(String pattern) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == '*') {
                startIndex = i;
                break;
            }
            ans.append(pattern.charAt(i));
        }
        return ans.toString();
    }

    public static String handleMid(String pattern) {
        StringBuilder ans = new StringBuilder();
        for (int i = startIndex; i <= endIndex; i++) {
            if (pattern.charAt(i) != '*') {
                ans.append(pattern.charAt(i));
            }
        }
        return ans.toString();
    }

    public static String handleEnd(String pattern) {
        StringBuilder ans = new StringBuilder();
        for (int i = pattern.length() - 1; i >= 0; i--) {
            if (pattern.charAt(i) == '*') {
                endIndex = i;
                break;
            }
            ans.insert(0, pattern.charAt(i));
        }
        return ans.toString();
    }

    public static boolean processPatternStart(String pattern, String start) {
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

    public static boolean processPatternEnd(String pattern, String end) {
        for (int i = pattern.length() - 1; i >= 0; i--) {
            if (pattern.charAt(i) == '*') {
                endIndex = i;
                break;
            }
            if (pattern.length() - 1 - i >= end.length() || pattern.charAt(i) != end.charAt(end.length() - (pattern.length() - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    public static String extractMiddle(String pattern) {
        StringBuilder mid = new StringBuilder();
        for (int i = startIndex; i < endIndex; i++) {
            if (pattern.charAt(i) != '*') {
                mid.append(pattern.charAt(i));
            }
        }
        return mid.toString();
    }
}