import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int t = 1; t <= testCases; t++) {
                int trace = 0, rowRepeats = 0, colRepeats = 0;
                System.out.print("Case #" + t + ": ");
                int matrixSize = scanner.nextInt();
                int[][] matrix = new int[matrixSize][matrixSize];

                // Read matrix
                for (int i = 0; i < matrixSize; i++) {
                    for (int j = 0; j < matrixSize; j++) {
                        matrix[i][j] = scanner.nextInt();
                    }
                }

                // Calculate trace
                for (int i = 0; i < matrixSize; i++) {
                    trace += matrix[i][i];
                }

                // Calculate expected XOR value
                int expectedXor = 0;
                for (int i = 1; i <= matrixSize; i++) {
                    expectedXor ^= i;
                }

                // Check rows and columns for duplicates
                for (int i = 0; i < matrixSize; i++) {
                    int rowXor = 0, colXor = 0;
                    for (int j = 0; j < matrixSize; j++) {
                        rowXor ^= matrix[i][j];
                        colXor ^= matrix[j][i];
                    }
                    if (rowXor != expectedXor) {
                        rowRepeats++;
                    }
                    if (colXor != expectedXor) {
                        colRepeats++;
                    }
                }

                System.out.println(trace + " " + rowRepeats + " " + colRepeats);
            }
        }
    }
}