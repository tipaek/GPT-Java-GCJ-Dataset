import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        processCodeJam();
    }

    public static void processCodeJam() {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < testCases; t++) {
            int size = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[size][size];

            for (int row = 0; row < size; row++) {
                String[] elements = scanner.nextLine().split(" ");
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = Integer.parseInt(elements[col]);
                }
            }
            analyzeMatrix(matrix, t + 1);
        }
        scanner.close();
    }

    private static void analyzeMatrix(int[][] matrix, int caseNumber) {
        int[] results = computeMatrixProperties(matrix);
        System.out.println("Case #" + caseNumber + ": " + results[0] + " " + results[1] + " " + results[2]);
    }

    private static int[] computeMatrixProperties(int[][] matrix) {
        int trace = 0;
        int rowDuplicates = 0;
        int colDuplicates = 0;

        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];

            boolean rowHasDuplicates = false;
            boolean colHasDuplicates = false;

            for (int j = 0; j < matrix.length; j++) {
                for (int k = j + 1; k < matrix.length; k++) {
                    if (matrix[i][j] == matrix[i][k]) {
                        rowHasDuplicates = true;
                    }
                    if (matrix[j][i] == matrix[k][i]) {
                        colHasDuplicates = true;
                    }
                }
            }

            if (rowHasDuplicates) rowDuplicates++;
            if (colHasDuplicates) colDuplicates++;
        }

        return new int[]{trace, rowDuplicates, colDuplicates};
    }
}