import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int a = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int b = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            solve(in, a, b);
        }
    }

    private static void solve(Scanner in, int a, int b) {
        long x = -1000000000L, y = -1000000000L;

        x += a;
        y += a;
        while (true) {
            System.out.println(x + " " + y);
            System.out.flush();
            String res = in.nextLine();
            if ("CENTER".equals(res)) {
                return;
            }
            if ("HIT".equals(res)) {
                break;
            }
            if (y < 1000000000L) {
                y += a;
            } else {
                x += a;
                y = a;
            }
        }
        
        long inx = x, iny=y;

        List<List<Long>> l = new ArrayList<>();
        // x,y in circle.
        long highx = inx;
        long lowx =-1000000000L;
        while(lowx+1 < highx) {
            long newx = (lowx+highx)/2;
            System.out.println(newx + " " + iny);
            System.out.flush();      
            String res = in.nextLine();
            if (res.equals("CENTER")) {
                return;
            }
            if (res.equals("MISS")) {
                lowx = newx;
            } else {
                highx= newx;
            }
        }
        l.add(Arrays.asList(lowx, iny));

        highx = 1000000000L;
        lowx = inx;
        while(lowx+1 < highx) {
            long newx = (lowx+highx)/2;
            System.out.println(newx + " " + iny);
            System.out.flush();      
            String res = in.nextLine();
            if (res.equals("CENTER")) {
                return;
            }
            if (res.equals("MISS")) {
                highx = newx;
            } else {
                lowx= newx;
            }
        }
        l.add(Arrays.asList(lowx, iny));
        
        long highy = 1000000000L;
        long lowy = iny;
        while(lowy+1 < highy) {
            long newy = (lowy+highy)/2;
            System.out.println(inx + " " + newy);
            System.out.flush();      
            String res = in.nextLine();
            if (res.equals("CENTER")) {
                return;
            }
            if (res.equals("MISS")) {
                highy = newy;
            } else {
                lowy= newy;
            }
        }
        l.add(Arrays.asList(inx, lowy));
        
        highy = 1000000000L;
        lowy = iny;
        while(lowy+1 < highy) {
            long newy = (lowy+highy)/2;
            System.out.println(inx + " " + newy);
            System.out.flush();      
            String res = in.nextLine();
            if (res.equals("CENTER")) {
                return;
            }
            if (res.equals("MISS")) {
                highy = newy;
            } else {
                lowy= newy;
            }
        }
        l.add(Arrays.asList(inx, lowy));

        int tooclose = 0;
        Map<Integer, List<Integer>> closeTo = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            closeTo.put(i, new ArrayList<>());
        }
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                long dist = dist(l.get(i), l.get(j));
                if (dist < 10000) {
                    tooclose++;
                    closeTo.get(i).add(j);
                    closeTo.get(j).add(i);
                }
            }
        }
        if (tooclose >= 3) {
            long searchx, searchy;
            int dir;
            if (closeTo.get(0).size() == 2 && closeTo.get(1).size() == 2 && closeTo.get(2).size() == 2) {
                // up
                searchx = (l.get(0).get(0) + l.get(3).get(0)) / 2;
                searchy = (l.get(0).get(1) + l.get(3).get(1)) / 2;
                l.remove(0);
                l.remove(1);
                dir = 0;
            } else if (closeTo.get(0).size() == 2 && closeTo.get(1).size() == 2 && closeTo.get(3).size() == 2) {
                // down
                searchx = (l.get(0).get(0) + l.get(2).get(0)) / 2;
                searchy = (l.get(0).get(1) + l.get(2).get(1)) / 2;
                l.remove(0);
                l.remove(1);
                dir = 1;
            } else if (closeTo.get(2).size() == 2 && closeTo.get(3).size() == 2 && closeTo.get(0).size() == 2) {
                // left
                searchx = (l.get(0).get(0) + l.get(1).get(0)) / 2;
                searchy = (l.get(0).get(1) + l.get(1).get(1)) / 2;
                l.remove(0);
                l.remove(2);
                dir = 2;
            } else /*
                    * if (closeTo.get(2).size() == 2 && closeTo.get(3).size() == 2 &&
                    * closeTo.get(1).size() == 2)
                    */ {
                // right
                searchx = (l.get(2).get(0) + l.get(0).get(0)) / 2;
                searchy = (l.get(2).get(1) + l.get(0).get(1)) / 2;
                l.remove(1);
                l.remove(2);
                dir = 3;
            }

            if (dir == 0 || dir == 1) {
                highx = 1000000000L;
                lowx = searchx;
                while (lowx + 1 < highx) {
                    long newx = (lowx + highx) / 2;
                    System.out.println(newx + " " + searchy);
                    System.out.flush();
                    String res = in.nextLine();
                    if (res.equals("CENTER")) {
                        return;
                    }
                    if (res.equals("MISS")) {
                        highx = newx;
                    } else {
                        lowx = newx;
                    }
                }
                l.add(Arrays.asList(lowx, searchy));
            } else {
                highy = 1000000000L;
                lowy = searchy;
                while (lowy + 1 < highy) {
                    long newy = (lowy + highy) / 2;
                    System.out.println(searchx + " " + newy);
                    System.out.flush();
                    String res = in.nextLine();
                    if (res.equals("CENTER")) {
                        return;
                    }
                    if (res.equals("MISS")) {
                        highy = newy;
                    } else {
                        lowy = newy;
                    }
                }
                l.add(Arrays.asList(searchx, lowy));
            }
        } else {
            int maxClose = 0;
            int toremove = 0;
            for (int i = 0; i < 4; i++) {
                if (closeTo.get(i).size() > maxClose) {
                    maxClose = closeTo.get(i).size();
                    toremove = i;
                }
            }
            l.remove(toremove);
        }

        for (int i = 0; i < 3; i++) {
            l.get(i).set(0, l.get(i).get(0) + ((long) (Math.random() * 1000)) - 500);
            l.get(i).set(1, l.get(i).get(1) + ((long) (Math.random() * 1000)) - 500);
        }

        double x1 = l.get(0).get(0);
        double x2 = l.get(1).get(0);
        double x3 = l.get(2).get(0);
        double y1 = l.get(0).get(1);
        double y2 = l.get(1).get(1);
        double y3 = l.get(2).get(1);
