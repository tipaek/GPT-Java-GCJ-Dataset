import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 1; i <= cases; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            String s = in.next();
            int r = foo(x, y, s);
            String a = r == -1 ? "IMPOSSIBLE" : r + "";
            System.out.println("Case #" + i + ": " + a);
        }
    }

    private static int foo(int x, int y, String s) {
        int m = s.length();
        if (x == 0 && y == 0) {
            return 0;
        }
        int i = 0;
        for (; i < m; i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                default:
                    break;
            }
            if (x == 0 && y == 0) {
                return i + 1;
            }
            int xa = Math.abs(x);
            int ya = Math.abs(y);
            if (xa > ya) {
                if (x > 0) {
                    x--;
                } else {
                    x++;
                }
            } else if (ya > xa) {
                if (y > 0) {
                    y--;
                } else {
                    y++;
                }
            } else { // xa == ya
                if (i == m - 1) {
                    return -1;
                }
                if (x < 0 && s.charAt(i + 1) == 'E') {
                    y--;
                } else if (x > 0 && s.charAt(i + 1) == 'W') {
                    if (y > 0) {
                        y--;
                    } else {
                        y++;
                    }
                } else if (y < 0 && s.charAt(i + 1) == 'N') {
                    x--;
                } else if (y > 0 && s.charAt(i + 1) == 'S') {
                    if (x > 0) {
                        x--;
                    } else {
                        x++;
                    }
                } else {
                    switch (s.charAt(i + 1)) {
                        case 'E':
                            x--;
                            break;
                        case 'W':
                            x++;
                            break;
                        case 'N':
                            y--;
                            break;
                        case 'S':
                            y++;
                            break;
                    }
                }
            }
            if (x == 0 && y == 0) {
                return i + 1;
            }
        }
        return -1;
    }

}
