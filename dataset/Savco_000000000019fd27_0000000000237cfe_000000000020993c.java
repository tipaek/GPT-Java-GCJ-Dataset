import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int rows = in.nextInt();
            int[][] matrix = new int[rows][rows];
            int diagonal = 0;
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < rows; k++) {
                    matrix[j][k] = in.nextInt();
                    if (k == j) diagonal += matrix[j][k];
                }
            }

            boolean[][] m = new boolean[rows][rows];

            int r = 0;
            int c = 0;

            boolean[] row;
            for (int j = 0; j < rows; j++) {
                row = new boolean[rows];
                for (int k = 0; k < rows; k++) {
                    if (row[matrix[j][k] - 1]) {
                        r++;
                        break;
                    } else row[matrix[j][k] - 1] = true;
                }
            }

            for (int j = 0; j < rows; j++) {
                row = new boolean[rows];
                for (int k = 0; k < rows; k++) {
                    if (row[matrix[k][j] - 1]) {
                        c++;
                        break;
                    } else row[matrix[k][j] - 1] = true;
                }
            }

            System.out.println("Case #" + i + ": " + diagonal + " " + r + " " + c);
        }
    }
}
