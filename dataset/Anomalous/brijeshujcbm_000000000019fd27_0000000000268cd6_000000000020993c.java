import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int m = 0; m < t; m++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // Calculate trace
            for (int i = 0; i < n; i++) {
                trace += arr[i][i];
            }

            // Check for row repeats
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(arr[i])) {
                    rowRepeats++;
                }
            }

            // Check for column repeats
            for (int j = 0; j < n; j++) {
                int[] column = new int[n];
                for (int i = 0; i < n; i++) {
                    column[i] = arr[i][j];
                }
                if (hasDuplicates(column)) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + (m + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        
        sc.close();
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int num : array) {
            if (seen[num]) {
                return true;
            }
            seen[num] = true;
        }
        return false;
    }
}