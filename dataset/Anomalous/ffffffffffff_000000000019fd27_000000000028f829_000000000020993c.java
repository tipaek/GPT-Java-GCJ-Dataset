import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0;

            // Read matrix and calculate trace
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int rowDuplicates = countDuplicateRows(matrix, N);
            int colDuplicates = countDuplicateColumns(matrix, N);

            System.out.printf("Case #%d: %d %d %d%n", caseNum, trace, rowDuplicates, colDuplicates);
        }
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateCount = 0;
        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix[i])) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }

    private static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateCount = 0;
        for (int j = 0; j < size; j++) {
            int[] column = new int[size];
            for (int i = 0; i < size; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column)) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }
}