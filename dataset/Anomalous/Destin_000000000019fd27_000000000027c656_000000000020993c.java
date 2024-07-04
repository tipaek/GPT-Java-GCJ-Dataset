import java.util.*;

public class Solution {
    public static int[] vestigium(int[][] mat) {
        int[] res = new int[3];
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            res[0] += mat[i][i];
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            boolean rowRepeat = false;
            boolean colRepeat = false;

            for (int j = 0; j < n; j++) {
                if (!rowRepeat) {
                    if (row.contains(mat[i][j])) {
                        res[1]++;
                        rowRepeat = true;
                    } else {
                        row.add(mat[i][j]);
                    }
                }

                if (!colRepeat) {
                    if (col.contains(mat[j][i])) {
                        res[2]++;
                        colRepeat = true;
                    } else {
                        col.add(mat[j][i]);
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int n = scanner.nextInt();
            int[][] mat = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = scanner.nextInt();
                }
            }

            int[] krc = vestigium(mat);
            System.out.printf("Case #%d: %d %d %d%n", t, krc[0], krc[1], krc[2]);
        }

        scanner.close();
    }
}