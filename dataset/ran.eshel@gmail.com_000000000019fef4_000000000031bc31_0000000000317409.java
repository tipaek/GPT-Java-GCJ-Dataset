import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        for (int i = 1; i <= t; ++i) {

            int x = s.nextInt();
            int y = s.nextInt();
            String path = s.next();
            int len = path.length();

            int[] xp = new int[len + 1];
            int[] yp = new int[len + 1];
            int[] dist = new int[len + 1];

            xp[0] = x;
            yp[0] = y;
            dist[0] = x + y;

            for (int k = 1; k <= len; k++) {
                char c = path.charAt(k-1);
                switch(c) {
                    case 'S':
                        xp[k] = xp[k-1];
                        yp[k] = yp[k-1] - 1;
                        break;
                    case 'N':
                        xp[k] = xp[k-1];
                        yp[k] = yp[k-1] + 1;
                        break;
                    case 'W':
                        xp[k] = xp[k-1] - 1;
                        yp[k] = yp[k-1];
                        break;
                    case 'E':
                        xp[k] = xp[k-1] + 1;
                        yp[k] = yp[k-1];
                        break;
                }
                dist[k] = Math.abs(xp[k]) + Math.abs(yp[k]);
            }

            int k = 0;
            while (k <= len && dist[k] > k)
                k++;

            if (k <= len)
                System.out.println("Case #" + i + ": " + k);
            else
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
        }
    }
}

