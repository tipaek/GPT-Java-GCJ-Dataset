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
        for (int testCase = 1; testCase <= testCases; testCase++) {
            System.out.println("Case #" + testCase + ": " + solve());
        }
    }

    private String solve() throws Exception {
        int patternCount = scanner.nextInt();
        patterns = new String[patternCount];
        int maxLength = -1;
        result = new StringBuilder();

        for (int i = 0; i < patternCount; i++) {
            patterns[i] = scanner.next();
            maxLength = Math.max(maxLength, patterns[i].length());
        }

        for (int i = 0; i < patternCount; i++) {
            int starPosition = patterns[i].indexOf('*');
            while (patterns[i].length() < maxLength) {
                patterns[i] = patterns[i].substring(0, starPosition) + "*" + patterns[i].substring(starPosition);
            }
        }

        boolean isValid = true;
        outerLoop:
        for (int i = 0; i < patternCount; i++) {
            for (int j = i + 1; j < patternCount; j++) {
                if (!comparePatterns(patterns[i], patterns[j])) {
                    isValid = false;
                    break outerLoop;
                }
            }
        }

        if (!isValid) {
            return "*";
        }

        for (int i = 0; i < patterns[0].length(); i++) {
            char commonChar = '*';
            for (int j = 0; j < patternCount; j++) {
                char currentChar = patterns[j].charAt(i);
                if (currentChar != '*') {
                    if (commonChar != '*' && currentChar != commonChar) {
                        return "*";
                    }
                    commonChar = currentChar;
                }
            }
            result.append(commonChar);
        }

        return result.toString().replace("*", "A");
    }

    private boolean comparePatterns(String a, String b) {
        int firstStarA = a.indexOf('*');
        int firstStarB = b.indexOf('*');
        int lastStarA = a.lastIndexOf('*');
        int lastStarB = b.lastIndexOf('*');

        for (int i = 0; i < Math.min(firstStarA, firstStarB); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }

        for (int i = Math.max(lastStarA, lastStarB) + 1; i < Math.min(a.length(), b.length()); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    static class FastScanner {
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
    }
}