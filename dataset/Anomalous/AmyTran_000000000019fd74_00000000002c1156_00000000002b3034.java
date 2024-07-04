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

    public static String mergePatterns(List<String> patterns) {
        List<String> mergedPattern = new ArrayList<>();

        for (String pattern : patterns) {
            List<String> segments = new ArrayList<>();
            int start = 0;

            for (int j = 0; j < pattern.length(); j++) {
                if (pattern.charAt(j) == '*') {
                    if (j > start) {
                        segments.add(pattern.substring(start, j));
                    }
                    segments.add("");
                    start = j + 1;
                }
                if (j == pattern.length() - 1 && j >= start) {
                    segments.add(pattern.substring(start, j + 1));
                }
            }

            List<String> tempMergedPattern = new ArrayList<>(mergedPattern);

            if (!validateStartSegment(mergedPattern, tempMergedPattern, segments) ||
                !validateEndSegment(mergedPattern, tempMergedPattern, segments)) {
                return "*";
            }

            mergedPattern = new ArrayList<>(tempMergedPattern);
        }

        StringBuilder result = new StringBuilder();
        for (String segment : mergedPattern) {
            result.append(segment);
        }
        return result.toString();
    }

    private static boolean validateStartSegment(List<String> mergedPattern, List<String> tempMergedPattern, List<String> segments) {
        String currentStart = segments.isEmpty() ? "" : segments.get(0);
        String finalStart = mergedPattern.isEmpty() ? "" : mergedPattern.get(0);

        if (currentStart.startsWith(finalStart)) {
            if (mergedPattern.isEmpty()) {
                tempMergedPattern.add(currentStart);
            } else {
                tempMergedPattern.set(0, currentStart);
            }
        } else if (!finalStart.startsWith(currentStart)) {
            return false;
        }
        return true;
    }

    private static boolean validateEndSegment(List<String> mergedPattern, List<String> tempMergedPattern, List<String> segments) {
        String currentEnd = segments.isEmpty() ? "" : segments.get(segments.size() - 1);
        String finalEnd = mergedPattern.isEmpty() ? "" : mergedPattern.get(mergedPattern.size() - 1);

        if (currentEnd.endsWith(finalEnd)) {
            tempMergedPattern.set(tempMergedPattern.size() - 1, currentEnd);
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