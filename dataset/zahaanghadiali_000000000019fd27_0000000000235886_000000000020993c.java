import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int c = 0; c < t; c++) {
            int trace = 0;
            int row = 0, col = 0;
            boolean lm;
            
            int n = sc.nextInt();
            int matrix[][] = new int[n][n];

            for (int p = 0; p < n; p++) {
                for (int q = 0; q < n; q++) {
                    matrix[p][q] = sc.nextInt();
                }
            }

            for (int tr = 0; tr < n; tr++) {
                trace += matrix[tr][tr];
            }

            for (int i = 0; i < matrix.length; i++) {

                if (duplicates(matrix[i])) {
                    row++;
                }

                int[] column = new int[matrix[i].length];
                for (int j = 0; j < matrix.length; j++) {
                    column[j] = matrix[j][i];
                }

                if (duplicates(column)) {
                    col++;
                }
            }

            if (row != 0 || col != 0) {
                lm = false;
            } else {
                lm = true;
            }

            if (lm) {
                System.out.println("Case #" + (c + 1) + ": " + trace + " 0 0");
            } else {
                System.out.println("Case #" + (c + 1) + ": " + trace + " " + row + " " + col);
            }
        }
    }

    public static boolean duplicates(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i != j && array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}