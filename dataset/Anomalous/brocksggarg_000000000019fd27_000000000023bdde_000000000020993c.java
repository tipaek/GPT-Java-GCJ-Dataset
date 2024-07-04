import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Vestigium {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= testCases; testCase++) {
            processTestCase(br, testCase);
        }
    }

    private static void processTestCase(BufferedReader br, int testCase) throws NumberFormatException, IOException {
        int matrixSize = Integer.parseInt(br.readLine());
        int[][] matrix = new int[matrixSize][matrixSize];
        
        for (int i = 0; i < matrixSize; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }

        int trace = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;
        
        // Calculate trace
        for (int i = 0; i < matrixSize; i++) {
            trace += matrix[i][i];
        }

        // Check for duplicate rows
        for (int i = 0; i < matrixSize; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < matrixSize; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    duplicateRows++;
                    break;
                }
            }
        }

        // Check for duplicate columns
        for (int j = 0; j < matrixSize; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < matrixSize; i++) {
                if (!colSet.add(matrix[i][j])) {
                    duplicateCols++;
                    break;
                }
            }
        }

        System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateCols);
    }
}