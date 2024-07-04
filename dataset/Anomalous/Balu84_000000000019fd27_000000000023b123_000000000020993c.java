import java.util.*;
import java.io.*;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %d %d %d";
    private static final String SEPARATOR = " ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int trace = 0;
            int repeatedRows = 0;
            int repeatedColumns = 0;
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() != matrixSize) {
                    repeatedRows++;
                }
            }
            
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }
            
            for (int j = 0; j < matrixSize; j++) {
                Set<Integer> columnSet = new HashSet<>();
                for (int i = 0; i < matrixSize; i++) {
                    columnSet.add(matrix[i][j]);
                }
                if (columnSet.size() != matrixSize) {
                    repeatedColumns++;
                }
            }
            
            System.out.println(String.format(OUTPUT_FORMAT, testCase, trace, repeatedRows, repeatedColumns));
        }
    }
}