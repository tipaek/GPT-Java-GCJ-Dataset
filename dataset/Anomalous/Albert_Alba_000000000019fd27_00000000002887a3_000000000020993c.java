import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            System.out.print("Case #" + testCase + ": ");

            int diagonalSum = 0;
            for (int i = 0; i < size; i++) {
                diagonalSum += matrix[i][i];
            }
            System.out.print(diagonalSum + " ");

            int duplicateRows = 0;
            for (int i = 0; i < size; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() != size) {
                    duplicateRows++;
                }
            }
            System.out.print(duplicateRows + " ");

            int duplicateColumns = 0;
            for (int j = 0; j < size; j++) {
                HashSet<Integer> columnSet = new HashSet<>();
                for (int i = 0; i < size; i++) {
                    columnSet.add(matrix[i][j]);
                }
                if (columnSet.size() != size) {
                    duplicateColumns++;
                }
            }
            System.out.print(duplicateColumns);

            if (testCase < testCases) {
                System.out.println();
            }
        }

        scanner.close();
    }
}