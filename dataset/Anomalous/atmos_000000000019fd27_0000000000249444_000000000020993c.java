import java.util.Scanner;

public class Run {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number of test cases: ");
        int testCase = scan.nextInt();

        System.out.print("Enter the size of the matrix: ");
        int size = scan.nextInt();

        int[][] matrix = new int[size][size];

        for (int caseNum = 1; caseNum <= testCase; caseNum++) {
            System.out.println("Enter values for test case #" + caseNum + ":");
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scan.nextInt();
                }
            }

            System.out.println("Case #" + caseNum);
            System.out.println("Trace of matrix: " + calculateTrace(matrix));
            System.out.println("Row duplicates: " + countRowDuplicates(matrix));
            System.out.println("Column duplicates: " + countColumnDuplicates(matrix));
        }
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
        boolean[] seen = new boolean[array.length];
        for (int value : array) {
            if (seen[value - 1]) {
                return true;
            }
            seen[value - 1] = true;
        }
        return false;
    }
}