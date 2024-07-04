import java.util.*;

public class Solution {
    static int N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            N = scanner.nextInt();
            int[][] matrix = new int[N][N];

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            System.out.println("Case #" + caseNumber + ": ");
            analyzeMatrix(matrix);
        }
    }

    static void analyzeMatrix(int[][] matrix) {
        int trace = 0;
        int duplicateRows = 0;
        int duplicateColumns = 0;

        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
            if (hasDuplicates(matrix[i])) {
                duplicateRows++;
            }
            if (hasDuplicates(getColumn(matrix, i))) {
                duplicateColumns++;
            }
        }

        System.out.println(trace + " " + duplicateRows + " " + duplicateColumns);
    }

    static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }

    static int[] getColumn(int[][] matrix, int columnIndex) {
        int[] column = new int[N];
        for (int row = 0; row < N; row++) {
            column[row] = matrix[row][columnIndex];
        }
        return column;
    }
}