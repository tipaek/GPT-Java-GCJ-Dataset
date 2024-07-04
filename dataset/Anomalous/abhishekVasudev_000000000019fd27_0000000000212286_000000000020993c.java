import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            int[] results = calculateResults(size, matrix);
            System.out.println("Case #" + testCase + ": " + results[0] + " " + results[1] + " " + results[2]);
        }
    }

    public static int[] calculateResults(int size, int[][] matrix) {
        int diagonalSum = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;

        for (int i = 0; i < size; i++) {
            diagonalSum += matrix[i][i];
        }

        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix[i])) {
                duplicateRows++;
            }
        }

        for (int i = 0; i < size; i++) {
            int[] column = new int[size];
            for (int j = 0; j < size; j++) {
                column[j] = matrix[j][i];
            }
            if (hasDuplicates(column)) {
                duplicateCols++;
            }
        }

        return new int[] {diagonalSum, duplicateRows, duplicateCols};
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
}