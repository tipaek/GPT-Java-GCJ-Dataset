import java.util.Scanner;

class Vestigium {
    public static int countDuplicateRows(int[][] matrix) {
        int duplicateRowCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] count = new int[matrix.length + 1];
            Arrays.fill(count, 0);
            for (int j = 0; j < matrix.length; j++) {
                if (count[matrix[i][j]] == 1) {
                    duplicateRowCount++;
                    break;
                } else {
                    count[matrix[i][j]] = 1;
                }
            }
        }
        return duplicateRowCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int trace = 0;
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
                trace += matrix[i][i];
            }
            int duplicateRows = countDuplicateRows(matrix);
            int[][] transposedMatrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    transposedMatrix[i][j] = matrix[j][i];
                }
            }
            int duplicateColumns = countDuplicateRows(transposedMatrix);
            System.out.println(trace + " " + duplicateRows + " " + duplicateColumns);
        }
        scanner.close();
    }
}