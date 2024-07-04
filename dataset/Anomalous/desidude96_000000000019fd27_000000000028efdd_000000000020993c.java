import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        
        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            List<List<Integer>> matrixRows = new ArrayList<>();
            
            for (int i = 0; i < matrixSize; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j < matrixSize; j++) {
                    row.add(scanner.nextInt());
                }
                matrixRows.add(row);
            }
            
            int[][] matrix = convertToMatrix(matrixRows);
            String result = calculateMatrixValues(matrix);
            System.out.println("Case #" + caseIndex + ": " + result);
        }
    }

    private static int[][] convertToMatrix(List<List<Integer>> rows) {
        int size = rows.size();
        int[][] matrix = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            List<Integer> row = rows.get(i);
            for (int j = 0; j < size; j++) {
                matrix[i][j] = row.get(j);
            }
        }
        
        return matrix;
    }

    private static String calculateMatrixValues(int[][] matrix) {
        int trace = 0;
        int duplicateRowsCount = 0;
        int duplicateColsCount = 0;
        int size = matrix.length;

        for (int i = 0; i < size; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> colSet = new HashSet<>();
            
            for (int j = 0; j < size; j++) {
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);
                if (i == j) {
                    trace += matrix[i][j];
                }
            }
            
            if (rowSet.size() != size) {
                duplicateRowsCount++;
            }
            if (colSet.size() != size) {
                duplicateColsCount++;
            }
        }

        return trace + " " + duplicateRowsCount + " " + duplicateColsCount;
    }
}