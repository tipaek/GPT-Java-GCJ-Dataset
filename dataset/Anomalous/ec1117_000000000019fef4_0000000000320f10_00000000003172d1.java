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
                int n = in.nextInt();
                int d = in.nextInt();
                Long[] arr = new Long[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextLong();
                }
                Arrays.sort(arr);
                if (d == 2) {
                    boolean works = false;
                    for (int i = 0; i < n - 1; i++) {
                        if (arr[i].equals(arr[i + 1])) {
                            works = true;
                            break;
                        }
                    }
                    out.printf("Case #%d: %d%n", z + 1, works ? 0 : 1);
                } else if (d == 3) {
                    boolean zworks = false;
                    int max = 1;
                    for (int i = 0, j = 0; j < n; j++) {
                        if (!arr[i].equals(arr[j])) {
                            max = Math.max(max, j - i);
                            i = j;
                        }
                    }
                    for (int i = 0; i < n; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if (arr[i] * 2 == arr[j]) {
                                zworks = true;
                                break;
                            }
                        }
                        if (zworks) break;
                    }
                    if (max >= 3) {
                        out.printf("Case #%d: %d%n", z + 1, 0);
                    } else if (zworks) {
                        out.printf("Case #%d: %d%n", z + 1, 1);
                    } else {
                        out.printf("Case #%d: %d%n", z + 1, 2);
                    }
                }
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
    }
}