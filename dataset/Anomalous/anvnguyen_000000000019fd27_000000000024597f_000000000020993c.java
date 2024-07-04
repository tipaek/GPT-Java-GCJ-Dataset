import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            int[] results = calculateTraceAndDuplicates(matrix, matrixSize);
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, results[0], results[1], results[2]);
        }
    }

    private static int[] calculateTraceAndDuplicates(int[][] matrix, int size) {
        int trace = 0;
        int duplicateRows = 0;
        int duplicateColumns = 0;

        List<Set<Integer>> rowSets = new ArrayList<>();
        List<Set<Integer>> colSets = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            rowSets.add(new HashSet<>());
            colSets.add(new HashSet<>());
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (row == col) {
                    trace += matrix[row][col];
                }
                rowSets.get(row).add(matrix[row][col]);
                colSets.get(col).add(matrix[row][col]);
            }
        }

        for (Set<Integer> rowSet : rowSets) {
            if (rowSet.size() < size) {
                duplicateRows++;
            }
        }

        for (Set<Integer> colSet : colSets) {
            if (colSet.size() < size) {
                duplicateColumns++;
            }
        }

        return new int[] { trace, duplicateRows, duplicateColumns };
    }
}