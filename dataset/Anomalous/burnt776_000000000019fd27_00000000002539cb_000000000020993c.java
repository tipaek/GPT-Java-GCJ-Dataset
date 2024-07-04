import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Mtix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();

        for (int q = 1; q <= testCases; q++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            // Read matrix elements
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int diagonalSum = calculateDiagonalSum(matrix, n);
            int duplicateRows = countDuplicateRows(matrix, n);
            int duplicateColumns = countDuplicateColumns(matrix, n);

            System.out.println("Case #" + q + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
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
        for (int j = 0; j < n; j++) {
            int[] column = new int[n];
            for (int i = 0; i < n; i++) {
                column[i] = matrix[i][j];
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