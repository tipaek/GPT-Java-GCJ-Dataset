import java.io.*;
import java.util.*;

public class Solution {
    private FastScanner file;
    private StringBuilder result;
    private String[] patterns;

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    private void run() throws Exception {
        file = new FastScanner();
        int testCases = file.nextInt();
        for (int test = 1; test <= testCases; test++) {
            System.out.println("Case #" + test + ": " + solve());
        }
    }

    private String solve() throws Exception {
        int numPatterns = file.nextInt();
        patterns = new String[numPatterns];
        int maxLength = -1;
        result = new StringBuilder();

        for (int i = 0; i < numPatterns; i++) {
            patterns[i] = file.next();
            maxLength = Math.max(maxLength, patterns[i].length());
        }

        for (int i = 0; i < numPatterns; i++) {
            int starIndex = patterns[i].indexOf('*');
            while (patterns[i].length() < maxLength) {
                patterns[i] = patterns[i].substring(0, starIndex) + "*" + patterns[i].substring(starIndex);
            }
        }

        if (!arePatternsCompatible(numPatterns)) {
            return "*";
        }

        for (int i = 0; i < patterns[0].length(); i++) {
            char currentChar = '*';
            for (int j = 0; j < numPatterns; j++) {
                if (patterns[j].charAt(i) != '*') {
                    currentChar = patterns[j].charAt(i);
                }
            }
            result.append(currentChar);
        }

        String answer = result.toString().replace("*", "A");
        return answer.length() > 1e4 ? "*" : answer;
    }

    private boolean arePatternsCompatible(int numPatterns) {
        for (int i = 0; i < numPatterns; i++) {
            for (int j = i + 1; j < numPatterns; j++) {
                if (!comparePatterns(patterns[i], patterns[j])) {
                    return false;
                }
            }
        }
        return true;
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

        for (int i = Math.max(lastStarA, lastStarB) + 1; i < a.length(); i++) {
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
    }
}