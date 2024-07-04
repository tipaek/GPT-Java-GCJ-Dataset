import java.io.*;
import java.util.*;

/**
 * Created by cpinan on 6/16/17.
 */
public class Solution {

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

    }

    private void resolve() {
        InputStream inputStream = System.in;
        InputReader in = new InputReader(inputStream);

        PrintStream out = System.out;

        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();

            int K = 0;
            int R = 0;
            int C = 0;
            int[][] matrix = new int[N][N];

            for (int y = 0; y < N; y++) {
                boolean rowAdded = false;
                Set<Integer> row = new HashSet<>();
                for (int x = 0; x < N; x++) {
                    matrix[y][x] = in.nextInt();
                    if (x == y) {
                        K += matrix[y][x];
                    }
                    if (!rowAdded && row.contains(matrix[y][x])) {
                        R++;
                        rowAdded = true;
                    }
                    row.add(matrix[y][x]);
                }
            }

            for (int x = 0; x < N; x++) {
                Set<Integer> col = new HashSet<>();
                for (int y = 0; y < N; y++) {
                    if (col.contains(matrix[y][x])) {
                        C++;
                        break;
                    }
                    col.add(matrix[y][x]);
                }
            }
            out.print("Case #" + t + ": ");
            out.print(K + " ");
            out.print(R + " ");
            out.println(C);
        }
        out.close();
    }

    public static void main(String[] args) {
        Solution p = new Solution();
        p.resolve();
    }

}