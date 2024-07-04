import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            scanner.nextLine(); // consume the remaining newline
            
            // Read the matrix and calculate the trace
            for (int i = 0; i < matrixSize; i++) {
                String[] rowValues = scanner.nextLine().split(" ");
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = Integer.parseInt(rowValues[j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }
            
            // Check for row and column repetitions
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;
                
                for (int j = 0; j < matrixSize; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowHasDuplicate = true;
                    }
                    if (!colSet.add(matrix[j][i])) {
                        colHasDuplicate = true;
                    }
                }
                
                if (rowHasDuplicate) {
                    rowRepeats++;
                }
                if (colHasDuplicate) {
                    colRepeats++;
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        
        scanner.close();
    }
}