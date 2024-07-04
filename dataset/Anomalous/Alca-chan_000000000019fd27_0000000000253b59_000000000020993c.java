package codejam;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCases = scanner.nextInt();
        
        if (numOfCases <= 0) {
            return;
        }

        StringBuilder result = new StringBuilder();
        
        for (int caseIndex = 0; caseIndex < numOfCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> columnSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                boolean columnHasDuplicate = false;
                
                for (int j = 0; j < matrixSize; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowSet.add(matrix[i][j])) {
                        rowHasDuplicate = true;
                    }
                    if (!columnSet.add(matrix[j][i])) {
                        columnHasDuplicate = true;
                    }
                }
                
                if (rowHasDuplicate) {
                    duplicateRows++;
                }
                if (columnHasDuplicate) {
                    duplicateColumns++;
                }
            }
            
            result.append("Case #").append(caseIndex + 1).append(": ")
                  .append(trace).append(" ")
                  .append(duplicateRows).append(" ")
                  .append(duplicateColumns).append("\n");
        }
        
        System.out.print(result.toString());
    }
}