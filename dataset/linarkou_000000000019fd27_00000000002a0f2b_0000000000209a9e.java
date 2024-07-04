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

    public static void solveVeryEasy(InputReader in, int t, int b) {
        for (int index = 1; index <= t; ++index) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < b; ++i) {
                System.out.print(i + 1);
                sb.append(in.nextInt());
            }
            System.out.println(sb.toString());
            if (in.next().equals("N")) {
                return;
            }
        }
    }

    public static void solveEasy(InputReader in, int t, int b) {
        return;
    }

    public static void solve(InputReader in, PrintWriter out) {
        int t = in.nextInt();
        int b = in.nextInt();
        if (b <= 10) {
            solveVeryEasy(in, t, b);
            return;
        }
        if (b <= 20) {
            solveEasy(in, t, b);
            return;
        }
        return;
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