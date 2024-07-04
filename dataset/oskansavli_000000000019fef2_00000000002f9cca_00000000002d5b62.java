
import java.util.*;
import java.io.*;
public class Solution {
    
    public static int x;
    public static int y;

    static String[][][] cache;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int ti = 1; ti <= t; ++ti) {
            x = in.nextInt();
            y = in.nextInt();

            if (x <= 100 && y <= 100) {
                String r = solve(x, y, 1, "", 64*Math.abs(x)+64*Math.abs(y));
                if (r != "-") {
                    System.out.println("Case #" + ti + ": " + r);
                } else {
                    System.out.println("Case #" + ti + ": IMPOSSIBLE");
                }
            }
        }
    }

    static String solve(int x, int y, int step, String path, int max) {
        if (x == 0 && y == 0) {
            return path;
        }
        if (step > max) {
            return "-";
        }
        String east = solve(x-step, y, step*2, path+"E", max);
        if (east != "-") {
            return east;
        }
        String west = solve(x+step, y, step*2, path+"W", max);
        if (west != "-") {
            return west;
        }
        String north = solve(x, y-step, step*2, path+"N", max);
        if (north != "-") {
            return north;
        }
        String south = solve(x, y+step, step*2, path+"S", max);
        if (south != "-") {
            return south;
        }
        
        return "-";
    }
}