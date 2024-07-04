import java.util.HashSet;
import java.util.Scanner;

public class CodeJamProblem1 {

    private static boolean hasDuplicatesWithinDistance(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                return true;
            }

            set.add(arr[i]);

            if (i >= k) {
                set.remove(arr[i - k]);
            }
        }
        return false;
    }

    private static int countColumnsWithDuplicates(int[][] matrix, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (hasDuplicatesWithinDistance(matrix[i], n)) {
                count++;
            }
        }
        return count;
    }

    private static int countRowsWithDuplicates(int[][] matrix, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            int[] row = new int[n];
            for (int j = 0; j < n; j++) {
                row[j] = matrix[i][j];
            }
            if (hasDuplicatesWithinDistance(row, n)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }

            int columnsWithDuplicates = countColumnsWithDuplicates(matrix, n);
            int rowsWithDuplicates = countRowsWithDuplicates(matrix, n);

            System.out.println("Case #" + (t + 1) + ": " + diagonalSum + " " + columnsWithDuplicates + " " + rowsWithDuplicates);
        }

        scanner.close();
    }
}