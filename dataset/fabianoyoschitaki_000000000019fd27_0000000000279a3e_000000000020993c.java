import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static final Scanner scan = new Scanner(System.in);

    /**
     * @param args
     */
    public static void main(String[] args) {
        int tests = scan.nextInt();
        for (int i = 0; i < tests; i++) {
            int [][] matrix = getMatrixInput();
            checkMatrix(i+1, matrix);
        }
    }

    private static void checkMatrix(int pos, int[][] matrix) {
        int trace = 0, rowsRepeated = 0, colsRepeated = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            Set<Integer> row = new HashSet<Integer>();
            Set<Integer> col = new HashSet<Integer>();
            boolean alreadyFoundRow = false, alreadyFoundCol = false;
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j)
                    trace += matrix[i][j];
                if (row.contains(matrix[i][j]) && !alreadyFoundRow) {
                    rowsRepeated++;
                    alreadyFoundRow = true;
                }
                if (col.contains(matrix[j][i]) && !alreadyFoundCol) {
                    colsRepeated++;
                    alreadyFoundCol = true;
                }
                row.add(matrix[i][j]);
                col.add(matrix[j][i]);
            }
        }
        System.out.println("Case #" + pos + ": " + trace + " " + rowsRepeated + " " + colsRepeated);
    }

    private static int[][] getMatrixInput() {
        int matrixSize = scan.nextInt();
        int [][] matrix = new int [matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        return matrix;
    }
}
