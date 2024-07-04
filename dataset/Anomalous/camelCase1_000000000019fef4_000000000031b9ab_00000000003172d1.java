import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokenizer;

    public static void main(String[] args) throws Exception {
        int t = nextInt();
        int caseNumber = 1;
        PrintWriter out = new PrintWriter(System.out);

        while (t-- > 0) {
            int u = nextInt();
            int[] frequency = new int[26];
            boolean[] isUsed = new boolean[26];

            for (int i = 0; i < 10000; i++) {
                nextInt(); // Skip the integer
                char[] characters = next().toCharArray();
                if (characters.length == u) {
                    frequency[characters[0] - 'A']++;
                }
                for (char c : characters) {
                    isUsed[c - 'A'] = true;
                }
            }

            int maxIndex = 0;
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < 9; j++) {
                for (int i = 1; i < 26; i++) {
                    if (frequency[i] > frequency[maxIndex]) {
                        maxIndex = i;
                    }
                }
                isUsed[maxIndex] = false;
                frequency[maxIndex] = 0;
                result.append((char) (maxIndex + 'A'));
            }

            for (int i = 0; i < 26; i++) {
                if (isUsed[i]) {
                    result.insert(0, (char) (i + 'A'));
                    break;
                }
            }

            out.println("Case #" + (caseNumber++) + ": " + result.toString());
        }

        out.close();
    }

    private static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                throw new IOException();
            }
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}