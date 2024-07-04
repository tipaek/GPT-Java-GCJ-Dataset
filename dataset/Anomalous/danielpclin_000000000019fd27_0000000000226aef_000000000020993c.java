import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int t = 1; t <= testCases; t++) {
                System.out.print("Case #" + t + ": ");
                int matrixSize = scanner.nextInt();
                int[][] matrix = new int[matrixSize][matrixSize];

                // Read matrix values
                for (int i = 0; i < matrixSize; i++) {
                    for (int j = 0; j < matrixSize; j++) {
                        matrix[i][j] = scanner.nextInt();
                    }
                }

                int trace = 0, rowDuplicates = 0, colDuplicates = 0;

                // Calculate trace
                for (int i = 0; i < matrixSize; i++) {
                    trace += matrix[i][i];
                }

                // Check for duplicate values in rows and columns
                for (int i = 0; i < matrixSize; i++) {
                    boolean[] rowCheck = new boolean[matrixSize];
                    boolean[] colCheck = new boolean[matrixSize];
                    boolean rowHasDuplicate = false;
                    boolean colHasDuplicate = false;

                    for (int j = 0; j < matrixSize; j++) {
                        // Check row for duplicates
                        if (!rowHasDuplicate) {
                            if (rowCheck[matrix[i][j] - 1]) {
                                rowHasDuplicate = true;
                            } else {
                                rowCheck[matrix[i][j] - 1] = true;
                            }
                        }

                        // Check column for duplicates
                        if (!colHasDuplicate) {
                            if (colCheck[matrix[j][i] - 1]) {
                                colHasDuplicate = true;
                            } else {
                                colCheck[matrix[j][i] - 1] = true;
                            }
                        }
                    }

                    if (rowHasDuplicate) rowDuplicates++;
                    if (colHasDuplicate) colDuplicates++;
                }

                System.out.println(trace + " " + rowDuplicates + " " + colDuplicates);
            }
        }
    }
}