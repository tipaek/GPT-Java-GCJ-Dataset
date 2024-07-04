
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int T = s.nextInt();
        for(int i = 0; i < T; i++) {
            solve(i+1, s);
        }

    }

    private static void solve(int cid, Scanner in) {

        int X = in.nextInt();
        int Y = in.nextInt();
        String path = in.next();

        int pp_x = 0;
        int pp_y = 0;
        if(X == 0 && Y == 0) {
            System.out.println("Case #" + cid + ": " + 0);
            return;
        }
        for(int i = 0; i < path.length(); i++) {
            if(path.charAt(i) == 'N') {
                pp_y++;
            } else if(path.charAt(i) == 'S') {
                pp_y--;
            } else if(path.charAt(i) == 'E') {
                pp_x++;
            } else if(path.charAt(i) == 'W') {
                pp_x--;
            } else {
                throw new RuntimeException();
            }
            if(Math.abs(pp_y + Y) + Math.abs(pp_x + X) <= i+1) {
                System.out.println("Case #" + cid + ": " + (i+1));
                return;
            }
        }

        System.out.println("Case #" + cid + ": IMPOSSIBLE");

    }

}
