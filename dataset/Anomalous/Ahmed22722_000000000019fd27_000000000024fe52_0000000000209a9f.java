import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    private static final FastReader in = new FastReader();
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = in.nextInt();
        StringBuilder s = new StringBuilder();
        char[] current;
        int val;
        int currentDepth = 0, depthDifference;

        for (int caseNumber = 1; caseNumber <= t; caseNumber++) {
            current = in.next().toCharArray();
            for (int i = 0; i < current.length; i++) {
                val = current[i] - '0';
                if (currentDepth > val) {
                    depthDifference = currentDepth - val;
                    s.append(")".repeat(depthDifference));
                    currentDepth -= depthDifference;
                } else if (currentDepth < val) {
                    depthDifference = val - currentDepth;
                    s.append("(".repeat(depthDifference));
                    currentDepth += depthDifference;
                }
                s.append(current[i]);
                if (i == current.length - 1) {
                    s.append(")".repeat(currentDepth));
                }
            }
            out.printf("Case #%d: %s\n", caseNumber, s);
            s.setLength(0);
            currentDepth = 0;
        }
        out.flush();
    }

    private static final class FastReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}