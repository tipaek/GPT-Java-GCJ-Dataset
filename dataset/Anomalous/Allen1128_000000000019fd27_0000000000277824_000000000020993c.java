import java.util.Scanner;

public class Vestigium {
    public static String solve(int[][] matrix) {
        int trace = 0, N = matrix.length;
        int rowRepeats = 0, colRepeats = 0;

        for (int i = 0; i < N; i++) {
            boolean[] rowCheck = new boolean[N + 1];
            boolean[] colCheck = new boolean[N + 1];
            boolean rowHasRepeat = false;
            boolean colHasRepeat = false;

            for (int j = 0; j < N; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }

                if (rowCheck[matrix[i][j]]) {
                    rowHasRepeat = true;
                }
                if (colCheck[matrix[j][i]]) {
                    colHasRepeat = true;
                }

                rowCheck[matrix[i][j]] = true;
                colCheck[matrix[j][i]] = true;
            }

            if (rowHasRepeat) rowRepeats++;
            if (colHasRepeat) colRepeats++;
        }

        return trace + " " + rowRepeats + " " + colRepeats;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N * N; i++) {
                int row = i / N;
                int col = i % N;
                matrix[row][col] = scanner.nextInt();
            }

            System.out.println("Case #" + t + ": " + solve(matrix));
        }

        scanner.close();
    }
}