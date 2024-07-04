
import java.util.*;
import java.io.*;
public class Solution {
    
    public static int x;
    public static int y;
    static int maxxy;

    static HashMap<String, String> cache;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int ti = 1; ti <= t; ++ti) {
            x = in.nextInt();
            y = in.nextInt();
            maxxy = 2*Math.max(Math.abs(x),Math.abs(y));

            cache = new HashMap<>();

            String result = "IMPOSSIBLE";

            int max = 10;

            if (x > 100 || y > 100) {
                max = 32;
            }

            int m = 1;
            while (m < max) {
                String r = solve(x, y, 1, "", m);
                if (r != "-") {
                    result = r;
                    break;
                }
                m += 1;
            }
            System.out.println("Case #" + ti + ": " + result);
        }
    }

    static String solve(int x, int y, int step, String path, int max) {
        int stepSize = (int) Math.pow(2,step-1);
        if (step > max || stepSize > maxxy) {
            return "-";
        }

        String key = x+","+y+","+stepSize;
        String val = cache.get(key);
        if (val != null) {
            String r = path + val;
            if (r.length() < max) {
//                System.out.println("key: " + key);
                cache.putIfAbsent(key, r);
                return val;
            }
        }

        if (x == 0 && y == 0) {
            cache.putIfAbsent(key, path);
            return path;
        }

        String east = solve(x-stepSize, y, step+1, path+"E", max);
        if (east != "-") {
            return east;
        }
        String west = solve(x+stepSize, y, step+1, path+"W", max);
        if (west != "-") {
            return west;
        }
        String north = solve(x, y-stepSize, step+1, path+"N", max);
        if (north != "-") {
            return north;
        }
        String south = solve(x, y+stepSize, step+1, path+"S", max);
        if (south != "-") {
            return south;
        }

        return "-";
    }
}
