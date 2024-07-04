import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int j = 1; j <= t; j++) {
            int N = in.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0, rowCount = 0, colCount = 0;

            // Read matrix
            for (int i = 0; i < N; i++) {
                for (int k = 0; k < N; k++) {
                    matrix[i][k] = in.nextInt();
                }
            }

            // Calculate trace and rowCount
            for (int i = 0; i < N; i++) {
                trace += matrix[i][i];
                if (hasDuplicate(matrix[i])) {
                    rowCount++;
                }
            }

            // Calculate colCount
            for (int k = 0; k < N; k++) {
                int[] colArray = new int[N];
                for (int l = 0; l < N; l++) {
                    colArray[l] = matrix[l][k];
                }
                if (hasDuplicate(colArray)) {
                    colCount++;
                }
            }

            System.out.println("Case #" + j + ": " + trace + " " + rowCount + " " + colCount);
        }
    }

    private static boolean hasDuplicate(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int num : array) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }
}