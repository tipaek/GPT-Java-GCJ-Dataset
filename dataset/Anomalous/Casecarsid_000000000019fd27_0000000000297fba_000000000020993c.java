import java.util.HashSet;
import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = sc.nextInt();
                }
            }

            int[] result = analyzeMatrix(matrix);
            System.out.printf("Case #%d: %d %d %d%n", i, result[0], result[1], result[2]);
        }
    }

    public static int[] analyzeMatrix(int[][] matrix) {
        int N = matrix.length;
        int trace = 0;
        int rowRepeats = 0;
        int colRepeats = 0;

        for (int i = 0; i < N; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> colSet = new HashSet<>();

            for (int j = 0; j < N; j++) {
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);

                if (i == j) {
                    trace += matrix[i][j];
                }
            }

            if (rowSet.size() != N) {
                rowRepeats++;
            }
            if (colSet.size() != N) {
                colRepeats++;
            }
        }

        return new int[]{trace, rowRepeats, colRepeats};
    }
}