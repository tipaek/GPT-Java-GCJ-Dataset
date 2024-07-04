import java.util.Scanner;

public class Prog1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int x = 0; x < t; x++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int diagonalSum = calculateDiagonalSum(matrix, n);
            int duplicateRows = countDuplicateRows(matrix, n);
            int duplicateCols = countDuplicateColumns(matrix, n);

            System.out.println("Case #" + (x + 1) + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }
    }

    private static int calculateDiagonalSum(int[][] matrix, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int countDuplicateRows(int[][] matrix, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (hasDuplicates(matrix[i])) {
                count++;
            }
        }
        return count;
    }

    private static int countDuplicateColumns(int[][] matrix, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            int[] column = new int[n];
            for (int j = 0; j < n; j++) {
                column[j] = matrix[j][i];
            }
            if (hasDuplicates(column)) {
                count++;
            }
        }
        return count;
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