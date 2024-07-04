import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int k = 0; k < N; k++) {
            int rows = sc.nextInt();
            int cols = rows;

            int mat[][] = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }

            int traceCount = 0;

            for (int i = 0; i < rows; i++) {
                traceCount += mat[i][i];
            }

            HashSet<Integer> rowSet = new HashSet<>();
            int uniqueRows = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    rowSet.add(mat[i][j]);
                }
                if (rowSet.size() == rows) {
                    uniqueRows++;
                }
                rowSet.clear();
            }

            int uniqueCols = 0;
            for (int j = 0; j < cols; j++) {
                for (int i = 0; i < rows; i++) {
                    rowSet.add(mat[i][j]);
                }
                if (rowSet.size() == rows) {
                    uniqueCols++;
                }
                rowSet.clear();
            }

            System.out.println("Case #" + (k+1) + ": " + traceCount + " " + (rows-uniqueRows) + " " + (rows-uniqueCols));
        }

    }
}
