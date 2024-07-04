import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for( int c = 1; c <= T; c++ ) {
            int N = in.nextInt();
            int[][] rows = new int[N][N+1], cols = new int[N][N+1];
            int trace = 0;
            int[] rows_l = new int[N], cols_l = new int[N];
            for( int i = 0; i < N; i++ ) {
                for( int j = 0; j < N; j++ ) {
                    int temp = in.nextInt();
                    if( i == j ) trace += temp;
                    if( rows[i][temp]++ > 0 && rows_l[i] == 0 ) rows_l[i] = 1;
                    if( cols[j][temp]++ > 0  && cols_l[j] == 0 ) cols_l[j] = 1;
                }
            }
            int x_cols = 0, x_rows = 0;
            for( int i : cols_l ) x_cols+=i;
            for( int i : rows_l ) x_rows+=i;
            System.out.printf("Case #%d: %d %d %d\n", c, trace, x_rows, x_cols);
        }
    }
}