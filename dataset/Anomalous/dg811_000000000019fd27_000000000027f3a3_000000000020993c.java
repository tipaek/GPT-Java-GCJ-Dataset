import java.util.Scanner;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int z = 0; z < t; z++) {
            int n = sc.nextInt();
            int sum = 0, rmax = 0, cmax = 0;
            int[][] arr = new int[n][n];
            int[] count = new int[n];

            // Read matrix and check for duplicate values in rows
            for (int i = 0; i < n; i++) {
                boolean rowHasDuplicate = false;
                Arrays.fill(count, 0);
                for (int j = 0; j < n; j++) {
                    int value = sc.nextInt();
                    arr[i][j] = value;
                    if (count[value - 1] != 0) {
                        rowHasDuplicate = true;
                    }
                    count[value - 1]++;
                }
                if (rowHasDuplicate) {
                    rmax++;
                }
            }

            // Check for duplicate values in columns
            for (int j = 0; j < n; j++) {
                boolean colHasDuplicate = false;
                Arrays.fill(count, 0);
                for (int i = 0; i < n; i++) {
                    int value = arr[i][j];
                    if (count[value - 1] != 0) {
                        colHasDuplicate = true;
                    }
                    count[value - 1]++;
                }
                if (colHasDuplicate) {
                    cmax++;
                }
            }

            // Calculate the sum of the main diagonal
            for (int i = 0; i < n; i++) {
                sum += arr[i][i];
            }

            System.out.println("Case #" + (z + 1) + ": " + sum + " " + rmax + " " + cmax);
        }
    }
}