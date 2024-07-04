import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {

    public int[] latins(int[][] mat) {
        int n = mat.length;
        int diagSum = 0;
        int rowDup = 0;
        int colDup = 0;
        Set<Integer>[] rowSet = new HashSet[n];
        Set<Integer>[] colSet = new HashSet[n];

        for (int i = 0; i < n; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    diagSum += mat[i][j];
                }
                rowSet[i].add(mat[i][j]);
                colSet[j].add(mat[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (rowSet[i].size() < n) {
                rowDup++;
            }
            if (colSet[i].size() < n) {
                colDup++;
            }
        }

        return new int[]{diagSum, rowDup, colDup};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Number of test cases

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt(); // Size of the matrix
            int[][] mat = new int[n][n];

            for (int j = 0; j < n * n; j++) {
                mat[j / n][j % n] = in.nextInt();
            }

            int[] result = s.latins(mat);
            System.out.println("Case #" + i + ": " + result[0] + " " + result[1] + " " + result[2]);
        }
    }
}