import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            
            // Read the matrix and calculate the trace
            for (int i = 0; i < matrixSize; ++i) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < matrixSize; ++j) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;
                    rowSet.add(value);
                    if (i == j) {
                        trace += value;
                    }
                }
                if (rowSet.size() != matrixSize) {
                    rowRepeats++;
                }
            }
            
            // Check for column repeats
            for (int j = 0; j < matrixSize; ++j) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < matrixSize; ++i) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() != matrixSize) {
                    colRepeats++;
                }
            }
            
            System.out.println("Case #" + caseNum + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}