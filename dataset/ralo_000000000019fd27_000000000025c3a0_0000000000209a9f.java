import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(System.out)) {
            FastReader in = new FastReader(System.in);
            Task.solve(in, out);
        }
    }

    static class Task {
        public static void solve(FastReader in, PrintWriter out) {
            int t = in.nextInt();

            for (int x = 1; x <= t; x++) {
                String s = in.next();
                int prev = Integer.parseInt(s.charAt(0) + "");
                StringBuilder sb = new StringBuilder(join("(", prev));
                sb.append(prev);
                for (int i = 1; i < s.length(); i++) {
                    int d = Integer.parseInt(s.charAt(i) + "");
                    if (prev == d) {
                        sb.append(d);
                    } else {
                        int diff = Math.abs(d - prev);
                        if (d > prev) {
                            sb.append(join("(", diff));
                            sb.append(d);
                        } else {
                            sb.append(join(")", diff));
                            sb.append(d);
                        }
                    }
                    prev = d;

                }
                sb.append(join(")", prev));
                out.println("Case #" + x + ": " + sb.toString());
            }
        }

        private static String join(String str, int n) {
            return String.join("", Collections.nCopies(n, str));
        }
    }

    static class FastReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public FastReader(InputStream f) {
            reader = new BufferedReader(new InputStreamReader(f), 32768);
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
