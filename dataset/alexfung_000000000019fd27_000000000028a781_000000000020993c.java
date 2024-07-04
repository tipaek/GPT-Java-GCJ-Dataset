import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        int T = S.nextInt(), test = 1, N;
        while (test <= T) {
            N = S.nextInt();
            int[][] M = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = S.nextInt();
                }
            }
            HashSet<Integer> found;
            int cols = 0, rows = 0;
            for (int i = 0; i < N; i++) {
                found = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    if (found.contains(M[i][j])) {
                        rows++;
                        break;
                    } else {
                        found.add(M[i][j]);
                    }
                }
            }
            for (int j = 0; j < N; j++) {
                found = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    if (found.contains(M[i][j])) {
                        cols++;
                        break;
                    } else {
                        found.add(M[i][j]);
                    }
                }
            }
            int trace = 0;
            for (int i = 0; i < N; i++) {
                trace += M[i][i];
            }
            System.out.println(String.format(
                    "Case #%d: %d %d %d", test, trace, rows, cols));
            test++;
        }
    }

}
