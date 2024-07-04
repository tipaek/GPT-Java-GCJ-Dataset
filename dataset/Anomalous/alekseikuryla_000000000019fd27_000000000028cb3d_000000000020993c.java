import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int N = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] row = scanner.nextLine().split(" ");
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }

            int trace = calculateTrace(matrix, N);
            int rowCount = countInvalidRows(matrix, N);
            int colCount = countInvalidColumns(matrix, N);

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowCount + " " + colCount);
        }
    }

    private static int calculateTrace(int[][] matrix, int N) {
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countInvalidRows(int[][] matrix, int N) {
        int rowCount = 0;
        for (int i = 0; i < N; i++) {
            boolean[] seen = new boolean[N];
            for (int j = 0; j < N; j++) {
                int value = matrix[i][j];
                if (value <= 0 || value > N || seen[value - 1]) {
                    rowCount++;
                    break;
                }
                seen[value - 1] = true;
            }
        }
        return rowCount;
    }

    private static int countInvalidColumns(int[][] matrix, int N) {
        int colCount = 0;
        for (int i = 0; i < N; i++) {
            boolean[] seen = new boolean[N];
            for (int j = 0; j < N; j++) {
                int value = matrix[j][i];
                if (value <= 0 || value > N || seen[value - 1]) {
                    colCount++;
                    break;
                }
                seen[value - 1] = true;
            }
        }
        return colCount;
    }
}