
import java.util.*;
import java.io.*;
public class Solution {

    private int trace;
    private int r;
    private int c;

    private void check(int[][] matrix){
        final int ROWS = matrix.length;
        final int COLS = matrix[0].length;

        /*
            Trace and r
         */
        this.trace = 0;
        this.r = 0;
        for(int i=0;i<ROWS;i++){
            Set<Integer> set = new HashSet<>();
            for(int j=0;j<COLS;j++){
                if( i == j ){
                    this.trace += matrix[i][j];
                }

                set.add(matrix[i][j]);
            }
            if(set.size() != COLS){
                this.r++;
            }
        }

        this.c = 0;
        for(int j=0;j<COLS;j++) {
            Set<Integer> set = new HashSet<>();
            for(int i=0;i<ROWS;i++) {
                set.add(matrix[i][j]);
            }
            if(set.size() != ROWS){
                this.c++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int m = in.nextInt();

            int[][] martic = new int[m][m];
            for( int mr = 0; mr<m;mr++){
                for( int mc=0; mc<m;mc++){
                    martic[mr][mc] = in.nextInt();
                }
            }

            Solution sol = new Solution();
            sol.check(martic);

            System.out.println( String.format("Case #%d: %d %d %d", i, sol.trace, sol.r, sol.c) );
        }
    }
}