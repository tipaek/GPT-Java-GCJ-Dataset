
import java.util.*;
import java.io.*;


public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int c = 1; c <= t; ++c) {
            int n = in.nextInt();
            String line = in.nextLine();
            int[][] matrix = new int[n][n];

            int[][] cols = new int[3][n];
            int[][] rows = new int[3][n];

            for (int i=0; i<n; i++)
            {
                cols[0][i] = rows[0][i] = n;
                cols[1][i] = rows[1][i] = 1;
            }

            int trace = 0;
            for (int i=0; i<n; i++)
            {


                String[] tokens = in.nextLine().split(" ");
                for (int j=0; j<n; j++) {
                    int cell = Integer.parseInt(tokens[j]);
                    matrix[i][j] = cell;
                    if (cell < cols[0][j]) cols[0][j] = cell;
                    if (cell > cols[1][j]) cols[1][j] = cell;

                    if (cell < rows[0][i]) rows[0][i] = cell;
                    if (cell > rows[1][i]) rows[1][i] = cell;

                    cols[2][j] += cell;
                    rows[2][i] += cell;

                }

                trace += matrix[i][i];
            }
            int cdiff = 0, rdiff = 0;
            int nSum = (n*n+n)/2;
            for (int i=0; i<n; i++)
            {
                if (cols[0][i] >1 || cols[1][i] < n || cols[2][i] != nSum) cdiff++;
                if (rows[0][i] >1 || rows[1][i] < n || rows[2][i] != nSum) rdiff++;
            }

            System.out.println("Case #" + c + ": " + trace + " " + rdiff + " " + cdiff);
        }
    }
}

