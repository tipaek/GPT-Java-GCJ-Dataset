import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] M = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            int[] result = solve(M);
            System.out.println("Case #" + test_case + ": " + result[0] + " " + result[1] + " " + result[2]);
        }
        sc.close();
    }

    public static int[] solve(int[][] M) {
        if (M == null || M.length == 0) return new int[] { 0, 0, 0 };
        int N = M.length; // given, it's a square matrix

        int trace = 0, duplicateRows = 0, duplicateCols = 0;

        for (int i = 0; i < N; i++) {
            trace += M[i][i];
        }

        HashSet<Integer> set = new HashSet<>();

        for (int r = 0; r < N; r++) {
            set.clear();
            for (int c = 0; c < N; c++) {
                if (set.contains(M[r][c])) {
                    duplicateRows++;
                    break;
                } else {
                    set.add(M[r][c]);
                }
            }
        }

        for (int c = 0; c < N; c++) {
            set.clear();
            for (int r = 0; r < N; r++) {
                if (set.contains(M[r][c])) {
                    duplicateCols++;
                    break;
                } else {
                    set.add(M[r][c]);
                }
            }
        }

        return new int[] { trace, duplicateRows, duplicateCols };
    }
}
