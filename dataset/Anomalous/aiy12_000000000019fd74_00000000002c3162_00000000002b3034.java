import java.io.*;
import java.util.*;

public class Solution {
    private FastScanner scanner;
    private StringBuilder result;
    private String[] patterns;

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    private void run() throws Exception {
        scanner = new FastScanner();
        int testCases = scanner.nextInt();

        for (int test = 1; test <= testCases; test++) {
            System.out.println("Case #" + test + ": " + solve());
        }
    }

    private String solve() throws Exception {
        int numberOfPatterns = scanner.nextInt();
        patterns = new String[numberOfPatterns];
        int[] starPositions = new int[numberOfPatterns];
        int maxLength = -1;
        result = new StringBuilder();

        for (int i = 0; i < numberOfPatterns; i++) {
            patterns[i] = scanner.next();
            maxLength = Math.max(maxLength, patterns[i].length());
        }

        for (int i = 0; i < numberOfPatterns; i++) {
            int starIndex = patterns[i].indexOf("*");
            starPositions[i] = starIndex;
            while (patterns[i].length() < maxLength) {
                patterns[i] = patterns[i].substring(0, starIndex) + "*" + patterns[i].substring(starIndex);
            }
        }

        boolean isMatch = false;

        while (!isMatch) {
            isMatch = true;

            if (patterns[0].length() > 10000) {
                return "*";
            }

            for (int i = 0; i < numberOfPatterns; i++) {
                for (int j = i + 1; j < numberOfPatterns; j++) {
                    if (!arePatternsMatching(patterns[i], patterns[j])) {
                        isMatch = false;
                        break;
                    }
                }
                if (!isMatch) {
                    break;
                }
            }

            if (!isMatch) {
                for (int i = 0; i < numberOfPatterns; i++) {
                    int starIndex = starPositions[i];
                    patterns[i] = patterns[i].substring(0, starIndex) + "*" + patterns[i].substring(starIndex);
                }
                continue;
            }

            for (int i = 0; i < patterns[0].length(); i++) {
                char character = '*';
                for (int j = 0; j < numberOfPatterns; j++) {
                    if (patterns[j].charAt(i) != '*') {
                        character = patterns[j].charAt(i);
                    }
                }
                result.append(character);
            }

            String answer = result.toString().replace("*", "A");

            if (answer.length() > 10000) {
                return "*";
            }

            return answer;
        }

        return "*";
    }

    private boolean arePatternsMatching(String pattern1, String pattern2) {
        int firstStarIndex1 = pattern1.indexOf('*');
        int firstStarIndex2 = pattern2.indexOf('*');
        int lastStarIndex1 = pattern1.lastIndexOf('*');
        int lastStarIndex2 = pattern2.lastIndexOf('*');

        for (int i = 0; i < Math.min(firstStarIndex1, firstStarIndex2); i++) {
            if (pattern1.charAt(i) != pattern2.charAt(i)) {
                return false;
            }
        }

        for (int i = Math.max(lastStarIndex1, lastStarIndex2) + 1; i < pattern1.length(); i++) {
            if (pattern1.charAt(i) != pattern2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    private static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}