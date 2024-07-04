import java.util.Scanner;

public class MatrixProcessor {

    public static void processMatrix(int[][] matrix, int size, int caseNumber) {
        int trace = 0;
        int rowDuplicates = 0;
        int colDuplicates = 0;

        for (int i = 0; i < size; i++) {
            boolean rowHasDuplicates = true;
            boolean colHasDuplicates = true;

            for (int j = 0; j < size - 1; j++) {
                if (matrix[i][j] != matrix[i][j + 1]) {
                    rowHasDuplicates = false;
                }
                if (matrix[j][i] != matrix[j + 1][i]) {
                    colHasDuplicates = false;
                }
            }

            if (rowHasDuplicates) {
                rowDuplicates++;
            }
            if (colHasDuplicates) {
                colDuplicates++;
            }
        }

        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            processMatrix(matrix, size, t + 1);
        }

        scanner.close();
    }
}