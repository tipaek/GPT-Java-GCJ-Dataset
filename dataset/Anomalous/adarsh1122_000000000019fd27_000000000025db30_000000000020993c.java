import java.util.Scanner;

public class Bomber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int[][] results = new int[testCases][3];

        for (int k = 0; k < testCases; k++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Calculate diagonal sum
            results[k][0] = calculateDiagonalSum(matrix, n);

            // Calculate row repetitions
            results[k][1] = calculateRowRepetitions(matrix, n);

            // Calculate column repetitions
            results[k][2] = calculateColumnRepetitions(matrix, n);

            // Print results for the current test case
            System.out.print("Case #" + (k + 1) + ": ");
            for (int q = 0; q < 3; q++) {
                System.out.print(results[k][q] + " ");
            }
            System.out.println();
        }
    }

    private static int calculateDiagonalSum(int[][] matrix, int n) {
        int diagonalSum = 0;
        for (int i = 0; i < n; i++) {
            diagonalSum += matrix[i][i];
        }
        return diagonalSum;
    }

    private static int calculateRowRepetitions(int[][] matrix, int n) {
        int rowRepetitions = 0;
        for (int i = 0; i < n; i++) {
            if (hasRepetitions(matrix[i])) {
                rowRepetitions++;
            }
        }
        return rowRepetitions;
    }

    private static int calculateColumnRepetitions(int[][] matrix, int n) {
        int columnRepetitions = 0;
        for (int i = 0; i < n; i++) {
            int[] column = new int[n];
            for (int j = 0; j < n; j++) {
                column[j] = matrix[j][i];
            }
            if (hasRepetitions(column)) {
                columnRepetitions++;
            }
        }
        return columnRepetitions;
    }

    private static boolean hasRepetitions(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}