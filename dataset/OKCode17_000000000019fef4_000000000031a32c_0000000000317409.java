import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

public class Solution {

    Scanner             sc       = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    PrintStream         out      = System.out;

    private void solve() {
        int x = sc.nextInt();
        int y = sc.nextInt();
        String path = sc.next();
        int distance = 0;
        for(char c : path.toCharArray()) {
            if(c=='S') {
                y--;
            }
            if(c=='N') {
                y++;
            }
            if(c=='E') {
                x++;
            }
            if(c=='W') {
                x--;
            }
            distance++;
            if(Math.abs(x)+Math.abs(y)<=distance) {
                out.println(distance);
                return;
            }
        }
        out.println("IMPOSSIBLE");
    }

    private void run() throws Exception {
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");
            solve();
        }
        sc.close();
        out.close();
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }


}