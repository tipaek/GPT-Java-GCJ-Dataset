import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int size = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[size][size];
            int trace = 0, duplicateRows = 0, duplicateCols = 0;

            for (int i = 0; i < size; i++) {
                String[] values = scanner.nextLine().split(" ");
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(values[j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            for (int i = 0; i < size; i++) {
                if (hasDuplicates(matrix[i])) {
                    duplicateRows++;
                }
            }

            for (int j = 0; j < size; j++) {
                if (hasDuplicates(getColumn(matrix, j))) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
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

    private static int[] getColumn(int[][] matrix, int columnIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }
}