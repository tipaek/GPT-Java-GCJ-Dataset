import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        runCodeJam();
    }

    public static void runCodeJam() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < testCases; i++) {
            int size = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[size][size];

            for (int j = 0; j < size; j++) {
                String[] line = scanner.nextLine().split(" ");
                for (int k = 0; k < size; k++) {
                    matrix[j][k] = Integer.parseInt(line[k]);
                }
            }

            processMatrix(matrix, i + 1);
        }

        scanner.close();
    }

    private static void processMatrix(int[][] matrix, int caseNumber) {
        int[] results = findDuplicates(matrix);
        System.out.println("Case #" + caseNumber + ": " + calculateTrace(matrix) + " " + results[0] + " " + results[1]);
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int[] findDuplicates(int[][] matrix) {
        int duplicateRows = 0;
        int duplicateColumns = 0;

        for (int i = 0; i < matrix.length; i++) {
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

        return new int[]{duplicateRows, duplicateColumns};
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