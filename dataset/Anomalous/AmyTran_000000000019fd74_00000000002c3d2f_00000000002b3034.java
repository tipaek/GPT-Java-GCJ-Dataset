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
            System.out.println("Case #" + (i + 1) + ": " + mergePatterns(patterns));
        }
    }

    private static String mergePatterns(List<String> patterns) {
        List<String> finalPattern = new ArrayList<>();
        for (String pattern : patterns) {
            List<String> parts = new ArrayList<>();
            int start = 0;
            for (int j = 0; j < pattern.length(); j++) {
                if (pattern.charAt(j) == '*') {
                    if (j > start) {
                        parts.add(pattern.substring(start, j));
                    }
                    parts.add("");
                    start = j + 1;
                }
                if (j == pattern.length() - 1 && j >= start) {
                    parts.add(pattern.substring(start, j + 1));
                }
            }
            List<String> tempPattern = new ArrayList<>(finalPattern);
            if (!validateStart(finalPattern, tempPattern, parts) || !validateEnd(finalPattern, tempPattern, parts)) {
                return "*";
            }
            finalPattern = new ArrayList<>(tempPattern);
        }
        return String.join("", finalPattern);
    }

    private static boolean validateStart(List<String> finalPattern, List<String> tempPattern, List<String> parts) {
        String currentStart = parts.isEmpty() ? "" : parts.get(0);
        String finalStart = finalPattern.isEmpty() ? "" : finalPattern.get(0);

        if (currentStart.startsWith(finalStart)) {
            if (finalPattern.isEmpty()) {
                tempPattern.add(currentStart);
            } else {
                tempPattern.set(0, currentStart);
            }
        } else if (!finalStart.startsWith(currentStart)) {
            return false;
        }
        return true;
    }

    private static boolean validateEnd(List<String> finalPattern, List<String> tempPattern, List<String> parts) {
        String currentEnd = parts.isEmpty() ? "" : parts.get(parts.size() - 1);
        String finalEnd = finalPattern.isEmpty() ? "" : finalPattern.get(finalPattern.size() - 1);

        if (currentEnd.endsWith(finalEnd)) {
            if (tempPattern.size() <= 1) {
                tempPattern.add(currentEnd);
            } else {
                tempPattern.set(tempPattern.size() - 1, currentEnd);
            }
        } else if (!finalEnd.endsWith(currentEnd)) {
            return false;
        }
        return true;
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
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
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