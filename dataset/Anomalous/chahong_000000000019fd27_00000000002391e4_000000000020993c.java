import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int crossSum = 0;
            int[][] matrix = new int[t][t];
            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Read matrix and calculate diagonal sum
            for (int j = 0; j < t; j++) {
                for (int k = 0; k < t; k++) {
                    int num = sc.nextInt();
                    matrix[j][k] = num;
                    if (j == k) {
                        crossSum += num;
                    }
                }
            }

            // Check for row and column duplicates
            for (int j = 0; j < t; j++) {
                boolean[] rowCheck = new boolean[t + 1];
                boolean[] colCheck = new boolean[t + 1];
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;

                for (int k = 0; k < t; k++) {
                    if (!rowHasDuplicate && rowCheck[matrix[j][k]]) {
                        rowDuplicates++;
                        rowHasDuplicate = true;
                    }
                    rowCheck[matrix[j][k]] = true;

                    if (!colHasDuplicate && colCheck[matrix[k][j]]) {
                        colDuplicates++;
                        colHasDuplicate = true;
                    }
                    colCheck[matrix[k][j]] = true;
                }
            }

            System.out.println(crossSum + " " + rowDuplicates + " " + colDuplicates);
        }

        sc.close();
    }
}