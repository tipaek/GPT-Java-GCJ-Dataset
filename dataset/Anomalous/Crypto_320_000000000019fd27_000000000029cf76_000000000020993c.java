import java.util.ArrayList;
import java.util.Scanner;

public class Test96 {

    public static void main(String[] args) {
        isLatinSquare();
    }

    private static void isLatinSquare() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> results = new ArrayList<>();

        System.out.println("Enter the number of test cases:");
        int testCases = scanner.nextInt();

        while (testCases > 0) {
            System.out.println("Enter the size of the matrix:");
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int diagonalSum = 0;
            int rowDuplicates = 0;

            for (int i = 0; i < size; i++) {
                System.out.println("Enter row " + (i + 1) + ":");
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
                if (hasDuplicates(matrix[i])) {
                    rowDuplicates++;
                }
            }

            int colDuplicates = countColDuplicates(matrix);
            results.add(diagonalSum);
            results.add(rowDuplicates);
            results.add(colDuplicates);

            testCases--;
        }

        for (int i = 0; i < results.size(); i += 3) {
            System.out.println("Case #" + (i / 3 + 1) + ": " + results.get(i) + " " + results.get(i + 1) + " " + results.get(i + 2));
        }

        scanner.close();
    }

    private static boolean hasDuplicates(int[] row) {
        for (int i = 0; i < row.length; i++) {
            for (int j = i + 1; j < row.length; j++) {
                if (row[i] == row[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int countColDuplicates(int[][] matrix) {
        int count = 0;
        for (int col = 0; col < matrix.length; col++) {
            int[] column = new int[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                count++;
            }
        }
        return count;
    }
}