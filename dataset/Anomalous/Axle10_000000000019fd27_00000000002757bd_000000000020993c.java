import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();

        for (int x = 0; x < t; x++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    arr[i][j] = sc.nextInt();

            int sum = 0;
            for (int i = 0; i < n; i++)
                sum += arr[i][i];

            int countRow = 0, countCol = 0;

            for (int i = 0; i < n; i++) {
                if (hasDuplicate(arr[i])) {
                    countRow++;
                }
            }

            for (int j = 0; j < n; j++) {
                int[] col = new int[n];
                for (int i = 0; i < n; i++) {
                    col[i] = arr[i][j];
                }
                if (hasDuplicate(col)) {
                    countCol++;
                }
            }

            System.out.println("Case #" + (x + 1) + ": " + sum + " " + countRow + " " + countCol);
        }
    }

    private static boolean hasDuplicate(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}