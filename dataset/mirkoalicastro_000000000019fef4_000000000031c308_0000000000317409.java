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
        int sol = solve(x, y, m.toCharArray());
        return sol == Integer.MAX_VALUE ? IMPOSSIBLE : String.valueOf(sol);
    }

    private static int solve(int x, int y, char[] m) {
        if (x == 0 && y == 0)
            return 0;
        for (int i=0; i<m.length; i++) {
            x = x(x, m, i);
            y = y(y, m, i);
            if (Math.abs(x) + Math.abs(y) <= i+1)
                return i+1;
        }
        return Integer.MAX_VALUE;
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