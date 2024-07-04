import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

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
        return sol == Integer.MAX_VALUE ? IMPOSSIBLE : String.valueOf(sol);
    }

    private static int solve(int x, int y, char[] m, int minute) {
        if (x == 0 && y == 0)
            return minute;
        if (minute == m.length)
            return Integer.MAX_VALUE;
        x = x(x, m, minute);
        y = y(y, m, minute);
        int r1 = solve(x-1, y, m, minute+1);
        int r2 = solve(x, y-1, m, minute+1);
        int r3 = solve(x, y, m, minute+1);
        return min(r1, r2, r3);
    }

    private static int min(int r1, int r2, int r3) {
        if (r1 <= r2 && r1 <= r3) {
            return r1;
        }
        if (r2 <= r1 && r2 <= r3) {
            return r2;
        }
        return r3;
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