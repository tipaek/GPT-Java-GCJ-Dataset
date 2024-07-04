import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int currentCase = 1; currentCase <= testCases; currentCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Reading matrix elements
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculating trace
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            // Checking for row repeats
            for (int i = 0; i < matrixSize; i++) {
                HashMap<Integer, Boolean> rowMap = new HashMap<>();
                for (int j = 0; j < matrixSize; j++) {
                    if (rowMap.containsKey(matrix[i][j])) {
                        rowRepeats++;
                        break;
                    } else {
                        rowMap.put(matrix[i][j], true);
                    }
                }
            }

            // Checking for column repeats
            for (int i = 0; i < matrixSize; i++) {
                HashMap<Integer, Boolean> colMap = new HashMap<>();
                for (int j = 0; j < matrixSize; j++) {
                    if (colMap.containsKey(matrix[j][i])) {
                        colRepeats++;
                        break;
                    } else {
                        colMap.put(matrix[j][i], true);
                    }
                }
            }

            result.append("Case #").append(currentCase).append(": ").append(trace).append(" ").append(rowRepeats).append(" ").append(colRepeats).append("\n");
        }

        System.out.print(result.toString());
        scanner.close();
    }
}