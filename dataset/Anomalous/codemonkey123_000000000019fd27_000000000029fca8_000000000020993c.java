import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int z = 1; z <= T; z++) {
            int size = sc.nextInt();
            int[][] mat = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }

            int k = calculateTrace(mat, size);
            int r = countRowDuplicates(mat, size);
            int c = countColDuplicates(mat, size);

            System.out.println("Case #" + z + ": " + k + " " + r + " " + c);
        }
    }

    public static int calculateTrace(int[][] matrix, int size) {
        int traceSum = 0;
        for (int i = 0; i < size; i++) {
            traceSum += matrix[i][i];
        }
        return traceSum;
    }

    public static int countRowDuplicates(int[][] matrix, int size) {
        int duplicateRows = 0;
        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix[i])) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    public static int countColDuplicates(int[][] matrix, int size) {
        int duplicateCols = 0;
        for (int i = 0; i < size; i++) {
            int[] col = new int[size];
            for (int j = 0; j < size; j++) {
                col[j] = matrix[j][i];
            }
            if (hasDuplicates(col)) {
                duplicateCols++;
            }
        }
        return duplicateCols;
    }

    public static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }
}