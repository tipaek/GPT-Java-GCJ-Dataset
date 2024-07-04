import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Autocompletion solver = new Autocompletion();
        solver.solve(1, in, out);
        out.close();
    }

    static class Autocompletion {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            for (int z = 0; z < t; z++) {
                int x = in.nextInt();
                int y = in.nextInt();
                String s = in.next();
                boolean works = false;
                int min = 0;
                for (int i = 0; i <= s.length(); i++) {
                    if (i >= Math.abs(x) + Math.abs(y)) {
                        works = true;
                        min = i;
                        break;
                    }
                    if (i != s.length()) {
                        x += fx(s.charAt(i));
                        y += fy(s.charAt(i));
                    }
                }
                if (works) {
                    out.println("Case #" + (z + 1) + ": " + min);
                } else {
                    out.println("Case #" + (z + 1) + ": IMPOSSIBLE");
                }
            }
        }

        private int fy(char direction) {
            switch (direction) {
                case 'N': return 1;
                case 'S': return -1;
                default: return 0;
            }
        }

        private int fx(char direction) {
            switch (direction) {
                case 'E': return 1;
                case 'W': return -1;
                default: return 0;
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

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = this.nextInt();
            }
            return array;
        }
    }
}