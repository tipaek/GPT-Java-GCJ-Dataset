import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int[] traces = new int[testCases];

        for (int t = 0; t < testCases; t++) {
            int dimension = scanner.nextInt();
            int[][] matrix = new int[dimension][dimension];
            int rowDuplicates = 0, colDuplicates = 0;

            // Reading matrix and calculating trace
            for (int i = 0; i < dimension; i++) {
                int[] rowCheck = new int[dimension];
                boolean rowHasDuplicates = false;

                for (int j = 0; j < dimension; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        traces[t] += matrix[i][j];
                    }
                    if (rowCheck[matrix[i][j] - 1] == 1) {
                        rowHasDuplicates = true;
                    } else {
                        rowCheck[matrix[i][j] - 1] = 1;
                    }
                }
                if (rowHasDuplicates) {
                    rowDuplicates++;
                }
            }

            // Checking for column duplicates
            for (int j = 0; j < dimension; j++) {
                int[] colCheck = new int[dimension];
                boolean colHasDuplicates = false;

                for (int i = 0; i < dimension; i++) {
                    if (colCheck[matrix[i][j] - 1] == 1) {
                        colHasDuplicates = true;
                    } else {
                        colCheck[matrix[i][j] - 1] = 1;
                    }
                }
                if (colHasDuplicates) {
                    colDuplicates++;
                }
            }

            System.out.println(traces[t] + " " + rowDuplicates + " " + colDuplicates);
        }
        scanner.close();
    }
}