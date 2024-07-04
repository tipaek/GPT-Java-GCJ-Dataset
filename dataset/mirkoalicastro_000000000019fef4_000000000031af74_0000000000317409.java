import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;

public class Solution {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static int OPT = Integer.MAX_VALUE;

    public static void main(String...args) {
        final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int testCases = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String m = scanner.next();
            String sol = solve(x, y, m);
            sb.append("Case #").append(i).append(": ").append(sol).append('\n');
        }
        System.out.print(sb.toString());
    }

    private static String solve(int x, int y, String m) {
        int sol = solve(x, y, m.toCharArray(), 0);
        OPT = Integer.MAX_VALUE;
        return sol == Integer.MAX_VALUE ? IMPOSSIBLE : String.valueOf(sol);
    }

    private static int solve(int x, int y, char[] m, int minute) {
        if (x == 0 && y == 0) {
            OPT = Math.min(OPT, minute);
            return minute;
        }
        if (minute == m.length)
            return Integer.MAX_VALUE;
        if (minute > OPT)
            return Integer.MAX_VALUE;
        x = x(x, m, minute);
        y = y(y, m, minute);
        int r1 = solve(x-1, y, m, minute+1);
        int r2 = solve(x, y-1, m, minute+1);
        int r3 = solve(x, y, m, minute+1);
        int r4 = solve(x+1, y, m, minute+1);
        int r5 = solve(x, y+1, m, minute+1);
        return min(r1, r2, r3, r4, r5);
    }

    private static int min(int ...values) {
        int min = values[0];
        for (int i=1; i<values.length; i++)
            min = Math.min(min, values[i]);
        return min;
    }

    static int x(int x, char[] m, int minute) {
        switch (m[minute]) {
            case 'N':
            case 'S':
                return x;
            case 'E':
                return x+1;
            case 'W':
                return x-1;
        }
        return x;
    }
    static int y(int y, char[] m, int minute) {
        switch (m[minute]) {
            case 'E':
            case 'W':
                return y;
            case 'N':
                return y+1;
            case 'S':
                return y-1;
        }
        return y;
    }
}