import java.util.*;
import java.io.*;

/*
Andres Arrieche
SDE @ AWS
https://www.linkedin.com/in/andresarrieche/
*/

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = in.nextInt();
        for (int test = 1; test <= testCount; test++) {
            int n = in.nextInt();

            int [][]matrix = new int[n][];
            for (int i = 0; i < n; i++) {
                matrix[i] = new int[n];
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", test, sumDiagonal(matrix), duplicateRows(matrix), duplicateColumns(matrix));
        }
    }

    private static int duplicateColumns(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> values = new HashSet<>();
            boolean hasDuplicates = false;
            for (int j = 0; j < matrix.length; j++) {
                hasDuplicates = hasDuplicates || values.contains(matrix[j][i]);
                values.add(matrix[j][i]);
            }
            if (hasDuplicates) {
                count++;
            }
        }
        return count;
    }

    private static int duplicateRows(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> values = new HashSet<>();
            boolean hasDuplicates = false;
            for (int j = 0; j < matrix.length; j++) {
                hasDuplicates = hasDuplicates || values.contains(matrix[i][j]);
                values.add(matrix[i][j]);
            }
            if (hasDuplicates) {
                count++;
            }
        }
        return count;
    }

    private static int sumDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
}