import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int matrixSize = scanner.nextInt();

            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            int[][] matrix = new int[matrixSize][matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                boolean[] rowCheck = new boolean[matrixSize];
                boolean rowHasDuplicate = false;
                for (int j = 0; j < matrixSize; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;
                    if (i == j) {
                        trace += value;
                    }
                    if (rowCheck[value - 1]) {
                        rowHasDuplicate = true;
                    } else {
                        rowCheck[value - 1] = true;
                    }
                }
                if (rowHasDuplicate) {
                    rowDuplicates++;
                }
            }

            for (int i = 0; i < matrixSize; i++) {
                boolean[] colCheck = new boolean[matrixSize];
                for (int j = 0; j < matrixSize; j++) {
                    int value = matrix[j][i];
                    if (colCheck[value - 1]) {
                        colDuplicates++;
                        break;
                    } else {
                        colCheck[value - 1] = true;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }
}