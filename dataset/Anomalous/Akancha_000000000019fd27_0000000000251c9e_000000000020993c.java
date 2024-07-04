import java.util.Scanner;

class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int[] traces = new int[testCases];

        for (int t = 0; t < testCases; t++) {
            int dimension = scanner.nextInt();
            int[][] matrix = new int[dimension][dimension];
            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Read matrix and calculate trace
            for (int i = 0; i < dimension; i++) {
                boolean[] rowCheck = new boolean[dimension];
                boolean rowHasDuplicate = false;
                for (int j = 0; j < dimension; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        traces[t] += matrix[i][j];
                    }
                    if (rowCheck[matrix[i][j] - 1]) {
                        rowHasDuplicate = true;
                    } else {
                        rowCheck[matrix[i][j] - 1] = true;
                    }
                }
                if (rowHasDuplicate) {
                    rowDuplicates++;
                }
            }

            // Check for column duplicates
            for (int j = 0; j < dimension; j++) {
                boolean[] colCheck = new boolean[dimension];
                boolean colHasDuplicate = false;
                for (int i = 0; i < dimension; i++) {
                    if (colCheck[matrix[i][j] - 1]) {
                        colHasDuplicate = true;
                    } else {
                        colCheck[matrix[i][j] - 1] = true;
                    }
                }
                if (colHasDuplicate) {
                    colDuplicates++;
                }
            }

            System.out.println(traces[t] + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}