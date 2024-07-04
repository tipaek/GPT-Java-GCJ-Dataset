import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader in = new BufferedReader(new FileReader("data/input.txt"));

        int T = Integer.parseInt(in.readLine());

        for (int t = 0; t < T; ++t) {
            int N = Integer.parseInt(in.readLine());
            long[][] M = readMatrix(in, N);


            String result = solve(N, M);
            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }

    static long[][] readMatrix(BufferedReader in, int N) throws IOException {
        long[][] result = new long[N][N];
        for (int x = 0; x < N; ++x) {
            String[] sin = in.readLine().split(" ");
            for (int y = 0; y < N; ++y) {
                result[x][y] = Long.parseLong(sin[y]);
            }
        }
        return result;
    }

    static final int MIN = 0;
    static final int MAX = 1;

    static String solve(int N, long[][] M) {

        long maxValue = (1 + N) * N / 2;
        long k = 0;
        long r = 0;
        long c = 0;

        long R[][] = new long[N][2];
        long C[][] = new long[N][2];
        for (int x = 0; x < N; ++x) {
            for (int y = 0; y < N; ++y) {
                long v = M[x][y];
                if (x == y) {
                    k += v;
                }

                if (R[x][MIN] >= 0) {
                    boolean added = false;
                    if (v == R[x][MIN]) {
                        r ++;
                        added = true;
                        R[x][MIN] = -1;
                    } else if (v < R[x][MIN]  || R[x][MIN] == 0) {
                        R[x][MIN] = v;
                    }

                    if (v == R[x][MAX]) {
                        if (!added) {
                            r ++;
                        }

                        R[x][MIN] = -1;
                    } else if (v > R[x][MAX]) {
                        R[x][MAX] = v;
                    }
                }

                if (C[y][MIN] >= 0) {
                    boolean added = false;
                    if (v == C[y][MIN]) {
                        c ++;
                        added = true;
                        C[y][MIN] = -1;
                    } else if (v < C[y][MIN] || C[y][MIN] == 0) {
                        C[y][MIN] = v;
                    }

                    if (v == C[y][MAX]) {
                        if (!added) {
                            c ++;
                        }
                        C[y][MIN] = -1;
                    } else if (v > C[y][MAX]) {
                        C[y][MAX] = v;
                    }
                }
                //System.out.println(x + " " + y + " " + C[y][MIN] + " " + C[y][MAX]);
            }
        }

        return k + " " + r + " " + c;
    }

}
