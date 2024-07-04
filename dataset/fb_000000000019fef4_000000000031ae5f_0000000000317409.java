
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int T = s.nextInt();
        for(int i = 0; i < T; i++) {
            solve(i+1, s);
        }

    }

    private static void solve(int cid, Scanner in) {

        int[][] pp_arrive = new int[2001][2001];
        int[][] me_arrive = new int[2001][2001];
        
        int X = in.nextInt();
        int Y = in.nextInt();
        String path = in.next();

        for(int x = -1000; x <= 1000; x++) {
            for(int y = -1000; y <= 1000; y++) {
                me_arrive[1000+x][1000+y] = 5000;
                pp_arrive[1000+x][1000+y] = -5000;
            }
        }

        me_arrive[1000-X][1000-Y] = 0;

        int pp_x = 0;
        int pp_y = 0;
        pp_arrive[1000][1000] = 0;
        for(int i = 0; i < path.length(); i++) {
            if(path.charAt(i) == 'N') {
                pp_y++;
            } else if(path.charAt(i) == 'S') {
                pp_y--;
            } else if(path.charAt(i) == 'E') {
                pp_x++;
            } else if(path.charAt(i) == 'W') {
                pp_x--;
            } else {
                throw new RuntimeException();
            }
            pp_arrive[1000+pp_x][1000+pp_y] = i+1;
        }

        boolean[][] enq = new boolean[2001][2001];

        Queue<Point> Q = new LinkedList<Point>();
        Q.add(new Point(1000-X, 1000-Y));
        enq[1000-X][1000-Y] = true;

        while(!Q.isEmpty()) {
            Point p = Q.remove();
            int x, y;
            x = p.x + 1;
            y = p.y;
            if(x < 2001 && y < 2001 && x >= 0 && y >= 0 && !enq[x][y]) {
                Q.add(new Point(x, y));
                enq[x][y] = true;
                if(me_arrive[p.x][p.y] + 1 < me_arrive[x][y]) {
                    me_arrive[x][y] = me_arrive[p.x][p.y] + 1;
                }
            }
            x = p.x - 1;
            y = p.y;
            if(x < 2001 && y < 2001 && x >= 0 && y >= 0 && !enq[x][y]) {
                Q.add(new Point(x, y));
                enq[x][y] = true;
                if(me_arrive[p.x][p.y] + 1 < me_arrive[x][y]) {
                    me_arrive[x][y] = me_arrive[p.x][p.y] + 1;
                }
            }
            x = p.x;
            y = p.y + 1;
            if(x < 2001 && y < 2001 && x >= 0 && y >= 0 && !enq[x][y]) {
                Q.add(new Point(x, y));
                enq[x][y] = true;
                if(me_arrive[p.x][p.y] + 1 < me_arrive[x][y]) {
                    me_arrive[x][y] = me_arrive[p.x][p.y] + 1;
                }
            }
            x = p.x;
            y = p.y - 1;
            if(x < 2001 && y < 2001 && x >= 0 && y >= 0 && !enq[x][y]) {
                Q.add(new Point(x, y));
                enq[x][y] = true;
                if(me_arrive[p.x][p.y] + 1 < me_arrive[x][y]) {
                    me_arrive[x][y] = me_arrive[p.x][p.y] + 1;
                }
            }
        }

        int min_time = Integer.MAX_VALUE;
        for(int x = 0; x < 2001; x++) {
            for(int y = 0; y < 2001; y++) {
                if(me_arrive[x][y] <= pp_arrive[x][y]) {
                    int t = pp_arrive[x][y];
                    if(t < min_time) {
                        min_time = t;
                    }
                }
            }
        }

        if(min_time == Integer.MAX_VALUE) {
            System.out.println("Case #" + cid + ": IMPOSSIBLE");
        } else {
            System.out.println("Case #" + cid + ": " + min_time);
        }

    }

    private static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
