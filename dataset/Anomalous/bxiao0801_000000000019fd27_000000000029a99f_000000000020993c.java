import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] latins(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int diagSum = 0;
        int rowDup = 0;
        int colDup = 0;
        Set<Integer>[] rowSet = new HashSet[row];
        Set<Integer>[] colSet = new HashSet[col];

        for (int i = 0; i < row; i++) {
            rowSet[i] = new HashSet<>();
        }
        for (int j = 0; j < col; j++) {
            colSet[j] = new HashSet<>();
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == j) diagSum += mat[i][j];
                rowSet[i].add(mat[i][j]);
                colSet[j].add(mat[i][j]);
            }
        }

        for (int i = 0; i < row; i++) {
            if (rowSet[i].size() < col) rowDup++;
        }
        for (int j = 0; j < col; j++) {
            if (colSet[j].size() < row) colDup++;
        }

        return new int[]{diagSum, rowDup, colDup};
    }
}