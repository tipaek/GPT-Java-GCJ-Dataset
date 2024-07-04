import java.io.*;
import java.util.*;

public class Solution {
    private static final char ASTERISK = '*';

    private static String findPrefix(List<String> strs) {
        for (String candidate : strs) {
            boolean isValid = true;
            for (String str : strs) {
                if (!candidate.startsWith(str)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                return candidate;
            }
        }
        return null;
    }

    private static String findSuffix(List<String> strs) {
        for (String candidate : strs) {
            boolean isValid = true;
            for (String str : strs) {
                if (!candidate.endsWith(str)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                return candidate;
            }
        }
        return null;
    }

    private static String removeAsterisks(String str) {
        StringBuilder result = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch != ASTERISK) {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = Integer.parseInt(reader.readLine());
            List<String> prefixes = new ArrayList<>();
            List<String> suffixes = new ArrayList<>();
            StringBuilder middle = new StringBuilder();

            for (int i = 0; i < n; i++) {
                String s = reader.readLine();
                int forward = 0;
                while (forward < s.length() && s.charAt(forward) != ASTERISK) {
                    forward++;
                }
                int backward = s.length() - 1;
                while (backward >= 0 && s.charAt(backward) != ASTERISK) {
                    backward--;
                }
                prefixes.add(s.substring(0, forward));
                middle.append(removeAsterisks(s.substring(forward, backward)));
                suffixes.add(s.substring(backward + 1));
            }

            String prefix = findPrefix(prefixes);
            String suffix = findSuffix(suffixes);
            String output = (prefix != null && suffix != null) ? prefix + middle + suffix : "*";

            System.out.println("Case #" + testCase + ": " + output);
        }
        reader.close();
    }
}