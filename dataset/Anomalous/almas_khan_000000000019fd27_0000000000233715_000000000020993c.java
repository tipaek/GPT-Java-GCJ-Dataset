import java.util.Scanner;

class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, n);
            int rowCount = calculateDuplicateRows(matrix, n);
            int colCount = calculateDuplicateCols(matrix, n);

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowCount + " " + colCount);
        }
    }

    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int calculateDuplicateRows(int[][] matrix, int n) {
        int rowCount = 0;
        for (int i = 0; i < n; i++) {
            if (hasDuplicates(matrix[i])) {
                rowCount++;
            }
        }
        return rowCount;
    }

    private static int calculateDuplicateCols(int[][] matrix, int n) {
        int colCount = 0;
        for (int i = 0; i < n; i++) {
            int[] col = new int[n];
            for (int j = 0; j < n; j++) {
                col[j] = matrix[j][i];
            }
            if (hasDuplicates(col)) {
                colCount++;
            }
        }
        return colCount;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}