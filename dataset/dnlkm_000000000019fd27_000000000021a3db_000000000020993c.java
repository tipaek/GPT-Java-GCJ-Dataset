import java.util.*;

public class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            int[][] ar = new int[N][N];

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    ar[r][c] = in.nextInt();
                }
            }

            // sum
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += ar[i][i];
            }

            // duplcate rows
            int dupRow = 0;
            for (int r = 0; r < N; r++) {
                HashSet<Integer> set = new HashSet<>();
                for (int c = 0; c < N; c++) {
                    if (set.contains(ar[r][c])) {
                        dupRow++;
                        break;
                    }
                    set.add(ar[r][c]);
                }
            }

            int dupCol = 0;
            for (int c = 0; c < N; c++) {
                HashSet<Integer> set = new HashSet<>();
                for (int r = 0; r < N; r++) {
                    if (set.contains(ar[r][c])) {
                        dupCol++;
                        break;
                    }
                    set.add(ar[r][c]);
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", t, sum, dupRow, dupCol);
        }
    }
}