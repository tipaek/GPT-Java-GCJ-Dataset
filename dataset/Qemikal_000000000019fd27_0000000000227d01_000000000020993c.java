import java.util.Scanner;
import java.util.Arrays;

public class Solution
{
    private static int check(int[] no) {
        Arrays.sort(no);
        for (int i = 1; i < no.length; i++) {
            if (no[i] == no[i - 1]) {
                return 1;
            }
        }
        return 0;
    }
    public static void main(String args[])
    {
        Scanner read = new Scanner(System.in);
        int cases = read.nextInt();
        for (int ca = 1; ca <= cases; ca++) {
            int n = read.nextInt();
            int sum = 0;
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = read.nextInt();
                }
                sum += matrix[i][i];
            }
            int[] row = new int[n];
            int[] col = new int[n];
            int r = 0;
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    row[j] = matrix[i][j];
                    col[j] = matrix[j][i];
                }
                r += check(row);
                c += check(col);
            }
            System.out.println("Case #" + ca + ": " + sum + " " + r + " " + c);
        }
    }
}