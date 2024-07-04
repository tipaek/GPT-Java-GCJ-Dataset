import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int trace = 0, rowDuplicates = 0, columnDuplicates = 0;

            int[][] matrix = new int[matrixSize][matrixSize];
            boolean[] columnDuplicateFlags = new boolean[matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                boolean[] rowElements = new boolean[matrixSize + 1];
                boolean isRowDuplicate = false;

                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;

                    // Calculate trace
                    if (row == col) {
                        trace += value;
                    }

                    // Check for row duplicates
                    if (rowElements[value]) {
                        isRowDuplicate = true;
                    }
                    rowElements[value] = true;

                    // Check for column duplicates
                    if (row == matrixSize - 1) {
                        boolean[] colElements = new boolean[matrixSize + 1];
                        for (int r = 0; r < matrixSize; r++) {
                            if (colElements[matrix[r][col]]) {
                                columnDuplicateFlags[col] = true;
                                break;
                            }
                            colElements[matrix[r][col]] = true;
                        }
                    }
                }

                if (isRowDuplicate) {
                    rowDuplicates++;
                }
            }

            for (boolean isColumnDuplicate : columnDuplicateFlags) {
                if (isColumnDuplicate) {
                    columnDuplicates++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
        }
    }
}