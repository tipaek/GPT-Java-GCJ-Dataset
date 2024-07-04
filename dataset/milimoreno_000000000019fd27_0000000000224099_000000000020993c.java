import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    static Scanner io = new Scanner(System.in);

    static int ni() {
        return io.nextInt();
    }

    static int[][] nim(int N, int cols) {
        int[][] matrix = new int[N][cols];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = ni();
            }
        }
        return matrix;
    }

    static void matrixLatinSquare(int[][] matrix, int N, int testNumber) {
        Set<Integer> rows;
        int rowsRep = 0, colsRep = 0;
        Set<Integer> cols;
        boolean repRows, repCols;
        for (int i = 0; i < N; i++) {
            rows = new HashSet<>();
            cols = new HashSet<>();
            repRows = repCols = false;
            for (int j = 0; j < N; j++) {
                if(!repRows) {
                    if (rows.contains(matrix[i][j])) {
                        rowsRep++;
                        repRows = true;
                    } else {
                        rows.add(matrix[i][j]);
                    }
                }
                if (!repCols) {
                    if (cols.contains(matrix[j][i])) {
                        colsRep++;
                        repCols = true;
                    } else {
                        cols.add(matrix[j][i]);
                    }
                }
            }
        }
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }
        System.out.println(String.format("Case #%d: %d %d %d", testNumber, trace, rowsRep, colsRep));
    }

    public static void main(String[] args) {
        int T = io.nextInt();
        int N;
        int[][] matrix;
        for (int i = 0; i < T; i++) {
            N = io.nextInt();
            matrix = nim(N, N);
            matrixLatinSquare(matrix, N, i);
        }
    }
}
