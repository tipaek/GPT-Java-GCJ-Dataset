import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter the number of test cases: ");
        int testCase = scan.nextInt();
        
        System.out.print("Enter the size of matrix: ");
        int size = scan.nextInt();
        
        int[][] matrix = new int[size][size];

        for (int t = 1; t <= testCase; t++) {
            System.out.println("Enter values for matrix:");
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scan.nextInt();
                }
            }

            System.out.println("Case #" + t);
            System.out.println("\tTrace of matrix: " + calculateTrace(matrix));
            System.out.println("\tRows with duplicates: " + countDuplicateRows(matrix));
            System.out.println("\tColumns with duplicates: " + countDuplicateColumns(matrix));
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

    private static int countDuplicateRows(int[][] matrix) {
        int duplicateRowCount = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                duplicateRowCount++;
            }
        }
        return duplicateRowCount;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicateColumnCount = 0;
        int size = matrix.length;
        for (int col = 0; col < size; col++) {
            int[] column = new int[size];
            for (int row = 0; row < size; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                duplicateColumnCount++;
            }
        }
        return duplicateColumnCount;
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