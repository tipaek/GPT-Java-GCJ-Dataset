import java.io.*;
import java.util.*;

public class Solution {
    private FastScanner file;
    private StringBuilder res;
    private String[] patterns;

    private boolean comparePatterns(String a, String b) {
        System.out.println(a + " " + b);
        int idxA = a.indexOf('*');
        int idxB = b.indexOf('*');
        
        for (int i = 0; i < Math.min(idxA, idxB); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        for (int i = Math.max(idxA, idxB); i < Math.min(a.length(), b.length()); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        
        return true;
    }

    private String solve() throws Exception {
        int N = file.nextInt();
        patterns = new String[N];
        int[] starPositions = new int[N];
        int maxLength = -1;
        res = new StringBuilder();

        for (int i = 0; i < N; i++) {
            patterns[i] = file.next();
            maxLength = Math.max(maxLength, patterns[i].length());
        }

        boolean isValid = true;

        if (!isValid) return "*";

        for (int i = 0; i < N; i++) {
            int starIndex = patterns[i].indexOf('*');
            starPositions[i] = starIndex;

            while (patterns[i].length() < maxLength) {
                patterns[i] = patterns[i].substring(0, starIndex) + "*" + patterns[i].substring(starIndex);
            }
        }

        for (int i = 0; i < patterns[0].length(); i++) {
            char currentChar = '*';
            for (int j = 0; j < N; j++) {
                if (patterns[j].charAt(i) != '*') {
                    if (currentChar != '*' && patterns[j].charAt(i) != currentChar) {
                        isValid = false;
                    } else if (currentChar == '*') {
                        currentChar = patterns[j].charAt(i);
                    }
                }

                if (!isValid) break;
            }
            res.append(currentChar);
            if (!isValid) break;
        }

        if (!isValid) return "*";

        String answer = res.toString().replace("*", "A");
        return answer;
    }

    private void run() throws Exception {
        file = new FastScanner();

        int T = file.nextInt();

        for (int test = 1; test <= T; test++) {
            System.out.println("Case #" + test + ": " + solve());
        }
    }

    private static class FastScanner {
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