import java.io.*;
import java.util.*;

public class Solution {
    private FastScanner file;
    private StringBuilder result;
    private String[] patterns;

    public boolean comparePatterns(String a, String b) {
        int firstAsteriskA = a.indexOf('*');
        int firstAsteriskB = b.indexOf('*');
        int lastAsteriskA = a.lastIndexOf('*');
        int lastAsteriskB = b.lastIndexOf('*');

        for (int i = 0; i < Math.min(firstAsteriskA, firstAsteriskB); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        for (int i = Math.max(lastAsteriskA, lastAsteriskB) + 1; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }

        return true;
    }

    public String solve() throws Exception {
        int numPatterns = file.nextInt();
        patterns = new String[numPatterns];
        int[] asteriskPositions = new int[numPatterns];
        int maxLength = -1;
        result = new StringBuilder();

        for (int i = 0; i < numPatterns; i++) {
            patterns[i] = file.next();
            maxLength = Math.max(maxLength, patterns[i].length());
        }

        boolean isValid = false;

        for (int i = 0; i < numPatterns; i++) {
            int firstAsterisk = patterns[i].indexOf("*");
            asteriskPositions[i] = firstAsterisk;

            while (patterns[i].length() < maxLength) {
                patterns[i] = patterns[i].substring(0, firstAsterisk) + "*" + patterns[i].substring(firstAsterisk);
            }
        }

        while (!isValid) {
            isValid = true;

            if (patterns[0].length() > 1000) return "*";

            for (int i = 0; i < numPatterns; i++) {
                for (int j = i + 1; j < numPatterns; j++) {
                    if (!comparePatterns(patterns[i], patterns[j])) {
                        isValid = false;
                    }
                    if (!isValid) break;
                }
                if (!isValid) break;
            }

            if (!isValid) {
                for (int i = 0; i < numPatterns; i++) {
                    int firstAsterisk = asteriskPositions[i];
                    patterns[i] = patterns[i].substring(0, firstAsterisk) + "*" + patterns[i].substring(firstAsterisk);
                }
                continue;
            }

            for (int i = 0; i < patterns[0].length(); i++) {
                char character = '*';
                for (int j = 0; j < numPatterns; j++) {
                    if (patterns[j].charAt(i) != '*') {
                        character = patterns[j].charAt(i);
                    }
                }
                result.append(character);
            }

            String answer = result.toString().replace("*", "A");

            if (answer.length() > 1e4) {
                return "*";
            }

            return answer;
        }

        return "*";
    }

    public void run() throws Exception {
        file = new FastScanner();
        int testCases = file.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            System.out.println("Case #" + testCase + ": " + solve());
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
            tokenizer = null;
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

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }
}