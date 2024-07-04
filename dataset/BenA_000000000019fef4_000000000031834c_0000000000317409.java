import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = Integer.parseInt(s.nextLine());
        String ans;
        String[] dirs;
        for (int q = 1; q <= cases; q++) {
            dirs = s.nextLine().split(" ");
            ans = steps(Integer.parseInt(dirs[0]),Integer.parseInt(dirs[1]),dirs[2]);
            System.out.println("Case #"+q+": "+ans);
        }
    }
    public static String steps(int x, int y, String path) {
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'N') {
                y++;
            }
            if (path.charAt(i) == 'S') {
                y--;
            }
            if (path.charAt(i) == 'E') {
                x++;
            }
            if (path.charAt(i) == 'W') {
                x--;
            }
            if (Math.abs(x)+Math.abs(y) <= i+1) {
                return i+1+"";
            }
        }
        return "IMPOSSIBLE";
    }
}