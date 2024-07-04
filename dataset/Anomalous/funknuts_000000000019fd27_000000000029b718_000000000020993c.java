import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

class Solution {

    public static void main(String[] args) {
        try (BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in))) {
            int numCases = Integer.parseInt(buffReader.readLine());

            for (int caseNumber = 1; caseNumber <= numCases; caseNumber++) {
                int trace = 0;
                int duplicateRows = 0;
                int duplicateColumns = 0;

                int matrixSize = Integer.parseInt(buffReader.readLine());
                int[][] matrix = new int[matrixSize][matrixSize];

                // Read matrix and calculate trace
                for (int i = 0; i < matrixSize; i++) {
                    String[] rowElements = buffReader.readLine().split(" ");
                    HashSet<Integer> rowSet = new HashSet<>();
                    boolean rowHasDuplicates = false;

                    for (int j = 0; j < matrixSize; j++) {
                        int value = Integer.parseInt(rowElements[j]);
                        matrix[i][j] = value;
                        
                        if (i == j) {
                            trace += value;
                        }
                        
                        if (!rowSet.add(value)) {
                            rowHasDuplicates = true;
                        }
                    }

                    if (rowHasDuplicates) {
                        duplicateRows++;
                    }
                }

                // Check for duplicate columns
                for (int j = 0; j < matrixSize; j++) {
                    HashSet<Integer> columnSet = new HashSet<>();
                    boolean columnHasDuplicates = false;

                    for (int i = 0; i < matrixSize; i++) {
                        if (!columnSet.add(matrix[i][j])) {
                            columnHasDuplicates = true;
                        }
                    }

                    if (columnHasDuplicates) {
                        duplicateColumns++;
                    }
                }

                System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
            }

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}