import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            long trace = 0;
            int rowCount = 0;
            int colCount = 0;

            int[][] matrix = new int[n][n];
            boolean[] rowRepeat = new boolean[n];
            boolean[] colRepeat = new boolean[n];

            for (int j = 0; j < n; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (j == 0) {
                        colRepeat[k] = false;
                    }
                    matrix[j][k] = sc.nextInt();

                    if (j == k) {
                        trace += matrix[j][k];
                    }

                    if (!rowSet.add(matrix[j][k]) && !rowRepeat[j]) {
                        rowRepeat[j] = true;
                        rowCount++;
                    }

                    if (!colRepeat[k]) {
                        boolean colDup = false;
                        for (int l = 0; l < j; l++) {
                            if (matrix[l][k] == matrix[j][k]) {
                                colDup = true;
                                break;
                            }
                        }
                        if (colDup) {
                            colRepeat[k] = true;
                            colCount++;
                        }
                    }
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowCount + " " + colCount);
        }
        sc.close();
    }
}