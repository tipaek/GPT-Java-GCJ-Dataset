import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        PascalWalk solver = new PascalWalk();
        int testCount = in.nextInt();
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class PascalWalk {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            out.println("Case #" + testNumber + ":");
            out.println("1 1");
            if (n == 2) {
                out.println("2 1");
                return;
            }
            int depth = 1;
            long taken = 1;
            long cur = 2;
            while (n - taken >= cur) {
                depth++;
                out.println(depth + " " + 2);
                taken += cur;
                cur++;
            }
            depth--;
            while (n != taken) {
                depth++;
                out.println(depth + " " + 1);
                taken += 1;
            }
        }
    }

    static class InputReader {

        private BufferedReader reader;
        private StringTokenizer tokenizer;

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
    }
}