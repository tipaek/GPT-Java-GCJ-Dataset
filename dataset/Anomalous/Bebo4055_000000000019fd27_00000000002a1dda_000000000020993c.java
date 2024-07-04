import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();

        ArrayList<int[][]> matrices = new ArrayList<>();
        for (int i = 0; i < numCases; i++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            matrices.add(matrix);
        }

        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            int[][] matrix = matrices.get(caseIndex);
            int size = matrix.length;

            // Calculate the trace
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }

            // Check for row and column repeats
            for (int i = 0; i < size; i++) {
                boolean[] rowCheck = new boolean[size];
                boolean[] colCheck = new boolean[size];
                for (int j = 0; j < size; j++) {
                    rowCheck[matrix[i][j] - 1] = true;
                    colCheck[matrix[j][i] - 1] = true;
                }
                for (int j = 0; j < size; j++) {
                    if (!rowCheck[j]) {
                        rowRepeats++;
                        break;
                    }
                    if (!colCheck[j]) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (caseIndex + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}