import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {

            int n = in.nextInt();
            int[][] matrix = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }


            String output = matrix(matrix);

            System.out.println("Case #" + i + ": " + output);

        }
    }

    static String matrix(int[][] matrix) {

        int k = 0;
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            k += matrix[i][i];
        }

        int r = 0;
        for (int[] ints : matrix) {
            Set<Integer> row = new HashSet<>();
            for (int j = 0; j < n; j++) {
                row.add(ints[j]);
            }
            if (row.size() < n) r++;
        }

        int c = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> col = new HashSet<>();
            for (int[] ints : matrix) {
                col.add(ints[i]);
            }
            if (col.size() < n) c++;
        }

        return "" + k + " " + r + " " + c;

    }

}
