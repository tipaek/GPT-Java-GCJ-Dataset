//package solution;

import java.io.*;
import java.util.*;
import java.awt.Point;
import java.math.BigInteger;

public final class Solution {
    BufferedReader br;
    StringTokenizer stk;

    public static void main(String[] args) throws Exception {
        new Thread(null, new Runnable() {
            @Override
            public void run() {
                try {
                    new Solution().run();
                } catch(Exception | Error ex) {ex.printStackTrace();}
            }
        }, "solution", 1<<26).start();
    }
    
    {
        stk = null;
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    
    long mod = 998244353;
    void run() throws Exception {
        int t = ni();
        for(int I=1; I<=t; I++) {
            int x = ni(), y = ni();
            List<Point> pts = new ArrayList<>();
            String s = nt();
            for(int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                if(c == 'S') {
                    y--;
                } else if(c == 'N') {
                    y++;
                } else if(c == 'W') {
                    x--;
                } else {
                    x++;
                }
                pts.add(new Point(x, y));
            }
            
            //for(Point p : pts) {
                //pl(p.x + " " + p.y);
            //}
            //pl("------------------");
            
            int min = Integer.MAX_VALUE;
            for(int i=0; i<pts.size(); i++) {
                int timeTaken1 = i + 1;
                int timeTaken2 = Math.abs(pts.get(i).x) + Math.abs(pts.get(i).y);
                if(timeTaken2 > timeTaken1) continue;
                min = Math.min(min, Math.max(timeTaken1, timeTaken2));
            }
            pl("Case #" + I + ": " + ((min == Integer.MAX_VALUE) ? "IMPOSSIBLE" : min));
        }
    }
    
    //Reader & Writer
    String nextToken() throws Exception {
        if (stk == null || !stk.hasMoreTokens()) {
            stk = new StringTokenizer(br.readLine(), " ");
        }
        return stk.nextToken();
    }

    String nt() throws Exception {
        return nextToken();
    }

    String ns() throws Exception {
        return br.readLine();
    }

    int ni() throws Exception {
        return Integer.parseInt(nextToken());
    }

    long nl() throws Exception {
        return Long.parseLong(nextToken());
    }

    double nd() throws Exception {
        return Double.parseDouble(nextToken());
    }

    void p(Object o) {
        System.out.print(o);
    }

    void pl(Object o) {
        System.out.println(o);
    }
}