import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        for (int t = 0; t < T; t++) {
            int n = input.nextInt();
            int[][] mat = new int[n][n];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    mat[i][j] = input.nextInt();
                    rowSet.add(mat[i][j]);
                    if (i == j) {
                        trace += mat[i][j];
                    }
                }
                if (rowSet.size() != n) {
                    rowDuplicates++;
                }
            }

            for (int j = 0; j < n; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    colSet.add(mat[i][j]);
                }
                if (colSet.size() != n) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}