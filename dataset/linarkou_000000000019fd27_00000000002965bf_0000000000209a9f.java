import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(in, out);
        out.close();
    }

    public static void solve(InputReader in, PrintWriter out) {
        int t = in.nextInt();
        for (int index = 1; index <= t; ++index) {
            String s = in.next();
            int cnt = 0;
            out.print("Case #");
            out.print(index);
            out.print(": ");
            for (int i = 0; i < s.length(); ++i) {
                int v = s.charAt(i) - '0';
                int d = Math.abs(v - cnt);
                char c = v - cnt > 0 ? '(' : ')';
                for (int j = 0; j < d; ++j) {
                    out.print(c);
                }
                cnt = v;
                out.print(v);
            }
            while(cnt-- > 0) {
                out.print(')');
            }
            out.println();
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
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

        public void skip() {
            tokenizer = null;
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}