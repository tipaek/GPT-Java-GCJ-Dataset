import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = s.nextInt();
            int[][] mat = new int[n][n];

            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    mat[a][b] = s.nextInt();
                }
            }

            int[] solve = solve(mat, n);
            System.out.println("Case #" + i + ": " + solve[0] + " " + solve[1] + " " + solve[2]);
        }

    }

    static int[] solve(int[][] mat, int n) {
        int trace = 0;
        int row = 0;
        int col = 0;
        for (int i = 0; i < n; i++) trace += mat[i][i];
        for (int i = 0; i < n; i++) if (isDuplicate(mat[i])) row++;

        for (int i = 0; i < n; i++) {
            Set<Integer> s = new HashSet<>();
            for (int j = 0; j < n; j++) {
                int val = mat[j][i];
                if (!s.add(val)) {
                    col++;
                    break;
                }
            }
        }
        return new int[]{trace, row, col};
    }

    static boolean isDuplicate(int[] arr) {
        Set<Integer> s = new HashSet<>();
        for (int anArr : arr) if (!s.add(anArr)) return true;
        return false;
    }

}
