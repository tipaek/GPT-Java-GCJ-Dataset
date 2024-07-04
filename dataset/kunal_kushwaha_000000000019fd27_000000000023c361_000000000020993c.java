import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        int t = in.nextInt();
        solver.solve(t, in, out);
        out.close();
    }

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {
            for (int i = 1; i <= testNumber; i++) {
                int n = in.nextInt();
                int[][] arr = new int[n][n];
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        arr[j][k] = in.nextInt();
                    }
                }
                int r = 0;
                int c = 0;
                int k = 0;
                while(r < n && c < n) {
                    k += arr[r][c];
                    r++;
                    c++;
                }
                r = 0;
                c = 0;
                for (int j = 0; j < n; j++) {
                    // checking each row
                    Set<Integer> set = new HashSet<>();
                    for (int l = 0; l < n; l++) {
                       if (set.contains(arr[j][l])) {
                           r++;
                           break;
                       }
                       set.add(arr[j][l]);
                    }
                }
                for (int j = 0; j < n; j++) {
                    // checking each row
                    Set<Integer> set = new HashSet<>();
                    for (int l = 0; l < n; l++) {
                        if (set.contains(arr[l][j])) {
                            c++;
                            break;
                        }
                        set.add(arr[l][j]);
                    }
                }
                out.println("Case #" + i + " " + k + " " + r + " " + c);
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

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public char nextChar() {
            return next().charAt(0);
        }

        public String nextLine() throws IOException {
            return reader.readLine().trim();
        }
    }
}
