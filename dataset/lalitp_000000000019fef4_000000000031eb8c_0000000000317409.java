import java.util.*;

public class Solution {

    public static void main(String[] args) {
        // write your code here
        int T, t, x, y, min, i, cur, curX, curY, toa;
        char ch;
        String path;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for(t = 1; t <= T; t++) {
            x = sc.nextInt();
            y = sc.nextInt();
            path = sc.next();

            curX = x;
            curY = y;
            cur = 0;
            min = Integer.MAX_VALUE;
            toa = curX + Math.abs(curY);
            if(toa <= cur) {
                min = cur;
            }
            for(i = 0; i < path.length(); i++) {
                ch = path.charAt(i);
                cur++;
                switch (ch) {
                    case 'S':
                        curY--;
                        break;
                    case 'N':
                        curY++;
                        break;
                    case 'W':
                        curX--;
                        break;
                    case 'E':
                        curX++;
                        break;
                }
                toa = Math.abs(curX) + Math.abs(curY);
                if(toa <= cur) {
                    if(cur < min) {
                        min = cur;
                    }
                }
            }

            if(min != Integer.MAX_VALUE)
                System.out.println("Case #" + t + ": " + min);
            else
                System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
        }
    }
}