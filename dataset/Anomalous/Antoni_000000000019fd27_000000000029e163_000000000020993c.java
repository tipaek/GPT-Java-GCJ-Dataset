import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        codeJam();
    }

    private static void codeJam() {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < cases; i++) {
            int size = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[size][size];

            for (int j = 0; j < size; j++) {
                String[] line = scanner.nextLine().split(" ");
                for (int k = 0; k < size; k++) {
                    matrix[j][k] = Integer.parseInt(line[k]);
                }
            }

            processMatrix(matrix, i + 1);
            System.out.print("\n");
        }
        scanner.close();
    }

    private static void processMatrix(int[][] matrix, int caseNumber) {
        int[] results = analyzeMatrix(matrix);
        System.out.print("Case #" + caseNumber + ": " + results[0] + " " + results[1] + " " + results[2]);
    }

    private static int[] analyzeMatrix(int[][] matrix) {
        int trace = 0;
        int duplicateRows = 0;
        int duplicateColumns = 0;

        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];

            if (hasDuplicates(matrix[i])) {
                duplicateRows++;
            }

            int[] column = new int[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                column[j] = matrix[j][i];
            }

            if (hasDuplicates(column)) {
                duplicateColumns++;
            }
        }

        return new int[]{trace, duplicateRows, duplicateColumns};
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}