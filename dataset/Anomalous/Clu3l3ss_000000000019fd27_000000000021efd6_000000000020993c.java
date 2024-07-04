import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        // Read input using BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] matrix = new int[N][N];

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.print("Case #" + (i + 1) + ": ");
            solve(N, matrix);
        }
    }

    // Method to process each input case
    public static void solve(int N, int[][] matrix) {
        int diagonalSum = calculateDiagonalSum(N, matrix);
        int rowDuplicates = countRowDuplicates(N, matrix);
        int columnDuplicates = countColumnDuplicates(N, matrix);

        System.out.println(diagonalSum + " " + rowDuplicates + " " + columnDuplicates);
    }

    // Calculate the sum of the main diagonal
    private static int calculateDiagonalSum(int N, int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    // Count rows with duplicates
    private static int countRowDuplicates(int N, int[][] matrix) {
        int rowDuplicateCount = 0;
        for (int i = 0; i < N; i++) {
            if (hasDuplicates(matrix[i])) {
                rowDuplicateCount++;
            }
        }
        return rowDuplicateCount;
    }

    // Count columns with duplicates
    private static int countColumnDuplicates(int N, int[][] matrix) {
        int columnDuplicateCount = 0;
        for (int i = 0; i < N; i++) {
            int[] column = new int[N];
            for (int j = 0; j < N; j++) {
                column[j] = matrix[j][i];
            }
            if (hasDuplicates(column)) {
                columnDuplicateCount++;
            }
        }
        return columnDuplicateCount;
    }

    // Check if an array has duplicates
    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length];
        for (int value : array) {
            if (seen[value - 1]) {
                return true;
            }
            seen[value - 1] = true;
        }
        return false;
    }
}