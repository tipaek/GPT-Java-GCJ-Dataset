import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int rowCount = countDuplicateRows(matrix, n);
            int colCount = countDuplicateCols(matrix, n);

            System.out.println("Case #" + t + ": " + trace + " " + rowCount + " " + colCount);
        }

        scanner.close();
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

    private static int countDuplicateCols(int[][] matrix, int n) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            int[] col = new int[n];
            for (int j = 0; j < n; j++) {
                col[j] = matrix[j][i];
            }
            if (hasDuplicates(col)) {
                count++;
            }
        }

        return count;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}