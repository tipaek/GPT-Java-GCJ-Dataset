import java.io.File;
import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
    private static final String USER_DIR = System.getProperty("user.dir");
    private static final String CNAME = MethodHandles.lookup().lookupClass().getName();
    private static final Random RAND = new Random();
    private static final TreeSet<Integer> POW2 = new TreeSet<>();
    private static final TreeMap<Integer, Integer> RANKS = new TreeMap<>();
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    static {
        for (int i = 0; i < 31; i++) {
            int value = 1 << i;
            RANKS.put(value, i);
            POW2.add(value);
        }
    }

    private static String join(Collection<?> objs) {
        StringBuilder sb = new StringBuilder();
        Iterator<?> it = objs.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) sb.append(',');
        }
        return sb.toString();
    }

    private static boolean select(boolean ok1, boolean ok2, StringBuilder sb1, StringBuilder sb2, StringBuilder sb) {
        if (ok1 && ok2) {
            int i = sb1.length() - 1;
            while (i >= 0 && sb1.charAt(i) == ' ') i--;
            int j = sb2.length() - 1;
            while (j >= 0 && sb2.charAt(j) == ' ') j--;
            sb.setLength(0);
            sb.append(i <= j ? sb1 : sb2);
            return true;
        } else if (ok1) {
            sb.setLength(0);
            sb.append(sb1);
            return true;
        } else if (ok2) {
            sb.setLength(0);
            sb.append(sb2);
            return true;
        }
        return false;
    }

    private static boolean solve(int x, int y, StringBuilder sb) {
        if (x == 0 && y == 0) {
            int i = sb.length() - 1;
            while (i >= 0 && sb.charAt(i) == ' ') i--;
            for (int j = 0; j < i; j++) {
                if (sb.charAt(j) == ' ') return false;
            }
            return true;
        }

        if (x != 0) {
            int absX = Math.abs(x);
            int f = POW2.floor(absX);
            int c = POW2.ceiling(absX);
            int rf = RANKS.get(f);
            int rc = RANKS.get(c);
            char direction = x > 0 ? 'E' : 'W';

            if (c == f) {
                if (sb.charAt(rc) != ' ') return false;
                sb.setCharAt(rc, direction);
                boolean ok = solve(0, y, sb);
                if (!ok) sb.setCharAt(rc, ' ');
                return ok;
            } else {
                boolean ok1 = false, ok2 = false;
                StringBuilder s1 = null, s2 = null;

                if (sb.charAt(rc) == ' ') {
                    s1 = new StringBuilder(sb);
                    s1.setCharAt(rc, direction);
                    ok1 = solve(x > 0 ? x - c : x + c, y, s1);
                }

                if (sb.charAt(rf) == ' ') {
                    s2 = new StringBuilder(sb);
                    s2.setCharAt(rf, direction);
                    ok2 = solve(x > 0 ? x - f : x + f, y, s2);
                }

                return select(ok1, ok2, s1, s2, sb);
            }
        }

        if (y != 0) {
            int absY = Math.abs(y);
            int f = POW2.floor(absY);
            int c = POW2.ceiling(absY);
            int rf = RANKS.get(f);
            int rc = RANKS.get(c);
            char direction = y > 0 ? 'N' : 'S';

            if (c == f) {
                if (sb.charAt(rc) != ' ') return false;
                sb.setCharAt(rc, direction);
                boolean ok = solve(x, 0, sb);
                if (!ok) sb.setCharAt(rc, ' ');
                return ok;
            } else {
                boolean ok1 = false, ok2 = false;
                StringBuilder s1 = null, s2 = null;

                if (sb.charAt(rc) == ' ') {
                    s1 = new StringBuilder(sb);
                    s1.setCharAt(rc, direction);
                    ok1 = solve(x, y > 0 ? y - c : y + c, s1);
                }

                if (sb.charAt(rf) == ' ') {
                    s2 = new StringBuilder(sb);
                    s2.setCharAt(rf, direction);
                    ok2 = solve(x, y > 0 ? y - f : y + f, s2);
                }

                return select(ok1, ok2, s1, s2, sb);
            }
        }

        return false;
    }

    private static String solveMe(int x, int y) {
        StringBuilder sb = new StringBuilder(" ".repeat(32));
        boolean ok = solve(x, y, sb);
        return ok ? sb.toString().trim() : IMPOSSIBLE;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File fin = new File(USER_DIR + "/io/" + CNAME + ".in");
        Scanner in = fin.exists() ? new Scanner(fin) : new Scanner(System.in);
        int T = in.nextInt();

        for (int t = 1; t <= T; t++) {
            int X = in.nextInt();
            int Y = in.nextInt();
            System.out.format("Case #%d: %s\n", t, solveMe(X, Y));
        }
        in.close();
    }
}