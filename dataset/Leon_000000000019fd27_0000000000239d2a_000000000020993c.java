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
            int[][] M = readMatrix(in, N);


            String result = solve(N, M);
            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }

    static int[][] readMatrix(BufferedReader in, int N) throws IOException {
        int[][] result = new int[N][N];
        for (int x = 0; x < N; ++x) {
            String[] sin = in.readLine().split(" ");
            for (int y = 0; y < N; ++y) {
                result[x][y] = Integer.parseInt(sin[y]);
            }
        }
        return result;
    }

    static final int MIN = 0;
    static final int MAX = 1;

    static String solve(int N, int[][] M) {

        long k = 0;
        long r = 0;
        long c = 0;

        boolean R[][] = new boolean[N][N + 1];
        boolean C[][] = new boolean[N][N + 1];
        for (int x = 0; x < N; ++x) {
            for (int y = 0; y < N; ++y) {
                int v = M[x][y];
                if (x == y) {
                    k += v;
                }

                if (!R[x][0]) {
                    if (!R[x][v]) {
                        R[x][v] = true;
                    }  else {
                        r ++;
                        R[x][0] = true;
                    }
                }

                if (!C[y][0]) {
                    if (!C[y][v]) {
                        C[y][v] = true;
                    }  else {
                        c ++;
                        C[y][0] = true;
                    }
                }
//                System.out.printf("x: %d, y: %d, v: %d, R[x][v-1]: %d, r: %d \n", x, y, v, R[x][v-1], r);
            }
        }

        return k + " " + r + " " + c;
    }

}
