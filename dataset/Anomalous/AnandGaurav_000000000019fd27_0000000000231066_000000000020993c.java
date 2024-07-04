import java.io.*;
import java.util.*;

public class Solution {
    public static int[] computeDuplicates(int size, int[][] matrix) {
        int rowDuplicates = 0;
        int colDuplicates = 0;

        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    rowDuplicates++;
                    break;
                }
            }
        }

        for (int j = 0; j < size; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < size; i++) {
                if (!colSet.add(matrix[i][j])) {
                    colDuplicates++;
                    break;
                }
            }
        }

        return new int[]{rowDuplicates, colDuplicates};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTests = scanner.nextInt();

        for (int testNum = 0; testNum < numTests; testNum++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int diagonalSum = 0;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            int[] duplicates = computeDuplicates(size, matrix);

            System.out.println("Case #" + (testNum + 1) + ": " + diagonalSum + " " + duplicates[0] + " " + duplicates[1]);
        }

        scanner.close();
    }
}