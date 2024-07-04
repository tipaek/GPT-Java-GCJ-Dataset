package qualRound2020;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        for (int k = 1; k <= t; k++) {
            int n = sc.nextInt(); // Size of the matrix
            int trace = 0, row = 0, col = 0;
            int[][] matrix = new int[n][n];
            boolean[] check = new boolean[n + 1];

            // Read the matrix and calculate the trace and row duplicates
            for (int i = 0; i < n; i++) {
                boolean rowCounted = false;
                Arrays.fill(check, false);
                for (int j = 0; j < n; j++) {
                    int element = sc.nextInt();
                    matrix[i][j] = element;
                    if (i == j) {
                        trace += element;
                    }
                    if (check[element]) {
                        if (!rowCounted) {
                            row++;
                            rowCounted = true;
                        }
                    } else {
                        check[element] = true;
                    }
                }
            }

            // Check for column duplicates
            for (int j = 0; j < n; j++) {
                Arrays.fill(check, false);
                for (int i = 0; i < n; i++) {
                    int element = matrix[i][j];
                    if (check[element]) {
                        col++;
                        break;
                    } else {
                        check[element] = true;
                    }
                }
            }

            // Output the result for the current test case
            System.out.println("Case #" + k + ": " + trace + " " + row + " " + col);
        }
        sc.close();
    }
}