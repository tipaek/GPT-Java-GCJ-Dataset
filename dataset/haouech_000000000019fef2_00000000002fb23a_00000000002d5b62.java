
import java.util.*;
import java.io.*;

class Solution {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String argv[]) {

        int t = scanner.nextInt();
        for (int tc=1; tc <= t; tc++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String result = solve(x, y);
            System.out.println("Case #" + tc + ": " + result);
        }
    }

    private static String solve(int x, int y) {
        List<Integer> res = new ArrayList<>();
        boolean xlast = false, ylast = false;
        boolean flipx = x < 0;
        boolean flipy = y < 0;
        x = Math.abs(x); y = Math.abs(y);
        for (int i=0; i<31; i++) {
            boolean a = getBit(x, i), b = getBit(y, i);
            if (!a && !b) {
                if (x < (1 << i) && y < (1 << i)) {
                    return getRes(res, flipx, flipy); // todo
                }
                return "IMPOSSIBLE";
            }
            if (a && !b) {
                xlast = true;
                ylast = false;
                res.add(0);
            } else if (!a && b) {
                xlast = false;
                ylast = true;
                res.add(1);
            } else { // a == b == true
                if (res.size() == 0) {
                    return "IMPOSSIBLE";
                }
                int v = res.get(res.size()-1);
                res.set(res.size()-1, (v + 2) % 4); // flip direction
                if (xlast) {
                    x += (1 << (i-1));
                    res.add(1);
                    ylast = true;
                    xlast = false;
                } else if (ylast) {
                    y += (1 << (i-1));
                    res.add(0);
                    xlast = true;
                    ylast = false;
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }
        return "";
    }

    private static String getRes(List<Integer> res, boolean flipx, boolean flipy) {
        StringBuilder sb = new StringBuilder();
        for (int v: res) {
            if (v == 0) sb.append(flipx ? 'W' : 'E');
            else if (v == 1) sb.append(flipy ? 'S' : 'N');
            else if (v == 2) sb.append(flipx ? 'E' : 'W');
            else if (v == 3) sb.append(flipy ? 'N' : 'S');
            else throw new RuntimeException("Wrong direction value, got " + v);
        }
        return sb.toString();
    }

    private static boolean getBit(int x, int i) {
        return (x & (1 << i)) != 0;
    }

    private static List<Boolean> getBits(int n) {
        List<Boolean> res = new ArrayList<>();
        for (int i=0; n > 0; i++) {
            res.add((n & (1 << i)) != 0);
            n = (n & ~(1 << i));
        }
        return res;
    }
}