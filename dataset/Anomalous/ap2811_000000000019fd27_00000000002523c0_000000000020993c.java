import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        
        for (int o = 1; o <= t; o++) {
            int n = sc.nextInt();
            int[][] mat = new int[n][n];
            int sum = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            // Reading the matrix and calculating the sum of the diagonal
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = sc.nextInt();
                    if (i == j) {
                        sum += mat[i][j];
                    }
                }
            }

            // Checking for duplicate elements in rows and columns
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(mat[i])) {
                    duplicateRows++;
                }
                
                int[] col = new int[n];
                for (int j = 0; j < n; j++) {
                    col[j] = mat[j][i];
                }
                if (hasDuplicates(col)) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + o + ": " + sum + " " + duplicateRows + " " + duplicateCols);
        }
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