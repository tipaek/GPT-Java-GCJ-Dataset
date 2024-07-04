import java.util.*;
import java.io.*;

public class Solution {

    static InputReader in = new InputReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = in.nextInt();
        for (int tc = 1; tc <= t; ++tc) {
            int n = in.nextInt();
            char[] pre = new char[10000];
            char[] suf = new char[10000];
            char[] mid = new char[10000];
            int prel = 0, sufl = 0, midl = 0;

            outerLoop:
            for (int i = 0; i < n; i++) {
                char[] word = in.next().toCharArray();
                int wl = word.length;

                int wpl = 0;
                while (wpl < wl && word[wpl] != '*') {
                    wpl++;
                }

                for (int j = 0; j < Math.min(wpl, prel); j++) {
                    if (word[j] != pre[j]) {
                        out.printf("Case #%d: *\n", tc);
                        continue outerLoop;
                    }
                }

                if (wpl > prel) {
                    System.arraycopy(word, prel, pre, prel, wpl - prel);
                    prel = wpl;
                }

                int wsl = 0;
                while (wsl < wl && word[wl - wsl - 1] != '*') {
                    wsl++;
                }

                for (int j = 0; j < Math.min(wsl, sufl); j++) {
                    if (word[wl - j - 1] != suf[j]) {
                        out.printf("Case #%d: *\n", tc);
                        continue outerLoop;
                    }
                }

                if (wsl > sufl) {
                    for (int j = 0; j < wsl; j++) {
                        suf[j] = word[wl - j - 1];
                    }
                    sufl = wsl;
                }

                for (int j = wpl; j < wl - wsl; j++) {
                    if (word[j] != '*') {
                        mid[midl++] = word[j];
                    }
                }
            }

            out.printf("Case #%d: ", tc);
            for (int i = 0; i < prel; i++) {
                out.print(pre[i]);
            }
            for (int i = 0; i < midl; i++) {
                out.print(mid[i]);
            }
            for (int i = 0; i < sufl; i++) {
                out.print(suf[sufl - i - 1]);
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
        private String currentToken;

        public InputReader(InputStream inputStream) {
            reader = new BufferedReader(new InputStreamReader(inputStream));
        }

        @Override
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

        @Override
        public String next() {
            String result = peekToken();
            currentToken = null;
            return result;
        }

        public String nextLine() {
            peekToken();
            String result = tokenizer != null ? tokenizer.nextToken("") : "";
            currentToken = null;
            tokenizer = null;
            return result;
        }

        @Override
        public void close() {
            try {
                reader.close();
            } catch (IOException e) {
                // Handle exception
            }
        }

        private String peekToken() {
            if (currentToken == null) {
                try {
                    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                        String line = reader.readLine();
                        if (line == null) {
                            return null;
                        }
                        tokenizer = new StringTokenizer(line);
                    }
                    currentToken = tokenizer.nextToken();
                } catch (IOException e) {
                    // Handle exception
                }
            }
            return currentToken;
        }
    }
}