import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[][] mat = new int[N][N];
            int trace = 0, rowCount = 0, colCount = 0;

            for (int j = 0; j < N; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < N; k++) {
                    mat[j][k] = sc.nextInt();
                    if (j == k) {
                        trace += mat[j][k];
                    }
                    rowSet.add(mat[j][k]);
                }
                if (rowSet.size() < N) {
                    rowCount++;
                }
            }

            for (int k = 0; k < N; k++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    colSet.add(mat[j][k]);
                }
                if (colSet.size() < N) {
                    colCount++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowCount + " " + colCount);
        }
    }
}