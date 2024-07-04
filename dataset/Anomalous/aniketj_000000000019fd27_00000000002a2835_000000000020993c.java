import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;
            
            for (int row = 0; row < matrixSize; ++row) {
                Set<Integer> rowSet = initializeSet(matrixSize);
                for (int col = 0; col < matrixSize; ++col) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                    rowSet.remove(matrix[row][col]);
                }
                if (!rowSet.isEmpty()) {
                    rowDuplicates++;
                }
            }
            
            for (int col = 0; col < matrixSize; ++col) {
                Set<Integer> colSet = initializeSet(matrixSize);
                for (int row = 0; row < matrixSize; ++row) {
                    colSet.remove(matrix[row][col]);
                }
                if (!colSet.isEmpty()) {
                    colDuplicates++;
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
    
    private static Set<Integer> initializeSet(int size) {
        Set<Integer> set = new HashSet<>();
        for (int number = 1; number <= size; ++number) {
            set.add(number);
        }
        return set;
    }
}