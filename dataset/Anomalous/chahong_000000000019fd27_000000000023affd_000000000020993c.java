import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int crossSum = 0;
            int[][] matrix = new int[t][t];
            int rowDuplicates = 0;
            int colDuplicates = 0;

            for (int j = 0; j < t; j++) {
                for (int k = 0; k < t; k++) {
                    int num = sc.nextInt();
                    matrix[j][k] = num;
                    if (j == k) {
                        crossSum += num;
                    }
                }
            }

            for (int j = 0; j < t; j++) {
                boolean[] rowCheck = new boolean[t + 1];
                boolean[] colCheck = new boolean[t + 1];
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;

                for (int k = 0; k < t; k++) {
                    if (rowCheck[matrix[j][k]]) {
                        if (!rowHasDuplicate) {
                            rowDuplicates++;
                            rowHasDuplicate = true;
                        }
                    } else {
                        rowCheck[matrix[j][k]] = true;
                    }

                    if (colCheck[matrix[k][j]]) {
                        if (!colHasDuplicate) {
                            colDuplicates++;
                            colHasDuplicate = true;
                        }
                    } else {
                        colCheck[matrix[k][j]] = true;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + crossSum + " " + rowDuplicates + " " + colDuplicates);
        }

        sc.close();
    }
}