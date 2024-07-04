import java.io.File;
import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;
import java.util.*;

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
        boolean first = true;
        for (Object obj : objs) {
            if (!first) sb.append(',');
            sb.append(obj);
            first = false;
        }
        return sb.toString();
    }

    private static boolean select(boolean ok1, boolean ok2, StringBuilder sb1, StringBuilder sb2, StringBuilder sb) {
        if (ok1 && ok2) {
            String s1 = sb1.toString().trim();
            String s2 = sb2.toString().trim();
            sb.setLength(0);
            sb.append(s1.length() <= s2.length() ? sb1 : sb2);
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
            while (i >= 0 && sb.charAt(i) == ' ') {
                i--;
            }
            for (int j = 0; j < i; j++) {
                if (sb.charAt(j) == ' ') {
                    return false;
                }
            }
            return true;
        }

        if (x != 0) {
            return handleCoordinate(x, y, sb, x > 0 ? 'E' : 'W');
        } else if (y != 0) {
            return handleCoordinate(y, x, sb, y > 0 ? 'N' : 'S');
        }

        return false;
    }

    private static boolean handleCoordinate(int primary, int secondary, StringBuilder sb, char direction) {
        int absPrimary = Math.abs(primary);
        int f = POW2.floor(absPrimary);
        int c = POW2.ceiling(absPrimary);
        int rf = RANKS.get(f);
        int rc = RANKS.get(c);

        if (c == f) {
            if (sb.charAt(rc) != ' ') {
                return false;
            }
            StringBuilder s = new StringBuilder(sb);
            s.setCharAt(rc, direction);
            boolean ok = solve(primary > 0 ? 0 : 0, secondary, s);
            return select(ok, false, s, null, sb);
        } else {
            boolean ok1 = false;
            StringBuilder s1 = null;
            if (sb.charAt(rc) == ' ') {
                s1 = new StringBuilder(sb);
                s1.setCharAt(rc, direction);
                ok1 = solve(primary > 0 ? primary - c : primary + c, secondary, s1);
            }
            boolean ok2 = false;
            StringBuilder s2 = null;
            if (sb.charAt(rf) == ' ') {
                s2 = new StringBuilder(sb);
                s2.setCharAt(rf, direction);
                ok2 = solve(primary > 0 ? primary - f : primary + f, secondary, s2);
            }
            return select(ok1, ok2, s1, s2, sb);
        }
    }

    private static String solveMe(int x, int y) {
        StringBuilder sb = new StringBuilder("                                "); // 32 spaces
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