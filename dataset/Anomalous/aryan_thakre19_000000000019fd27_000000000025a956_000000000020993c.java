import java.util.Scanner;

public class Main {

    public static boolean contains(int[] array, int element) {
        for (int value : array) {
            if (value == element) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int t = 1; t <= testCaseCount; t++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int diagonalSum = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            // The code block below is commented out as it is incomplete and not used.
            /*
            int r = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!contains(row, matrix[i][j])) {
                        // Do something
                    }
                }
            }
            */

            System.out.println("Case #" + t + ": " + diagonalSum);
        }

        scanner.close();
    }
}