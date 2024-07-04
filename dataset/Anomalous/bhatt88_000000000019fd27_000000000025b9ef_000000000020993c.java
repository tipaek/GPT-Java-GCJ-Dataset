import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int totalCases = Integer.parseInt(reader.readLine());
        
        for (int caseIndex = 0; caseIndex < totalCases; caseIndex++) {
            int matrixSize = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int row = 0; row < matrixSize; row++) {
                String[] lineElements = reader.readLine().split(" ");
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(lineElements[col]);
                }
            }
            
            System.out.println("Case #" + (caseIndex + 1) + ": " + calculateResult(matrix, matrixSize));
        }
    }

    private static String calculateResult(int[][] matrix, int size) {
        Set<Integer>[] rowSets = new Set[size];
        Set<Integer>[] colSets = new Set[size];
        int trace = 0, completeRows = 0, completeCols = 0;
        
        for (int i = 0; i < size; i++) {
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (row == col) {
                    trace += matrix[row][col];
                }
                rowSets[row].add(matrix[row][col]);
                colSets[col].add(matrix[row][col]);
            }
        }

        for (int i = 0; i < size; i++) {
            if (rowSets[i].size() == size) completeRows++;
            if (colSets[i].size() == size) completeCols++;
        }

        return trace + " " + (size - completeRows) + " " + (size - completeCols);
    }
}