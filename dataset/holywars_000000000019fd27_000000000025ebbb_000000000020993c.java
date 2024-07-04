import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfTestCases = in.nextInt();
        List<int[][]> matrices = new ArrayList<>();
        for (int i = 0; i < numOfTestCases; i++) {
            int sizeOfMatrix = in.nextInt();
            int[][] matrix = getMatrix(in, sizeOfMatrix);
            int traceOfTheMatrix = 0;
            int rowsOfTheMatrix = 0;
            int columnsOfTheMatrix = 0;
            for (int j = 0; j < matrix.length; j++) {
                int rowsRepeatedElements = 0;
                int columnsRepeatedElements = 0;
                for (int k = 0; k < matrix[j].length; k++) {
                    if (k > 0) {
                        if (matrix[j][k - 1] == matrix[j][k]) {
                            rowsRepeatedElements++;
                        }
                        if (matrix[k - 1][j] == matrix[k][j]) {
                            columnsRepeatedElements++;
                        }
                    }
                    if (j == k) {
                        traceOfTheMatrix += matrix[j][k];
                    }
                }
                rowsOfTheMatrix = Math.max(rowsOfTheMatrix, rowsRepeatedElements);
                columnsOfTheMatrix = Math.max(columnsOfTheMatrix, columnsRepeatedElements);
            }
            if (rowsOfTheMatrix > 0) {
                rowsOfTheMatrix++;
            }
            if (columnsOfTheMatrix > 0) {
                columnsOfTheMatrix++;
            }
            System.out.println("Case #" + (i + 1) + ": " + traceOfTheMatrix + " " + rowsOfTheMatrix + " " + columnsOfTheMatrix);
        }

        in.close();
    }

    private static int[][] getMatrix(Scanner in, int sizeOfMatrix) {
        int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
        for (int i = 0; i < sizeOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        return matrix;
    }
}
