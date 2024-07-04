import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= testCases; ++t) {
            int N = Integer.parseInt(scanner.nextLine());
            long diagonalSum = 0;
            int rowDuplicates = 0, colDuplicates = 0;

            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; ++i) {
                String[] input = scanner.nextLine().split(" ");
                for (int j = 0; j < N; ++j) {
                    matrix[i][j] = Integer.parseInt(input[j]);
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            for (int i = 0; i < N; ++i) {
                if (hasDuplicates(matrix[i])) {
                    rowDuplicates++;
                }
            }

            for (int j = 0; j < N; ++j) {
                if (hasDuplicates(getColumn(matrix, j))) {
                    colDuplicates++;
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", t, diagonalSum, rowDuplicates, colDuplicates);
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