import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int crossSum = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            int[][] matrix = new int[t][t];

            // Read the matrix and calculate the cross sum
            for (int j = 0; j < t; j++) {
                for (int k = 0; k < t; k++) {
                    int num = sc.nextInt();
                    matrix[j][k] = num;
                    if (j == k) {
                        crossSum += num;
                    }
                }
            }

            // Check for duplicates in rows and columns
            for (int j = 0; j < t; j++) {
                boolean[] rowCheck = new boolean[t + 1];
                boolean[] colCheck = new boolean[t + 1];
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;

                for (int k = 0; k < t; k++) {
                    int rowVal = matrix[j][k];
                    int colVal = matrix[k][j];

                    if (rowCheck[rowVal]) {
                        rowHasDuplicate = true;
                    } else {
                        rowCheck[rowVal] = true;
                    }

                    if (colCheck[colVal]) {
                        colHasDuplicate = true;
                    } else {
                        colCheck[colVal] = true;
                    }
                }

                if (rowHasDuplicate) {
                    rowDuplicates++;
                }
                if (colHasDuplicate) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + crossSum + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}