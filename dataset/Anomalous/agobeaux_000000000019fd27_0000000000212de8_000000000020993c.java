import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            boolean[] duplRow = new boolean[N];
            boolean[] duplCol = new boolean[N];
            boolean[][] rowsElems = new boolean[N][N];
            boolean[][] colsElems = new boolean[N][N];
            int trace = 0;

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    int value = sc.nextInt() - 1;

                    if (rowsElems[row][value]) {
                        duplRow[row] = true;
                    }
                    rowsElems[row][value] = true;

                    if (colsElems[col][value]) {
                        duplCol[col] = true;
                    }
                    colsElems[col][value] = true;

                    if (row == col) {
                        trace += value + 1;
                    }
                }
            }

            int duplicateRows = 0, duplicateCols = 0;
            for (int j = 0; j < N; j++) {
                if (duplRow[j]) {
                    duplicateRows++;
                }
                if (duplCol[j]) {
                    duplicateCols++;
                }
            }

            System.out.println(String.format("Case #%d: %d %d %d", i, trace, duplicateRows, duplicateCols));
        }

        sc.close();
    }
}