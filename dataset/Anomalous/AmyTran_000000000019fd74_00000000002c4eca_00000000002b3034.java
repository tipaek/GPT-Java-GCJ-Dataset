import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();

        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int patternsCount = scanner.nextInt();
            List<String> patterns = new ArrayList<>();
            for (int j = 0; j < patternsCount; j++) {
                patterns.add(scanner.nextToken());
            }
            System.out.println("Case #" + (i + 1) + ": " + determineFinalString(patterns));
        }
    }

    private static String determineFinalString(List<String> patterns) {
        String longestPattern = patterns.get(0);
        for (String pattern : patterns) {
            if (pattern.length() > longestPattern.length()) {
                longestPattern = pattern;
            }
        }

        for (String pattern : patterns) {
            String cleanedPattern = pattern.replace("*", "");
            String cleanedLongestPattern = longestPattern.replace("*", "");
            if (!cleanedLongestPattern.equals(cleanedPattern) && !cleanedLongestPattern.endsWith(cleanedPattern)) {
                return "*";
            }
        }

        return longestPattern.replace("*", "");
    }

    public static class FastScanner {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public FastScanner(String fileName) {
            try {
                reader = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}