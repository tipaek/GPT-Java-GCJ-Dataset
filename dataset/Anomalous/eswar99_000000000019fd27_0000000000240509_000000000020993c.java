import java.util.Scanner;

class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, n);
            int rowDuplicates = countRowDuplicates(matrix, n);
            int columnDuplicates = countColumnDuplicates(matrix, n);

            System.out.println("Case #" + caseIndex + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(int[][] matrix, int size) {
        int rowDuplicates = 0;
        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix[i])) {
                rowDuplicates++;
            }
        }
        return rowDuplicates;
    }

    private static int countColumnDuplicates(int[][] matrix, int size) {
        int columnDuplicates = 0;
        for (int j = 0; j < size; j++) {
            int[] column = new int[size];
            for (int i = 0; i < size; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column)) {
                columnDuplicates++;
            }
        }
        return columnDuplicates;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}