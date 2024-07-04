
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
//            checkRes(x, y, result);
        }
    }

    private static void checkRes(int x, int y, String res) {
//        if (res.equals("IMPOSSIBLE")) {
//            System.out.println(res + "(" + x+ ", "+ y+ ")");
//            return;
//        }
        int a = 0, b = 0;
        int i = 0;
        for (char c: res.toCharArray()) {
            int v = 1 << i;
            i++;
            if (c == 'S') b -= v;
            else if (c == 'N') b += v;
            else if (c == 'E') a += v;
            else if (c == 'W') a -= v;
            else throw new RuntimeException("Unknown char in res: " + c);
        }
        if (a != x || b != y) {
            throw new RuntimeException("Invalid result for ("+x+","+y+"): found ("+a+","+b+")");
        }
    }

    private static String solve(int x, int y) {
        List<Integer> res = new ArrayList<>();
        boolean xlast = false, ylast = false;
        boolean flipx = x < 0;
        boolean flipy = y < 0;
        x = Math.abs(x); y = Math.abs(y);
        for (int i=0; i<30; i++) {
            boolean a = getBit(x, i), b = getBit(y, i);
            if (!a && !b) {
                if (x < (1 << i) && y < (1 << i)) {
                    return getRes(res, flipx, flipy); // todo
                }
                if (res.size()==0) {
                    return "IMPOSSIBLE";
                }
                int v = res.get(res.size()-1);
                res.set(res.size()-1, (v+2)%4);
                if (xlast) {
                    res.add(0);
                } else if (ylast) {
                    res.add(1);
                }
            }
            else if (a && !b) {
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
            else sb.append(flipy ? 'N' : 'S');
        }
        return sb.toString();
    }

    private static boolean getBit(int x, int i) {
        return (x & (1 << i)) != 0;
    }
}