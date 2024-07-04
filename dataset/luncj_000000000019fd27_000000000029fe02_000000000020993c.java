import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();
        for (int t = 0; t < T; t ++) {
            final int N = in.nextInt();
            final int[][] square = new int[N][N];
            for (int i = 0; i < N; i ++) {
                for (int j = 0; j < N; j ++) {
                    square[i][j] = in.nextInt();
                }
            }
            solve(t, N, square);
        }
    }

    private static void solve(final int T,
                       final int N,
                       final int[][] square) {
        int k = 0;
        int r = 0;
        int c = 0;
        for (int i = 0; i < N; i ++) {
            k += square[i][i];
        }
        for (int i = 0; i < N; i ++) {
            final Set<Integer> s = new HashSet<>();
            for (int j = 0; j < N; j ++) {
                if (s.contains(square[i][j])) {
                    r ++;
                    break;
                }
                s.add(square[i][j]);
            }
        }
        for (int j = 0; j < N; j ++) {
            final Set<Integer> s = new HashSet<>();
            for (int i = 0; i < N; i ++) {
                if (s.contains(square[i][j])) {
                    c ++;
                    break;
                }
                s.add(square[i][j]);
            }
        }
        System.out.printf("Case #%d: %d %d %d\n", T+1, k, r, c);
    }
}