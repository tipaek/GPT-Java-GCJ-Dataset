
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
            byte[][] cols   = new byte[n][n];
            byte[][] rows   = new byte[n][n];


            int trace = 0;
            for (int i=0; i<n; i++)
            {


                String[] tokens = in.nextLine().split(" ");
                for (int j=0; j<n; j++) {
                    int cell = Integer.parseInt(tokens[j]);
                    matrix[i][j] = cell;
                    cols[j][cell-1] = 1;
                    rows[i][cell-1] = 1;
                }

                trace += matrix[i][i];
            }
            int cdiff = 0, rdiff = 0;
            for (int i=0; i<n; i++)
            {
                for (int j=0; j<n; j++)
                {
                    if (cols[i][j] == 0) {
                        cdiff++;
                        break;
                    }
                }
            }

            for (int i=0; i<n; i++)
            {
                for (int j=0; j<n; j++)
                {
                    if (rows[i][j] == 0) {
                        rdiff++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + c + ": " + trace + " " + rdiff + " " + cdiff);
        }
    }
}

