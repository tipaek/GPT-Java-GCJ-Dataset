import java.util.Scanner;

public class Solution {

    static void indicium(int N, int K) {
        int[][] matrix = new int[N][N];
        boolean[][] rowUsed = new boolean[N][N];
        boolean[][] colUsed = new boolean[N][N];
        boolean isPossible = fillDiagonal(matrix, N, K, 0, rowUsed, colUsed);

        if (isPossible && fillRemaining(matrix, rowUsed, colUsed)) {
            System.out.println("POSSIBLE");
            for (int[] row : matrix) {
                for (int j = 0; j < N; j++) {
                    System.out.print(row[j]);
                    if (j != N - 1) System.out.print(" ");
                }
                System.out.println();
            }
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

    static boolean fillRemaining(int[][] matrix, boolean[][] rowUsed, boolean[][] colUsed) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j) continue; // Skip diagonals
                boolean filled = false;
                for (int x = 1; x <= matrix.length; x++) {
                    if (rowUsed[i][x - 1] || colUsed[x - 1][j]) continue;
                    matrix[i][j] = x;
                    rowUsed[i][x - 1] = true;
                    colUsed[x - 1][j] = true;
                    filled = true;
                    break;
                }
                if (!filled) return false;
            }
        }
        return true;
    }

    static boolean fillDiagonal(int[][] matrix, int N, int K, int index, boolean[][] rowUsed, boolean[][] colUsed) {
        if (index >= N) return K == 0;
        for (int i = 1; i <= N; i++) {
            matrix[index][index] = i;
            if (fillDiagonal(matrix, N, K - i, index + 1, rowUsed, colUsed)) {
                rowUsed[index][i - 1] = true;
                colUsed[i - 1][index] = true;
                return true;
            }
        }
        return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int tItr = 0; tItr < t; tItr++) {
            String[] input = scanner.nextLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);

            System.out.print("Case #" + (tItr + 1) + ": ");
            indicium(N, K);
        }

        scanner.close();
    }
}