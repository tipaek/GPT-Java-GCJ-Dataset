import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestibulus {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            int size = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline

            int[][] matrix = readMatrix(scanner, size);

            int trace = calculateTrace(matrix, size);
            int duplicateRows = countRowsWithDuplicates(matrix, size);
            int duplicateCols = countColsWithDuplicates(matrix, size);

            System.out.println("Case #" + i + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }

        scanner.close();
    }

    private static int[][] readMatrix(Scanner scanner, int size) {
        int[][] matrix = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            String[] rowValues = scanner.nextLine().trim().split("\\s+");
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Integer.parseInt(rowValues[j]);
            }
        }
        
        return matrix;
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        
        return trace;
    }

    private static int countRowsWithDuplicates(int[][] matrix, int size) {
        int duplicateRows = 0;
        
        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            boolean hasDuplicate = false;
            
            for (int j = 0; j < size; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    hasDuplicate = true;
                    break;
                }
            }
            
            if (hasDuplicate) {
                duplicateRows++;
            }
        }
        
        return duplicateRows;
    }

    private static int countColsWithDuplicates(int[][] matrix, int size) {
        int duplicateCols = 0;
        
        for (int j = 0; j < size; j++) {
            Set<Integer> colSet = new HashSet<>();
            boolean hasDuplicate = false;
            
            for (int i = 0; i < size; i++) {
                if (!colSet.add(matrix[i][j])) {
                    hasDuplicate = true;
                    break;
                }
            }
            
            if (hasDuplicate) {
                duplicateCols++;
            }
        }
        
        return duplicateCols;
    }
}