import java.util.Scanner;

class Code {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int l = 0; l < t; l++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Calculating the trace
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Counting rows with duplicate values
            int rowsWithDuplicates = 0;
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowsWithDuplicates++;
                }
            }

            // Counting columns with duplicate values
            int columnsWithDuplicates = 0;
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(getColumn(matrix, i))) {
                    columnsWithDuplicates++;
                }
            }

            System.out.println("Case #" + (l + 1) + ": " + trace + " " + rowsWithDuplicates + " " + columnsWithDuplicates);
        }

        sc.close();
    }

    // Helper method to check if an array has duplicates
    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }

    // Helper method to get a column from a 2D array
    private static int[] getColumn(int[][] matrix, int columnIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }
}