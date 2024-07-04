import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int numberOfTestCases = sc.nextInt();

        for (int testCase = 0; testCase < numberOfTestCases; testCase++) {
            int numberOfPatterns = sc.nextInt();
            List<String> patterns = new ArrayList<>();

            for (int i = 0; i < numberOfPatterns; i++) {
                patterns.add(sc.nextToken());
            }

            System.out.println("Case #" + (testCase + 1) + ": " + mergePatterns(patterns));
        }
    }

    public static String mergePatterns(List<String> patterns) {
        List<String> mergedPattern = new ArrayList<>();

        for (String pattern : patterns) {
            List<String> parts = new ArrayList<>();
            int start = 0;

            for (int i = 0; i < pattern.length(); i++) {
                if (pattern.charAt(i) == '*') {
                    if (i > start) {
                        parts.add(pattern.substring(start, i));
                    }
                    parts.add("");
                    start = i + 1;
                }
                if (i == pattern.length() - 1 && i >= start) {
                    parts.add(pattern.substring(start));
                }
            }

            List<String> tempMergedPattern = new ArrayList<>(mergedPattern);

            if (!validateStart(mergedPattern, tempMergedPattern, parts) || !validateEnd(mergedPattern, tempMergedPattern, parts)) {
                return "*";
            }

            mergedPattern = new ArrayList<>(tempMergedPattern);
        }

        StringBuilder result = new StringBuilder();
        for (String part : mergedPattern) {
            result.append(part);
        }

        return result.toString();
    }

    private static boolean validateStart(List<String> mergedPattern, List<String> tempMergedPattern, List<String> parts) {
        String currentStart = parts.isEmpty() ? "" : parts.get(0);
        String mergedStart = mergedPattern.isEmpty() ? "" : mergedPattern.get(0);

        if (currentStart.startsWith(mergedStart)) {
            if (mergedPattern.isEmpty()) {
                tempMergedPattern.add(currentStart);
            } else {
                tempMergedPattern.set(0, currentStart);
            }
        } else if (!mergedStart.startsWith(currentStart)) {
            return false;
        }

        return true;
    }

    private static boolean validateEnd(List<String> mergedPattern, List<String> tempMergedPattern, List<String> parts) {
        String currentEnd = parts.isEmpty() ? "" : parts.get(parts.size() - 1);
        String mergedEnd = mergedPattern.isEmpty() ? "" : mergedPattern.get(mergedPattern.size() - 1);

        if (currentEnd.endsWith(mergedEnd)) {
            tempMergedPattern.set(tempMergedPattern.size() - 1, currentEnd);
        } else if (!mergedEnd.endsWith(currentEnd)) {
            return false;
        }

        return true;
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String fileName) {
            try {
                br = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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