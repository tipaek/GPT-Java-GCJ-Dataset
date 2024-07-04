import java.io.*;
import java.util.*;

public class Solution {

    static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateCount = 0;
        for (int i = 0; i < size; i++) {
            Arrays.sort(matrix[i]);
            for (int j = 0; j < size - 1; j++) {
                if (matrix[i][j] == matrix[i][j + 1]) {
                    duplicateCount++;
                    break;
                }
            }
        }
        return duplicateCount;
    }

    static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateCount = 0;
        // Transpose the matrix
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Count duplicate rows in the transposed matrix
        for (int i = 0; i < size; i++) {
            Arrays.sort(matrix[i]);
            for (int j = 0; j < size - 1; j++) {
                if (matrix[i][j] == matrix[i][j + 1]) {
                    duplicateCount++;
                    break;
                }
            }
        }
        return duplicateCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        int[][] results = new int[testCases][3];

        for (int t = 0; t < testCases; t++) {
            int size = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[size][size];
            int[][] matrixCopy = new int[size][size];

            for (int i = 0; i < size; i++) {
                String[] input = reader.readLine().split(" ");
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(input[j]);
                    matrixCopy[i][j] = matrix[i][j];
                }
            }

            int trace = 0;
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }
            results[t][0] = trace;

            results[t][1] = countDuplicateRows(matrix, size);
            results[t][2] = countDuplicateColumns(matrixCopy, size);
        }

        for (int t = 0; t < testCases; t++) {
            System.out.print("Case #" + (t + 1) + ": ");
            for (int i = 0; i < 3; i++) {
                System.out.print(results[t][i] + " ");
            }
            System.out.println();
        }
    }
}