import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;
            
            // Reading the matrix and calculating the trace
            for (int i = 0; i < size; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowFlag = false;
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (rowSet.contains(matrix[i][j]) && !rowFlag) {
                        rowDuplicates++;
                        rowFlag = true;
                    }
                    rowSet.add(matrix[i][j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }
            
            // Checking for duplicate values in columns
            for (int i = 0; i < size; i++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colFlag = false;
                for (int j = 0; j < size; j++) {
                    if (colSet.contains(matrix[j][i]) && !colFlag) {
                        colDuplicates++;
                        colFlag = true;
                    }
                    colSet.add(matrix[j][i]);
                }
            }
            
            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
        
        scanner.close();
    }
}