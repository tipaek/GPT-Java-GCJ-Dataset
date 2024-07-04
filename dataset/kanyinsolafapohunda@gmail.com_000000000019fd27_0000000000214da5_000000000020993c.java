import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {

            InputReader in = new InputReader(System.in);
            PrintWriter out = new PrintWriter(System.out);
            Vestigium solver = new Vestigium();
            int testCount = Integer.parseInt(in.next());
            for (int i = 1; i <= testCount; i++)
                solver.solve(i, in, out);
            out.close();
    }

    static class Vestigium {

        void solve(int testNumber, InputReader in, PrintWriter out) {

            int N = in.nextInt();
            int[][] matrix = new int[N][N];
            int rows = 0, cols = 0;
            int trace = 0;

            for (int i = 0; i < N; i++) {

                matrix[i] = new int[N];

                for (int j = 0; j < N; j++) {
                    matrix[i][j] = in.nextInt();

                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
                System.out.println(Arrays.toString(matrix[i]));
            }


            for (int i = 0; i < N; i++) {
                Set<Integer> set = new HashSet<>();

                for (int j = 0; j < N; j++) {
                    if (set.contains(matrix[i][j])) {
                        rows++;
                        break;
                    }
                    set.add(matrix[i][j]);
                }
            }

            for (int i = 0; i < N; i++) {
                Set<Integer> set = new HashSet<>();

                for (int j = 0; j < N; j++) {
                    if (set.contains(matrix[j][i])) {
                        cols++;
                        break;
                    }
                    set.add(matrix[j][i]);
                }
            }

            out.printf("Case #%d: %d %d %d", testNumber, trace, rows, cols);
            out.println();
        }
    }

    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        InputReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        String next() {
            return nextToken();
        }

        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                String line;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (line == null) {
                    return null;
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }
    }
}
