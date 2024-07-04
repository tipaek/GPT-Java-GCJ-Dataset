import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void solve(Scanner input, int caseNumber, int matrixSize) {
        int[][] matrix = new int[matrixSize][matrixSize];
        
        // Read the matrix
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        // Calculate the trace
        int trace = 0;
        for (int i = 0; i < matrixSize; i++) {
            trace += matrix[i][i];
        }

        // Check for duplicate rows
        int duplicateRows = 0;
        for (int i = 0; i < matrixSize; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < matrixSize; j++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() < matrixSize) {
                duplicateRows++;
            }
        }

        // Check for duplicate columns
        int duplicateColumns = 0;
        for (int i = 0; i < matrixSize; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < matrixSize; j++) {
                uniqueElements.add(matrix[j][i]);
            }
            if (uniqueElements.size() < matrixSize) {
                duplicateColumns++;
            }
        }

        // Print the result for the current case
        System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = input.nextInt();
            solve(input, caseNumber, matrixSize);
        }
    }
}