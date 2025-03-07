import java.util.Scanner;

public class Solution {

    private int N;
    private int[][] matrix;

    private int[] calculateTraceAndDuplicates() {
        int trace = 0, duplicateRows = 0, duplicateCols = 0;
        int[] result = new int[3];

        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];

            // Check for duplicate rows
            if (hasDuplicates(matrix[i])) {
                duplicateRows++;
            }

            // Check for duplicate columns
            if (hasDuplicates(getColumn(matrix, i))) {
                duplicateCols++;
            }
        }

        result[0] = trace;
        result[1] = duplicateRows;
        result[2] = duplicateCols;

        return result;
    }

    private boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }

    private int[] getColumn(int[][] matrix, int columnIndex) {
        int[] column = new int[N];
        for (int i = 0; i < N; i++) {
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            Solution solution = new Solution();
            solution.N = scanner.nextInt();
            solution.matrix = new int[solution.N][solution.N];

            // Input matrix
            for (int i = 0; i < solution.N; i++) {
                for (int j = 0; j < solution.N; j++) {
                    solution.matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate and output result
            int[] result = solution.calculateTraceAndDuplicates();
            System.out.println("Case #" + t + ": " + result[0] + " " + result[1] + " " + result[2]);
        }

        scanner.close();
    }
}