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
            List<String> matrixRows = new ArrayList<>();
            
            for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
                matrixRows.add(scanner.next());
            }
            
            int[][] matrix = parseMatrix(matrixRows);
            String result = analyzeMatrix(matrix);
            System.out.println("Case #" + caseIndex + ": " + result);
        }
    }

    private static int[][] parseMatrix(List<String> rows) {
        int size = rows.size();
        int[][] matrix = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            String[] rowValues = rows.get(i).split(" ");
            for (int j = 0; j < rowValues.length; j++) {
                matrix[i][j] = Integer.parseInt(rowValues[j]);
            }
        }
        
        return matrix;
    }

    private static String analyzeMatrix(int[][] matrix) {
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