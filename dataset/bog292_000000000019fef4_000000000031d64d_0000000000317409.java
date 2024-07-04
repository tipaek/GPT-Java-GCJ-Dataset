

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        //Scanner in = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/overexfan/input.txt"))));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int nr = 1; nr <= t; nr++) {
            int x = in.nextInt();
            int y = in.nextInt();

            String str = in.next();

            solve(nr, x, y, str);
        }
    }

    private static void solve(int nr, int x, int y, String str) {
        int dx = x;
        int dy = y;
        int t = 0;

        int res = -1;

        for (int i = 0; i < str.length(); i++) {
            t++;

            char c = str.charAt(i);

            if (c == 'N') dy++;
            else if (c == 'S') dy--;
            else if (c == 'E') dx++;
            else if (c == 'W') dx--;

            if (dist(dx, dy) <= t) {
                res = i + 1;
                break;
            }
        }

        System.out.print("Case #" + nr + ": ");
        if (res == -1) System.out.print("IMPOSSIBLE");
        else System.out.print(res);

        System.out.println();
    }

    private static int dist (int x, int y) {
        return Math.abs(x) + Math.abs(y);
    }
}
