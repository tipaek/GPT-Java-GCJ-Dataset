import java.util.HashSet;
import java.util.Scanner;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;
            
            // Reading the matrix and calculating the trace
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }
            
            // Checking for duplicate elements in each row
            for (int row = 0; row < size; row++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < size; col++) {
                    if (!rowSet.add(matrix[row][col])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }
            
            // Checking for duplicate elements in each column
            for (int col = 0; col < size; col++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int row = 0; row < size; row++) {
                    if (!colSet.add(matrix[row][col])) {
                        colDuplicates++;
                        break;
                    }
                }
            }
            
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, rowDuplicates, colDuplicates);
        }
        
        scanner.close();
    }
}