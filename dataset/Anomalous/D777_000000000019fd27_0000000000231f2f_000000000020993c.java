import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= t; ++i) {
            int size = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[size][size];
            int trace = 0, duplicateRows = 0, duplicateColumns = 0;

            for (int row = 0; row < size; row++) {
                String[] rowData = scanner.nextLine().split(" ");
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = Integer.parseInt(rowData[col]);
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            for (int row = 0; row < size; row++) {
                if (hasDuplicates(matrix[row])) {
                    duplicateRows++;
                }
            }

            for (int col = 0; col < size; col++) {
                if (hasDuplicates(getColumn(matrix, col))) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int col) {
        int[] column = new int[matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            column[row] = matrix[row][col];
        }
        return column;
    }
}