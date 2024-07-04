import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int caseCount = input.nextInt();
        int[][] results = new int[caseCount][4];

        for (int n = 0; n < caseCount; n++) {
            int N = input.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = input.nextInt();
                }
            }

            for (int i = 0; i < N; i++) {
                trace += matrix[i][i];
            }

            int rowDuplicates = 0;
            int colDuplicates = 0;

            for (int i = 0; i < N; i++) {
                rowDuplicates += hasDuplicates(matrix[i]);
                colDuplicates += hasColDuplicates(matrix, i);
            }

            results[n][0] = n + 1;
            results[n][1] = trace;
            results[n][2] = rowDuplicates;
            results[n][3] = colDuplicates;
        }

        for (int n = 0; n < caseCount; n++) {
            System.out.println("Case #" + results[n][0] + ": " + results[n][1] + " " + results[n][2] + " " + results[n][3]);
        }
    }

    private static int hasDuplicates(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return 1;
                }
            }
        }
        return 0;
    }

    private static int hasColDuplicates(int[][] matrix, int colIndex) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                if (matrix[i][colIndex] == matrix[j][colIndex]) {
                    return 1;
                }
            }
        }
        return 0;
    }
}