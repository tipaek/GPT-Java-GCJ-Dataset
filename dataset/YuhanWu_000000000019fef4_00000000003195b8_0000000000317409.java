import java.util.*;
import java.io.*;

/**
 * Created by Harry on 5/2/20.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
//            int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
            Map<Character, int[]> dirs = new HashMap<>();
            dirs.put('S', new int[]{-1, 0});
            dirs.put('N', new int[]{1, 0});
            dirs.put('E', new int[]{0, 1});
            dirs.put('W', new int[]{0, -1});

            int y = in.nextInt();
            int x = in.nextInt();
            String p = in.next();
            if(x==0 && y==0){
                System.out.println("Case #"+i+": 0");
                continue;
            }

            int cx = x;
            int cy = y;
            boolean isResFound = false;
            for(int time=1; time<=p.length(); time++){
                char c = p.charAt(time-1);
                int[] dir = dirs.get(c);
                cx += dir[0];
                cy += dir[1];
                int dist = Math.abs(cx)+Math.abs(cy);
                if(dist<=time){
                    System.out.println("Case #"+i+": "+time);
                    isResFound = true;
                    break;
                }
            }
            if(!isResFound){
                System.out.println("Case #"+i+": IMPOSSIBLE");
            }
        }
    }
}
