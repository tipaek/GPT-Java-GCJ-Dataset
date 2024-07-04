import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = scanner.nextInt();

        for (int i = 0; i < testCount; i++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            for (int row = 0; row < size; row++) {
                for (int column = 0; column < size; column++) {
                    matrix[row][column] = scanner.nextInt();
                }
            }
            processMatrix(matrix, i + 1);
        }
    }

    private static void processMatrix(int[][] matrix, int caseNumber) {
        int diagonalSum = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;

        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            boolean rowDuplicate = false;
            boolean colDuplicate = false;

            for (int j = 0; j < matrix.length; j++) {
                if (i == j) {
                    diagonalSum += matrix[i][j];
                }
                if (!rowSet.add(matrix[i][j])) {
                    rowDuplicate = true;
                }
                if (!colSet.add(matrix[j][i])) {
                    colDuplicate = true;
                }
            }

            if (rowDuplicate) {
                duplicateRows++;
            }
            if (colDuplicate) {
                duplicateCols++;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
    }
}