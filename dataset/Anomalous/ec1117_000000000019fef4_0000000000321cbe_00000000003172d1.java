import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Autocompletion solver = new Autocompletion();
        solver.solve(in, out);
        out.close();
    }

    static class Autocompletion {
        public void solve(InputReader in, PrintWriter out) {
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
                    for (int i = 0; i < n; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if (arr[i].equals(arr[j])) {
                                works = true;
                                break;
                            }
                        }
                        if (works) break;
                    }
                    out.printf("Case #%d: %d%n", z + 1, works ? 0 : 1);
                } else if (d == 3) {
                    int prev = 0;
                    int point = 0;
                    int max = 1;
                    boolean zworks = false;
                    while (point < n) {
                        if (arr[point].equals(arr[prev])) {
                            point++;
                        } else {
                            if (point - prev == 2) {
                                zworks = true;
                            }
                            max = Math.max(max, point - prev);
                            prev = point;
                        }
                    }
                    max = Math.max(point - prev, max);
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