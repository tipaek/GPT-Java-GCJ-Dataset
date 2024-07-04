import java.util.*;
import java.io.*;

public class Solution {

    static InputReader in = new InputReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = in.nextInt();
        for (int tc = 1; tc <= t; ++tc) {
            int n = in.nextInt();
            StringBuilder pre = new StringBuilder();
            StringBuilder suf = new StringBuilder();
            StringBuilder mid = new StringBuilder();
            boolean valid = true;

            for (int i = 0; i < n; i++) {
                String word = in.next();
                int wl = word.length();

                int wpl = word.indexOf('*');
                String wordPre = word.substring(0, wpl);
                if (!pre.toString().startsWith(wordPre)) {
                    if (pre.length() < wordPre.length()) {
                        pre = new StringBuilder(wordPre);
                    } else if (!pre.substring(0, wordPre.length()).equals(wordPre)) {
                        valid = false;
                    }
                }

                int wsl = word.lastIndexOf('*') + 1;
                String wordSuf = new StringBuilder(word.substring(wsl)).reverse().toString();
                if (!suf.toString().startsWith(wordSuf)) {
                    if (suf.length() < wordSuf.length()) {
                        suf = new StringBuilder(wordSuf);
                    } else if (!suf.substring(0, wordSuf.length()).equals(wordSuf)) {
                        valid = false;
                    }
                }

                mid.append(word.substring(wpl + 1, wsl - 1).replace("*", ""));
            }

            if (valid) {
                out.printf("Case #%d: %s%s%s\n", tc, pre, mid, suf.reverse());
            } else {
                out.printf("Case #%d: *\n", tc);
            }
        }
        finish();
    }

    public static void finish() {
        out.close();
        in.close();
        System.exit(0);
    }

    static class InputReader implements Iterator<String>, Closeable {
        private BufferedReader r;
        private StringTokenizer st;
        private String token;

        public InputReader(InputStream i) {
            r = new BufferedReader(new InputStreamReader(i));
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
            String ans = peekToken();
            token = null;
            return ans;
        }

        public String nextLine() {
            peekToken();
            String ans = line;
            token = null;
            st = null;
            return ans;
        }

        public void close() {
            try {
                r.close();
            } catch (IOException e) {
                // Ignore
            }
        }

        private String peekToken() {
            if (token == null) {
                try {
                    while (st == null || !st.hasMoreTokens()) {
                        line = r.readLine();
                        if (line == null) return null;
                        st = new StringTokenizer(line);
                    }
                    token = st.nextToken();
                } catch (IOException e) {
                    // Ignore
                }
            }
            return token;
        }
    }
}