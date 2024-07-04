import java.util.*;
import java.io.*;

public class Solution {
    public static int solve(int X, int Y, char[] M) {
        int d = dist(X, Y);
        if (d == 0) { return 0; }
        int x = X;
        int y = Y;

//        System.err.println("X="+X+";Y="+Y +";M="+Arrays.toString(M));
        for (int i = 0, cur = d, step = 1; i < M.length; i++, step++) {
//            System.err.println("cur dist="+cur+";step="+step);;
            switch (M[i]) {
            case 'N': y++; break;
            case 'S': y--; break;
            case 'E': x++; break;
            case 'W': x--; break;
            }
            cur = dist(x, y);
            if (cur <= step) {
                return step;
            }
        }
        return -1;
    }

    static int dist(int X, int Y) {
        return Math.abs(X) + Math.abs(Y);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintStream out = System.out;
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int X = in.nextInt();
            int Y = in.nextInt();
            String M = in.next();
            out.format("Case #%d: ", i);
            int res = solve(X, Y, M.toCharArray());
            out.println(res > 0 ? String.valueOf(res) : "IMPOSSIBLE");
        }
    }
}
