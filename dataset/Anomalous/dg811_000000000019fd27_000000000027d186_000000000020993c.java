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
            int[] arr2 = new int[100];

            // Reading matrix and checking for duplicate elements in rows
            for (int i = 0; i < n; i++) {
                boolean rowHasDuplicates = false;
                for (int j = 0; j < n; j++) {
                    int a = sc.nextInt();
                    arr[i][j] = a;
                    if (arr2[a - 1] != 0) {
                        rowHasDuplicates = true;
                    }
                    arr2[a - 1]++;
                }
                if (rowHasDuplicates) {
                    rmax++;
                }
                Arrays.fill(arr2, 0);
            }

            // Checking for duplicate elements in columns
            for (int j = 0; j < n; j++) {
                boolean colHasDuplicates = false;
                for (int i = 0; i < n; i++) {
                    int a = arr[i][j];
                    if (arr2[a - 1] != 0) {
                        colHasDuplicates = true;
                    }
                    arr2[a - 1]++;
                }
                if (colHasDuplicates) {
                    cmax++;
                }
                Arrays.fill(arr2, 0);
            }

            // Calculating the sum of the diagonal elements
            for (int i = 0; i < n; i++) {
                sum += arr[i][i];
            }

            System.out.println(sum + " " + rmax + " " + cmax);
        }
    }
}