//        System.err.println(x1 + "," + y1);
//        System.err.println(x2 + "," + y2);
//        System.err.println(x3 + "," + y3);

        double xc = ((x3 * x3 - x2 * x2 + y3 * y3 - y2 * y2) / (2 * (y3 - y2))
                - (x2 * x2 - x1 * x1 + y2 * y2 - y1 * y1) / (2 * (y2 - y1)))
                / ((x2 - x1) / (y2 - y1) - (x3 - x2) / (y3 - y2));
        double yc = -(x2 - x1) / (y2 - y1) * xc + (x2 * x2 - x1 * x1 + y2 * y2 - y1 * y1) / (2 * (y2 - y1));

        long xcc = (long) xc;
        long ycc = (long) yc;
        if (xcc < -1000000000L) {
            xcc = -1000000000L;
        }
        if (xcc > 1000000000L) {
            xcc = 1000000000L;
        }
        if (ycc < -1000000000L) {
            ycc = -1000000000L;
        }
        if (ycc > 1000000000L) {
            ycc = 1000000000L;
        }
        while (true) {
            System.out.println(xcc + " " + ycc);
            String aze = in.nextLine();
            if (aze.equals("WRONG")) {
                System.exit(0);
            }
            if (aze.equals("CENTER")) {
                return;
            }
            xcc=xcc+((long) Math.random()*10);
            ycc=ycc+((long) Math.random()*10);
        }
    }

    private static long dist(List<Long> list, List<Long> list2) {
        long dx = Math.abs(list.get(0) - list2.get(0));
        long dy = Math.abs(list.get(1) - list2.get(1));
        return dx * dx + dy * dy;
    }
}
