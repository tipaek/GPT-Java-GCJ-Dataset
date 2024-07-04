import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = reader.nextInt();
            String[] patterns = new String[n];
            int maxLength = 0;
            int maxIndex = 0;

            for (int i = 0; i < n; i++) {
                patterns[i] = reader.next().replace("*", "");
                if (patterns[i].length() > maxLength) {
                    maxLength = patterns[i].length();
                    maxIndex = i;
                }
            }

            String longestPattern = patterns[maxIndex];
            boolean isPossible = true;

            for (int i = 0; i < n && isPossible; i++) {
                if (i == maxIndex) continue;
                if (!longestPattern.contains(patterns[i])) {
                    isPossible = false;
                }
            }

            System.out.print("Case #" + caseNumber + ": ");
            if (isPossible) {
                System.out.println(longestPattern);
            } else {
                System.out.println("*");
            }
        }
    }

    static class FastReader {
        BufferedReader bufferedReader;
        StringTokenizer tokenizer;

        public FastReader() throws IOException {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
                try {
                    tokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() throws IOException {
            return bufferedReader.readLine();
        }

        boolean ready() throws IOException {
            return bufferedReader.ready() || (tokenizer != null && tokenizer.hasMoreElements());
        }
    }
}