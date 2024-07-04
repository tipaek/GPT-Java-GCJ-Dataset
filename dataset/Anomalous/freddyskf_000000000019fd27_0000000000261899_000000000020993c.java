import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            scanner.nextLine();  // Consume the remaining line

            for (int i = 0; i < size; i++) {
                String[] rowValues = scanner.nextLine().split(" ");
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(rowValues[j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            for (int i = 0; i < size; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowDuplicates++;
                }
                if (hasDuplicates(getColumn(matrix, i))) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
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