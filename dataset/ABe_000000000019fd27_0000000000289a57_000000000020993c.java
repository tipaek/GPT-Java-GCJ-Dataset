import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int n2 = n * n;
            int rows = 0;
            int cols = 0;
            int trace = 0;
            int[][] matrix = new int[n][n];

            for (int j = 0; j < n; ++j ) {
                for (int k = 0; k < n; ++k) {
                    matrix [j] [k] = in.nextInt();
                    if( j == k)
                        trace = trace + matrix [j] [k];
                }
            }

            for(int l = 0; l < n; l++){
                int row [] = new int [n];
                for(int m = 0; m < n; m++) {
                    row[m] = matrix[l][m];
                    int z = m;
                    boolean exit = false;
                    while(exit == false) {
                        z--;
                        if( (z) < 0)
                            exit = true;
                        else {
                            if (row[m] == row[z] ) {
                                rows++;
                                exit = true;
                                m = n;
                            }
                        }
                    }
                };
            }


            for(int o = 0; o < n; o++){
                int col [] = new int [n];
                for(int p = 0; p < n; p++) {
                    col[p] = matrix[p][o];
                    int z = p;
                    boolean exit = false;
                    while(exit == false) {
                        z--;
                        if( (z) < 0)
                            exit = true;
                        else {
                            if (col[p] == col[z] ) {
                                cols++;
                                exit = true;
                                p = n;
                            }
                        }
                    }
                };
            }

        System.out.println("Case #" + i + ": " + trace + " " + rows + " " + cols );
        }
    }
}
