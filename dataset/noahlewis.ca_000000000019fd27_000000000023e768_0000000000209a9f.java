import java.io.*;
import java.util.*;

public class Solution {
    public void solve() {
        int numberTests = reader.nextInt();

        for (int t = 1; t <= numberTests; t++) {
            String s = reader.nextToken();
            String r = shortestBrackets(s);
            writer.printf("Case #%d: %s\n", t, r);
        }
    }

    private String shortestBrackets(String s) {
        int n = s.length();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.charAt(i) - '0';
        }

        return find(a, 0, n - 1, 0);
    }

    private String find(int[] a, int l, int r, int outer) {
        if (l > r) return "";

        if (l == r) {
            int k = a[l] - outer;
            String open = "(".repeat(k);
            String close = ")".repeat(k);
            return String.format("%s%d%s", open, a[l], close);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = l; i <= r; i++) {
            int j = i;
            while (j <= r && a[j] > outer) j++;

            if (j == i) {
                sb.append(a[i]);
                continue;
            }

            String s = find(a, i, j - 1, outer + 1);
            sb.append(String.format("(%s)", s));

            i = j - 1;
        }

        return sb.toString();
    }

    private InputReader reader;
    private PrintWriter writer;

    public Solution(InputReader reader, PrintWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        PrintWriter writer = new PrintWriter(System.out);

        Solution solution = new Solution(reader, writer);
        solution.solve();

        writer.flush();
    }

    static class InputReader {
        private static final int BUFFER_SIZE = 1 << 20;

        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), BUFFER_SIZE);
            tokenizer = null;
        }

        public String nextToken() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() {
            return Long.parseLong(nextToken());
        }
    }
}