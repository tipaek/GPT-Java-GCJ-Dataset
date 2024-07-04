import java.util.Scanner;

public class Main {

    public static boolean check(int[] arr, int element) {
        for (int value : arr) {
            if (value == element) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
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

            // Uncomment and complete the following code if needed
            /*
            int[] row = new int[N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!check(row, matrix[i][j])) {
                        // Add your logic here
                    }
                }
            }
            */

            System.out.println("Case #" + caseNumber + ": " + diagonalSum);
            caseNumber++;
        }

        scanner.close();
    }
}