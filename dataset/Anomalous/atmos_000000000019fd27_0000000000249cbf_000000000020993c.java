import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int testCaseCount = scan.nextInt();

        while (testCaseCount > 0) {
            System.out.print("Enter the size of the matrix: ");
            int size = scan.nextInt();
            int[][] matrix = new int[size][size];

            System.out.println("Enter matrix values:");
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scan.nextInt();
                }
            }

            System.out.println("Case #" + testCaseCount + ":");
            System.out.println("\tTrace of matrix: " + calculateTrace(matrix));
            System.out.println("\tRow repeats: " + countRowDuplicates(matrix));
            System.out.println("\tColumn repeats: " + countColumnDuplicates(matrix));

            testCaseCount--;
        }

        scan.close();
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(int[][] matrix) {
        int duplicateCount = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }

    private static int countColumnDuplicates(int[][] matrix) {
        int duplicateCount = 0;
        int size = matrix.length;
        for (int col = 0; col < size; col++) {
            int[] column = new int[size];
            for (int row = 0; row < size; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                duplicateCount++;
            }
        }
        return duplicateCount;
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