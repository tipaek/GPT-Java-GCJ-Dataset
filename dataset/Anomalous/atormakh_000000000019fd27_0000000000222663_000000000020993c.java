import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testSetSize = in.nextInt();
        for (int i = 1; i <= testSetSize; ++i) {
            int sizeOfMatrix = in.nextInt();
            int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
            for (int j = 0; j < sizeOfMatrix; j++) {
                for (int k = 0; k < sizeOfMatrix; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }
            String answer = solve(sizeOfMatrix, matrix);
            System.out.println("Case #" + i + ": " + answer);
        }
    }

    public static String solve(int sizeOfMatrix, int[][] matrix) {
        int faultyRows = 0, faultyColumns = 0, trace = 0;

        // Check for faulty rows
        for (int i = 0; i < sizeOfMatrix; i++) {
            if (hasDuplicates(matrix[i])) {
                faultyRows++;
            }
        }

        // Check for faulty columns
        for (int i = 0; i < sizeOfMatrix; i++) {
            int[] column = new int[sizeOfMatrix];
            for (int j = 0; j < sizeOfMatrix; j++) {
                column[j] = matrix[j][i];
            }
            if (hasDuplicates(column)) {
                faultyColumns++;
            }
        }

        // Calculate trace
        for (int i = 0; i < sizeOfMatrix; i++) {
            trace += matrix[i][i];
        }

        return trace + " " + faultyRows + " " + faultyColumns;
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
}