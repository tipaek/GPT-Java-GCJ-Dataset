import java.util.Scanner;

class Solution {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int x = 1; x <= T; x++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int traceValue = calculateTrace(matrix, N);
            int rowCount = countDuplicateRows(matrix, N);
            int colCount = countDuplicateCols(matrix, N);

            System.out.printf("Case #%d: %d %d %d%n", x, traceValue, rowCount, colCount);
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRowCount = 0;

        for (int i = 0; i < size; i++) {
            Set<Integer> seen = new HashSet<>();
            boolean hasDuplicate = false;

            for (int j = 0; j < size; j++) {
                if (!seen.add(matrix[i][j])) {
                    duplicateRowCount++;
                    hasDuplicate = true;
                    break;
                }
            }

            if (hasDuplicate) {
                continue;
            }
        }

        return duplicateRowCount;
    }

    private static int countDuplicateCols(int[][] matrix, int size) {
        int duplicateColCount = 0;

        for (int i = 0; i < size; i++) {
            Set<Integer> seen = new HashSet<>();
            boolean hasDuplicate = false;

            for (int j = 0; j < size; j++) {
                if (!seen.add(matrix[j][i])) {
                    duplicateColCount++;
                    hasDuplicate = true;
                    break;
                }
            }

            if (hasDuplicate) {
                continue;
            }
        }

        return duplicateColCount;
    }
}