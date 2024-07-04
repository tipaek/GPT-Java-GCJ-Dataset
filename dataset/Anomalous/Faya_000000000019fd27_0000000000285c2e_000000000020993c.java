import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testAmt = scanner.nextInt();
        scanner.nextLine();
        
        String[] results = new String[testAmt];

        for (int i = 0; i < testAmt; i++) {
            int N = scanner.nextInt();
            scanner.nextLine();

            int[][] matrix = new int[N][N];
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
                scanner.nextLine();
            }

            results[i] = analyzeMatrix(matrix, i + 1, N);
        }
        
        scanner.close();

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static String analyzeMatrix(int[][] matrix, int testcaseNo, int N) {
        int trace = 0;
        int rowCount = 0;

        for (int row = 0; row < N; row++) {
            Set<Integer> seenRow = new HashSet<>();
            boolean hasRowDup = false;

            for (int col = 0; col < N; col++) {
                int value = matrix[row][col];

                if (row == col) {
                    trace += value;
                }

                if (!seenRow.add(value)) {
                    hasRowDup = true;
                }
            }

            if (hasRowDup) {
                rowCount++;
            }
        }

        int colCount = countDuplicateColumns(matrix);
        return String.format("Case #%d: %d %d %d", testcaseNo, trace, rowCount, colCount);
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int count = 0;
        int N = matrix.length;

        for (int col = 0; col < N; col++) {
            Set<Integer> seenCol = new HashSet<>();
            boolean hasColDup = false;

            for (int row = 0; row < N; row++) {
                int value = matrix[row][col];

                if (!seenCol.add(value)) {
                    hasColDup = true;
                }
            }

            if (hasColDup) {
                count++;
            }
        }

        return count;
    }
}