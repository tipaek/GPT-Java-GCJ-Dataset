import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.solve(in, out);
        out.close();
    }

    static class Task {
        public void solve(InputReader in, PrintWriter out) {
            int t = in.nextInt();
            for (int k = 1; k <= t; ++k) {
                String s = in.next();
                StringBuilder ans = new StringBuilder();
                int parCnt = 0;
                for (int i = 0; i < s.length(); ++i) {
                    int val = s.charAt(i) - '0';
                    while (parCnt > val) {
                        ans.append(')');
                        --parCnt;
                    }
                    while (parCnt < val) {
                        ans.append('(');
                        ++parCnt;
                    }
                    ans.append(s.charAt(i));
                }
                for (; parCnt > 0; --parCnt) { ans.append(')'); }
                out.printf("Case #%d: %s\n", k, ans.toString());
            }
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
        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}