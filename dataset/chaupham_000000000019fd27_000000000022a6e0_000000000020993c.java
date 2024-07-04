import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        List<String> solutions = new ArrayList();
        
        for (int i = 1; i <= numberOfTestCases; ++i) {
            final int matrixSize = in.nextInt();
            int[][] inputMaxtrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    inputMaxtrix[row][col] = in.nextInt();
                }
            }
            
            solutions.add(solveVestigumProblem(inputMaxtrix, matrixSize, i));
        }
        
        for (String solution: solutions) {
            System.out.println(solution);
        }
    }
    
    private static String solveVestigumProblem(int[][] inputMatrix, final int size, final int testCaseNumber) {
        int trace = 0;
        int rowDuplication = 0;
        int colDuplication = 0;
        
        // TODO:
        for (int r = 0; r < size; r++) {
            trace += inputMatrix[r][r];
        }
        
        for (int r = 0; r < size; r++) {
            boolean[] rowHash = new boolean[size + 1];
            
            for (int c = 0; c < size; c++) {
                if (rowHash[inputMatrix[r][c]]) {
                    rowDuplication++;
                    break;
                } else {
                    rowHash[inputMatrix[r][c]] = true;
                }
            }
        }
        
        for (int c = 0; c < size; c++) {
            boolean[] colHash = new boolean[size + 1];
            
            for (int r = 0; r < size; r++) {
                if (colHash[inputMatrix[r][c]]) {
                    colDuplication++;
                    break;
                } else {
                    colHash[inputMatrix[r][c]] = true;
                }
            }
        }
        // Print solution here
        return printSolution(testCaseNumber, trace, rowDuplication, colDuplication);
    }
    
    public static String printSolution(int testCaseNumber, int trace, int rowDuplication, int colDuptioncation) {
        return String.format("Case #%d: %d %d %d", testCaseNumber, trace, rowDuplication, colDuptioncation);
    }
}
