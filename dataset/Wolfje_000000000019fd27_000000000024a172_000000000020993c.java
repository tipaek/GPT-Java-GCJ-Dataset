import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Solution problem = new Solution();
        problem.run(in);
    }

    public void run(Scanner in) {
        int tests = in.nextInt();
        for ( int t = 1; t <= tests; t++) {
            int n = in.nextInt();
            int[][] m = new int[n][n];
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++) m[i][j] = in.nextInt();
            int trace = 0;
            for(int i = 0; i < n; i++) trace += m[i][i];
            int failRows = 0;
            for ( int r = 0; r < n; r++ )
            {
                TreeSet<Integer> seen = new TreeSet<Integer>();
                for ( int c = 0; c < n; c++ ) seen.add(m[r][c]);
                if ( seen.size() < n ) failRows++;
            }
            int failCols = 0;
            for ( int c = 0; c < n; c++ )
            {
                TreeSet<Integer> seen = new TreeSet<Integer>();
                for ( int r = 0; r < n; r++ ) seen.add(m[r][c]);
                if ( seen.size() < n ) failCols++;
            }
            System.out.printf("Case #%d: %d %d %d\n", t, trace, failRows, failCols);
        }
    }

}
