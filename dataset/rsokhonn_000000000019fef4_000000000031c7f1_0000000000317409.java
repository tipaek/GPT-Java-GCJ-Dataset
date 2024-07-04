import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTC = sc.nextInt();

        for(int tc=1; tc<=numTC; tc++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            String m = sc.next();
            
            int result = solve(x, y, m);

            if (result == -1)
                System.out.println("Case #" + tc + ": IMPOSSIBLE");
            else
                System.out.println("Case #" + tc + ": " + result);
        }
    }
    
    public static int solve (int x, int y, String m) {
        int[] pair = getDiff(x, y, m);
        
        int newX = pair[0];
        int newY = pair[1];
        int minX = pair[2];
        int minY = pair[3];
        int minTime = pair[4];
        
        if (Math.abs(newX) + Math.abs(newY) > m.length())
            return -1;
            
        // System.out.println(minX + ", " + minY);
        return minTime;
    }
    
    public static int[] getDiff(int x, int y, String m) {
        int[] pair = new int[5];
        
        int minDist = Integer.MAX_VALUE;
        int minX = x;
        int minY = y;
        int minTime = -1;
        
        for (int i=0; i < m.length(); i++) {
            if (m.charAt(i) == 'N')
                y++;
            else if (m.charAt(i) == 'S')
                y--;
            else if (m.charAt(i) == 'E')
                x++;
            else if (m.charAt(i) == 'W')
                x--;
                
            if ((Math.abs(x) + Math.abs(y) < minDist)
                && (Math.abs(x) + Math.abs(y) <= i+1)) {
                minDist = Math.abs(x) + Math.abs(y);
                
                if (minTime == -1)
                    minTime = i+1;
                
                minX = x;
                minY = y;
                // System.out.println("minTime: " + minTime);
                // System.out.println("dist: " + (minDist));
            }
        }
        
        pair[0] = x; pair[1] = y;
        pair[2] = minX; pair[3] = minY;
        pair[4] = minTime;
        
        return pair;
    }
}
