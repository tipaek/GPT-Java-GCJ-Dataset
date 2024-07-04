import java.util.Scanner;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int z = 0; z < t; z++) {
            int n = sc.nextInt();
            int sum = 0;
            int rmax = 0;
            int cmax = 0;
            int[][] arr = new int[n][n];
            int[] frequency = new int[100];

            // Reading the matrix and processing rows
            for (int i = 0; i < n; i++) {
                boolean rowHasDuplicates = false;
                for (int j = 0; j < n; j++) {
                    int value = sc.nextInt();
                    arr[i][j] = value;
                    frequency[value - 1]++;
                    if (frequency[value - 1] > 1) {
                        rowHasDuplicates = true;
                    }
                }
                if (rowHasDuplicates) {
                    rmax++;
                }
                Arrays.fill(frequency, 0); // Reset frequency array for next row
            }

            // Processing columns
            for (int j = 0; j < n; j++) {
                boolean colHasDuplicates = false;
                for (int i = 0; i < n; i++) {
                    int value = arr[i][j];
                    frequency[value - 1]++;
                    if (frequency[value - 1] > 1) {
                        colHasDuplicates = true;
                    }
                }
                if (colHasDuplicates) {
                    cmax++;
                }
                Arrays.fill(frequency, 0); // Reset frequency array for next column
            }

            // Calculating the sum of the main diagonal
            for (int i = 0; i < n; i++) {
                sum += arr[i][i];
            }

            System.out.println(sum + " " + rmax + " " + cmax);
        }
        sc.close();
    }
}