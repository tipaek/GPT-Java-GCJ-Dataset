import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int[][] matrix = new int[t][t];
            int crossSum = 0;
            int rowDupCount = 0;
            int colDupCount = 0;

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
                boolean rowHasDup = false;
                boolean colHasDup = false;

                for (int k = 0; k < t; k++) {
                    if (!rowHasDup && rowCheck[matrix[j][k]]) {
                        rowDupCount++;
                        rowHasDup = true;
                    }
                    rowCheck[matrix[j][k]] = true;

                    if (!colHasDup && colCheck[matrix[k][j]]) {
                        colDupCount++;
                        colHasDup = true;
                    }
                    colCheck[matrix[k][j]] = true;
                }
            }

            System.out.println(crossSum + " " + rowDupCount + " " + colDupCount);
        }
    }
}