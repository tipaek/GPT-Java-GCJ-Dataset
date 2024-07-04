import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
//        for (int i = 0; i < 5; i++) {
//            for (int j = i; j < 5; j++) {
//                findMost(i, j);
//                map = new HashMap<>();
//                String res = getRes(i, j, new StringBuilder());
//                System.out.println("i == " + i + "  j == " + j + " res ==" + res);
//            }
//        }
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int index = 1; index <= t; ++index) {
            long x = in.nextInt();
            long y = in.nextInt();

            findMost(x, y);
            map = new HashMap<>();
            String res = getRes(x, y, new StringBuilder());
            System.out.println("Case #" + index + ": " + ("-1".equals(res) ? "IMPOSSIBLE" : res));
        }
    }

    private static void findMost(long x, long y) {
        long absX = Math.abs(x);
        long absY = Math.abs(y);
        long ix = absX == 0 ? 0 : 1L << 31;
        long iy = absY == 0 ? 0: 1L << 31;
        while (absX != 0 && (ix & absX) == 0) {
            ix >>= 1;
        }
        while (absY != 0 && (iy & absY) == 0) {
            iy >>= 1;
        }
        if (ix == iy) {
            step = ix << 1;
        } else {
            step = Math.max(ix, iy);
        }
        step <<= 1;
    }

    static HashMap<Long, String> map = new HashMap<>();
    static long step = 0L;
    private static String getRes(long x, long y, StringBuilder res) {
        long key = x * 1000000001L + y;
        if (map.get(key) != null) {
            return map.get(key);
        }
        step >>= 1;
        if (x == 0 && y == 0 && step == 0) {
            return res.toString();
        }
        long absX = Math.abs(x);
        long absY = Math.abs(y);


        if (step == 0) {
            map.put(key, "-1");
            return "-1";
        }

        long tmpIndex = step;
        String goHor = goHor(x, new StringBuilder(res), y);
        step = tmpIndex;
        String goVer = goVer(x, new StringBuilder(res), y);
        if ("-1".equals(goHor) && "-1".equals(goVer)) {
            return "-1";
        }
        if ("-1".equals(goHor)){
            return goVer;
        }
        if ("-1".equals(goVer)){
            return goHor;
        }
        String rst = goVer.length() < goHor.length() ? goVer : goHor;
        map.put(key, rst);
        return rst;

    }

    private static String goHor(long x, StringBuilder res, long y) {
        if (x > 0) {
            x -= step;
            res.insert(0, "E");
        } else {
            x += step;
            res.insert(0, "W");
        }
        return getRes(x, y, res);
    }

    private static String goVer(long x, StringBuilder res, long y) {
        if (y > 0) {
            y -= step;
            res.insert(0, "N");

        } else {
            res.insert(0, "S");
            y += step;
        }
        return getRes(x, y, res);
    }
}