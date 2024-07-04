import java.util.*;
import java.lang.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[] k = new int[T], r = new int[T], c = new int[T];

        for(int i = 0; i < T; i++)
        {
            int N = in.nextInt();
            int[][] a = new int[N][N];
            int trace = 0;

            for(int j = 0; j < N; j++)
                for(int l = 0; l < N; l++) {
                    a[j][l] = in.nextInt();
                    if(i == j)
                        trace += a[i][j];
                }

            int[] rowsAndColumns = repeatingRowsAndColumns(a, N, N);

            k[i] = trace;
            r[i] = rowsAndColumns[0];
            c[i] = rowsAndColumns[1];
        }

        for(int i = 0; i < T; i++)
        {
            System.out.println("Case #" + (i + 1) + ": " + k[i] + " " + r[i] + " " + c[i]);
        }
    }

    static int[] repeatingRowsAndColumns(int[][] a, int rows, int cols) {
        int noOfRows = 0, noOfColumns = 0;
        boolean foundRow = false, foundColumn = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols - 1; j++) {
                for (int k = j + 1; k < cols; k++) {
                    if (a[i][j] == a[i][k] && !foundRow) {
                        foundRow = true;
                        noOfRows++;
                    }
                    if (a[j][i] == a[k][i] && !foundColumn) {
                        foundColumn = true;
                        noOfColumns++;
                    }
                }
            }
            foundRow = foundColumn = false;
        }

        return new int[]{noOfRows, noOfColumns};
    }
}
