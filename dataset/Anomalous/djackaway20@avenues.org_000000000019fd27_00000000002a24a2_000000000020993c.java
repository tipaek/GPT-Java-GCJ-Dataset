import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt(); // Number of cases
        
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int matrixSize = scanner.nextInt(); // Matrix size
            int[] matrix = new int[matrixSize * matrixSize];
            
            // Read matrix elements
            for (int i = 0; i < matrix.length; i++) {
                matrix[i] = scanner.nextInt();
            }
            
            // Calculate the trace
            int trace = 0;
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i * (matrixSize + 1)];
            }
            
            // Calculate the number of rows with repeated elements
            int repeatedRows = 0;
            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> uniqueElements = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    int element = matrix[row * matrixSize + col];
                    if (!uniqueElements.add(element)) {
                        repeatedRows++;
                        break;
                    }
                }
            }
            
            // Calculate the number of columns with repeated elements
            int repeatedColumns = 0;
            for (int col = 0; col < matrixSize; col++) {
                Set<Integer> uniqueElements = new HashSet<>();
                for (int row = 0; row < matrixSize; row++) {
                    int element = matrix[row * matrixSize + col];
                    if (!uniqueElements.add(element)) {
                        repeatedColumns++;
                        break;
                    }
                }
            }
            
            // Print the result for the current case
            System.out.println("Case #" + caseNumber + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }
    }
}