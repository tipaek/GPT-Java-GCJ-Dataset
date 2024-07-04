import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
                int matrixSize = scanner.nextInt();
                int[][] matrix = new int[matrixSize][matrixSize];
                int trace = 0;
                int rowRepeats = 0;
                int colRepeats = 0;

                // Read the matrix and calculate the trace
                for (int i = 0; i < matrixSize; ++i) {
                    boolean[] rowCheck = new boolean[matrixSize + 1];
                    boolean rowHasRepeats = false;
                    for (int j = 0; j < matrixSize; ++j) {
                        matrix[i][j] = scanner.nextInt();
                        if (i == j) {
                            trace += matrix[i][j];
                        }
                        if (rowCheck[matrix[i][j]]) {
                            rowHasRepeats = true;
                        }
                        rowCheck[matrix[i][j]] = true;
                    }
                    if (rowHasRepeats) {
                        rowRepeats++;
                    }
                }

                // Check for column repeats
                for (int j = 0; j < matrixSize; ++j) {
                    boolean[] colCheck = new boolean[matrixSize + 1];
                    boolean colHasRepeats = false;
                    for (int i = 0; i < matrixSize; ++i) {
                        if (colCheck[matrix[i][j]]) {
                            colHasRepeats = true;
                        }
                        colCheck[matrix[i][j]] = true;
                    }
                    if (colHasRepeats) {
                        colRepeats++;
                    }
                }

                System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}