import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scan.nextInt();

        for (int k = 1; k <= t; k++) {
            int n = scan.nextInt();
            int[][] arr = new int[n][n];
            int sum = 0, countRow = 0, countCol = 0;

            // Read matrix and calculate the sum of the diagonal
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scan.nextInt();
                    if (i == j) {
                        sum += arr[i][j];
                    }
                }
            }

            // Check rows for duplicates
            for (int i = 0; i < n; i++) {
                if (!hasAllDistinctElements(arr[i])) {
                    countRow++;
                }
            }

            // Check columns for duplicates
            for (int j = 0; j < n; j++) {
                int[] column = new int[n];
                for (int i = 0; i < n; i++) {
                    column[i] = arr[i][j];
                }
                if (!hasAllDistinctElements(column)) {
                    countCol++;
                }
            }

            System.out.println("Case #" + k + ": " + sum + " " + countRow + " " + countCol);
        }
    }

    // Utility method to check if all elements in an array are distinct
    public static boolean hasAllDistinctElements(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return false;
            }
        }
        return true;
    }
}