import java.util.*;
import java.io.*;

// Vestigium  Problem

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int x = 1; x <= t; ++x) {
            int N = in.nextInt();

            int[][] mat = new int[N][N] ;
            boolean dr = false , dc = false;
            int r = 0 ;
            int c = 0 ;
            int s = 0 ;
            // fill the matrix
            for (int i = 0 ; i < N ; i++ ) {
                for ( int j = 0 ; j < N ; j++ ) {
                    mat[i][j] = in.nextInt();
                }
            }
            // check r
            for (int i = 0 ; i < N ; i++ ) {
                dr = dc = false ;
                for ( int j = 0 ; j < N ; j++ ) {
                    for (int k = j+1 ; k < N ; k++) {
                        // check rows
                        if (mat[i][j] == mat[i][k]) dr = true ;
                        // check cols
                        if (mat[j][i] == mat[k][i]) dc = true ;
                    }
                    // calculate trace
                    if (i == j) s += mat[i][j] ;
                }
                if (dr) r++ ;
                if (dc) c++ ;
            }
            // solution
            System.out.println("Case #" + x + ": " + s  + " " + r + " " + c);
        }
    }
}
