import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        codeJam();
    }

    public static void codeJam() throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
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
        }
    }

    private static void processMatrix(int[][] matrix, int caseNumber) {
        System.out.println("Case #" + caseNumber + ": " + calculateDiagonalSum(matrix) + " " + countDuplicateRows(matrix) + " " + countDuplicateColumns(matrix));
    }

    private static int calculateDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int duplicateCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (hasDuplicates(matrix[i])) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicateCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] column = new int[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                column[j] = matrix[j][i];
            }
            if (hasDuplicates(column)) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }

    private static boolean hasDuplicates(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}