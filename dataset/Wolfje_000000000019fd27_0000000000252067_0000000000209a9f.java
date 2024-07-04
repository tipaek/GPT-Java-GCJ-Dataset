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
            String s = in.next();
            String result = solve(s);
            System.out.printf("Case #%d: %s\n", t, result);
        }
    }

    public String solve(String s) {
        StringBuilder sb = new StringBuilder();
        int height = 0;
        for ( int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - '0';
            while ( height < x ) { sb.append('('); height++; }
            while ( height > x ) { sb.append(')'); height--; }
            sb.append(s.charAt(i));
        }
        for ( int i = 0; i < height; i++ ) sb.append(')');
        return sb.toString();
    }

}
