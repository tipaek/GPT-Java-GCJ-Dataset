import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static int[] vestigium(int[][] mat) {
        int[] res = new int[3];
        int n = mat.length; // Using mat.length instead of mat[0].length for clarity

        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            res[0] += mat[i][i]; // Sum of diagonals
            rowSet.clear();
            colSet.clear();
            boolean rowRepeat = false;
            boolean colRepeat = false;

            for (int j = 0; j < n; j++) {
                // Check for row duplicates
                if (!rowRepeat) {
                    if (!rowSet.add(mat[i][j])) {
                        res[1]++;
                        rowRepeat = true;
                    }
                }
                // Check for column duplicates
                if (!colRepeat) {
                    if (!colSet.add(mat[j][i])) {
                        res[2]++;
                        colRepeat = true;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        for (int t = 1; t <= T; t++) { // Start from 1 to properly show case number
            int n = s.nextInt();
            int[][] mat = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = s.nextInt();
                }
            }

            int[] krc = vestigium(mat);
            System.out.printf("Case #%d: %d %d %d%n", t, krc[0], krc[1], krc[2]);
        }

        s.close();
    }
}