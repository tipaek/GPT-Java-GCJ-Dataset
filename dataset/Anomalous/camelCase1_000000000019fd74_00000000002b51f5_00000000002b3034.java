import java.util.*;
import java.io.*;

public class Solution {

    static BufferedReader br;
    static StringTokenizer tokenizer;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = nextInt();
            String[] patterns = new String[n];
            for (int i = 0; i < n; i++) {
                patterns[i] = next();
            }

            StringBuilder prefix = new StringBuilder();
            StringBuilder suffix = new StringBuilder();
            StringBuilder middle = new StringBuilder();

            int[] startIndices = new int[n];
            int[] endIndices = new int[n];

            if (!processPatterns(patterns, prefix, startIndices, true)) {
                System.out.println("Case #" + caseNumber++ + ": *");
                continue;
            }

            if (!processPatterns(patterns, suffix, endIndices, false)) {
                System.out.println("Case #" + caseNumber++ + ": *");
                continue;
            }

            for (int i = 0; i < n; i++) {
                middle.append(patterns[i].substring(startIndices[i], endIndices[i] + 1).replace("*", ""));
            }

            System.out.println("Case #" + caseNumber++ + ": " + prefix.toString() + middle.toString() + suffix.reverse().toString());
        }
    }

    public static boolean processPatterns(String[] patterns, StringBuilder result, int[] indices, boolean isPrefix) {
        for (int i = 0; i < patterns.length; i++) {
            String pattern = patterns[i];
            int limit = isPrefix ? pattern.length() : -1;
            int step = isPrefix ? 1 : -1;
            int start = isPrefix ? 0 : pattern.length() - 1;

            for (int j = start; j != limit; j += step) {
                if (pattern.charAt(j) == '*') {
                    indices[i] = j;
                    break;
                }
                int resultIndex = isPrefix ? j : pattern.length() - j - 1;
                if (result.length() <= resultIndex) {
                    result.append(pattern.charAt(j));
                } else if (result.charAt(resultIndex) != pattern.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                throw new IOException();
            }
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}