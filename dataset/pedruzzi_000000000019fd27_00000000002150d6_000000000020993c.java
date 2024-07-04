package CodeJam2020.Qualification.Vestigium;

import java.util.BitSet;
import java.util.Scanner;

public class Vestigium {

    static class Test {
        public static void main(String[] args) {
            solve(new Scanner(Vestigium.class.getResourceAsStream("input.txt")));
        }
    }

    public static void main(String[] args) {
        solve(new Scanner(System.in));
    }

    private static void solve(Scanner scanner) {
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int[][] M = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int val = scanner.nextInt();
                    if (val <= 0 || val > N) {
                        throw new AssertionError();
                    }
                    M[i][j] = val;
                }
            }

            // The trace of a square matrix is the sum of the values on the main diagonal
            int k = 0;
            for (int i = 0; i < N; i++) {
                k += M[i][i];
            }

            // r is the number of rows of the matrix that contain repeated elements
            int r = 0;
            for (int i = 0; i < N; i++) {
                BitSet bs = new BitSet();
                for (int j = 0; j < N; j++) {
                    if (bs.get(M[i][j])) {
                        r++;
                        break;
                    }
                    bs.set(M[i][j]);
                }
            }

            // c is the number of columns of the matrix that contain repeated elements.
            int c = 0;
            for (int j = 0; j < N; j++) {
                BitSet bs = new BitSet();
                for (int i = 0; i < N; i++) {
                    if (bs.get(M[i][j])) {
                        c++;
                        break;
                    }
                    bs.set(M[i][j]);
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", t + 1, k, r, c);
        }
    }
}
