import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

class Solution {
    public int[] latins(int[][] mat) {
        int n = mat.length;
        int diagSum = 0;
        int rowDup = 0;
        int colDup = 0;

        @SuppressWarnings("unchecked")
        Set<Integer>[] rowSets = new HashSet[n];
        @SuppressWarnings("unchecked")
        Set<Integer>[] colSets = new HashSet[n];

        for (int i = 0; i < n; i++) {
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) diagSum += mat[i][j];
                rowSets[i].add(mat[i][j]);
                colSets[j].add(mat[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (rowSets[i].size() < n) rowDup++;
            if (colSets[i].size() < n) colDup++;
        }

        return new int[]{diagSum, rowDup, colDup};
    }
}