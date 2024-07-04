import java.util.Scanner;

public class First {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int[] rowDuplicates = new int[T + 1];
        int[] colDuplicates = new int[T + 1];
        int[] trace = new int[T + 1];

        for (int i = 1; i <= T; i++) {
            int N = input.nextInt();
            int[][] matrix = new int[N][N];

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = input.nextInt();
                }
            }

            // Check row duplicates and calculate trace
            for (int row = 0; row < N; row++) {
                boolean[] seen = new boolean[N + 1];
                for (int col = 0; col < N; col++) {
                    if (row == col) {
                        trace[i] += matrix[row][col];
                    }
                    if (seen[matrix[row][col]]) {
                        rowDuplicates[i]++;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
            }

            // Check column duplicates
            for (int col = 0; col < N; col++) {
                boolean[] seen = new boolean[N + 1];
                for (int row = 0; row < N; row++) {
                    if (seen[matrix[row][col]]) {
                        colDuplicates[i]++;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
            }
        }

        for (int i = 1; i <= T; i++) {
            System.out.printf("Case #%d: %d %d %d%n", i, trace[i], rowDuplicates[i], colDuplicates[i]);
        }
    }
}