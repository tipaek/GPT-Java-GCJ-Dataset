import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Vestigium solver = new Vestigium();
        solver.solve(1, in, out);
        out.close();
    }

    static class Vestigium {
        int sentinel = 1;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int T = in.nextInt();
            int[] seen = new int[101];
            int CT = T;
            while (CT-- > 0) {
                int N = in.nextInt();
                int[][] matr = new int[N][N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        matr[i][j] = in.nextInt();
                    }
                }
                int trace = 0;
                int rowRep = 0;
                int colRep = 0;
                for (int i = 0; i < N; i++) {
                    trace += matr[i][i];
                }
                for (int row = 0; row < N; row++) {
                    for (int col = 0; col < N; col++) {
                        if (seen[matr[row][col]] == sentinel) {
                            rowRep++;
                            break;
                        }
                        seen[matr[row][col]] = sentinel;
                    }
                    sentinel++;
                }
                for (int col = 0; col < N; col++) {
                    for (int row = 0; row < N; row++) {
                        if (seen[matr[row][col]] == sentinel) {
                            colRep++;
                            break;
                        }
                        seen[matr[row][col]] = sentinel;
                    }
                    sentinel++;
                }
                StringBuilder str = new StringBuilder();
                str.append("Case #");
                str.append(T - CT);
                str.append(": ");
                str.append(trace + " " + rowRep + " " + colRep);
                out.println(str.toString());
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

