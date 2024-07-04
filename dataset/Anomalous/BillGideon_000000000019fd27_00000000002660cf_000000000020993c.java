import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {

    // Checks if a row has repeated numbers
    static boolean hasRowRepeated(int[][] matrix, int row) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int num : matrix[row]) {
            if (!uniqueNumbers.add(num)) {
                return true;
            }
        }
        return false;
    }

    // Checks if a column has repeated numbers
    static boolean hasColRepeated(int[][] matrix, int col, int size) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int i = 0; i < size; i++) {
            if (!uniqueNumbers.add(matrix[i][col])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfCases = scan.nextInt();

        for (int caseNum = 1; caseNum <= numberOfCases; caseNum++) {
            int size = scan.nextInt();
            int[][] matrix = new int[size][size];

            int trace = 0;
            int rowRepeatCount = 0;
            int colRepeatCount = 0;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scan.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            for (int i = 0; i < size; i++) {
                if (hasRowRepeated(matrix, i)) {
                    rowRepeatCount++;
                }
            }

            for (int j = 0; j < size; j++) {
                if (hasColRepeated(matrix, j, size)) {
                    colRepeatCount++;
                }
            }

            System.out.format("Case #%d: %d %d %d\n", caseNum, trace, rowRepeatCount, colRepeatCount);
        }

        scan.close();
    }
}