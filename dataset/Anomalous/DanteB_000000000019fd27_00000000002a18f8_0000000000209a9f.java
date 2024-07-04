import java.util.*;
import java.io.*;

public class Solution {

    static InputReader in = new InputReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = in.nextInt();
        for (int tc = 1; tc <= t; ++tc) {
            out.printf("Case #%d: ", tc);
            String s = in.next();
            int par = 0;
            for (int i = 0; i < s.length(); i++) {
                int num = s.charAt(i) - '0';
                while (par < num) {
                    out.print('(');
                    par++;
                }
                while (par > num) {
                    out.print(')');
                    par--;
                }
                out.print(num);
            }
            while (par > 0) {
                out.print(')');
                par--;
            }
            out.println();
        }
        finish();
    }

    public static void finish() {
        out.close();
        in.close();
        System.exit(0);
    }

    static class InputReader implements Iterator<String>, Closeable {
        private BufferedReader reader;
        private StringTokenizer tokenizer;
        private String nextToken;

        public InputReader(InputStream inputStream) {
            reader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public boolean hasNext() {
            return peekToken() != null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public String next() {
            String result = peekToken();
            nextToken = null;
            return result;
        }

        public String nextLine() {
            peekToken();
            String result = tokenizer != null ? tokenizer.nextToken("") : null;
            nextToken = null;
            tokenizer = null;
            return result;
        }

        public void close() {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String peekToken() {
            if (nextToken == null) {
                try {
                    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                        String line = reader.readLine();
                        if (line == null) {
                            return null;
                        }
                        tokenizer = new StringTokenizer(line);
                    }
                    nextToken = tokenizer.nextToken();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return nextToken;
        }
    }
}