import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0, duplicateRows = 0, duplicateColumns = 0;
            
            for (int i = 0; i < matrixSize; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;
                    rowSet.add(value);
                    if (i == j) {
                        trace += value;
                    }
                }
                if (rowSet.size() != matrixSize) {
                    duplicateRows++;
                }
            }
            
            for (int j = 0; j < matrixSize; j++) {
                HashSet<Integer> columnSet = new HashSet<>();
                for (int i = 0; i < matrixSize; i++) {
                    columnSet.add(matrix[i][j]);
                }
                if (columnSet.size() != matrixSize) {
                    duplicateColumns++;
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
        
        scanner.close();
    }
}