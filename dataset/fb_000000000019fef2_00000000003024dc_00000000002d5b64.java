
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        for(int i = 0; i < T; i++) {
            solve(i+1, in);
        }

    }

    private static void solve(int cid, Scanner in) {

        int R = in.nextInt();
        int S = in.nextInt();

        List<String> lines = new LinkedList<String>();

        sub(R, S, lines);

        System.out.println("Case #" + cid + ": " + lines.size());

        for(String l : lines) {
            System.out.println(l);
        }

    }

    private static void sub(int R, int S, List<String> lines) {

        if(R == 1) {
            return;
        }

        for(int i = 0; i < S-1; i++) {
            lines.add(((S-i-1)*R + i*(R-1)) + " " + (R-1));
        }

        sub(R-1, S, lines);

    }

}