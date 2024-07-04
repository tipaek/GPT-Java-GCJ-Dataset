import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Solution problem = new Solution();
        problem.run(in);
    }

    public void run(Scanner in) {
        int tests = in.nextInt();
        for ( int t = 1; t <= tests; t++) {
            long x = in.nextLong();
            long y = in.nextLong();
            
            String result = solve(x, y);
            System.out.printf("Case #%d: %s\n", t, result);
        }
    }

    public boolean valid(long x, long y) {
        return (x % 2 != 0) ^ (y % 2 != 0);
    }
    public String solve(long x, long y) {
        StringBuilder result = new StringBuilder();
        while ( Math.abs(x) + Math.abs(y) > 1) {
            if ( x % 2 != 0 && y % 2 == 0) {
                if ( valid((x+1)/2, y/2) ) {
                    result.append('W');
                    x++;
                } else {
                    result.append('E');
                    x--;
                }
            } else if ( x % 2 == 0 && y % 2 != 0 ) {
                if ( valid(x/2, (y+1)/2) ) {
                    result.append('S');
                    y++;
                } else {
                    result.append('N');
                    y--;
                }
            } else return "IMPOSSIBLE";
            x /= 2;
            y /= 2;
        }
        if ( x == 0 && y == -1 ) result.append('S');
        else if ( x == 0 && y == 1 ) result.append('N');
        else if ( y == 0 && x == -1 ) result.append('W');
        else if ( y == 0 && x == 1 ) result.append('E');
        else return "IMPOSSIBLE";
        return result.toString();
    }

}
