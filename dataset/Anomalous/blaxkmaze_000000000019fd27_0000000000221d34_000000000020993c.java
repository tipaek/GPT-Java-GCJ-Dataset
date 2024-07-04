import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static int[] calculateVestigium(int[][] matrix, int N) {
        int[] result = new int[3];

        if (matrix == null || N == 0) return result;

        for (int i = 0; i < N; i++) {
            result[0] += matrix[i][i];

            boolean[] rowCheck = new boolean[N + 1];
            boolean[] colCheck = new boolean[N + 1];
            boolean rowDuplicate = false;
            boolean colDuplicate = false;

            for (int j = 0; j < N; j++) {
                if (!rowDuplicate && rowCheck[matrix[i][j]]) {
                    result[1]++;
                    rowDuplicate = true;
                }
                if (!colDuplicate && colCheck[matrix[j][i]]) {
                    result[2]++;
                    colDuplicate = true;
                }
                rowCheck[matrix[i][j]] = true;
                colCheck[matrix[j][i]] = true;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int[] result = calculateVestigium(matrix, N);
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, result[0], result[1], result[2]);
        }

        scanner.close();
    }
}