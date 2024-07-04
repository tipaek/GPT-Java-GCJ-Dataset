
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner myReader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = Integer.parseInt(myReader.nextLine());
        for (int i = 0; i < T; i++) {
            int x = myReader.nextInt();
            int y = myReader.nextInt();
            String m = myReader.nextLine();

            int res = numOfMoves(x, y, m);
            System.out.println("Case #" + (i + 1) + ": " + (res == -1 ? "IMPOSSIBLE" : res));
        }

        myReader.close();
    }

    private static int numOfMoves(int x, int y, String m) {
        for (int i = 0; i < m.length(); i++) {
            if (m.charAt(i) == 'S') {
                y -= 1;
            }
            if (m.charAt(i) == 'N') {
                y += 1;
            }
            if (m.charAt(i) == 'E') {
                x += 1;
            }
            if (m.charAt(i) == 'W') {
                x -= 1;
            }
            int minute = i + 1;
            if (Math.abs(x) + Math.abs(y) >= minute) continue;

            if (isReachable(0, 0, x, y, 0, minute)) {
                return i;
            }

        }
        return -1;
    }

    static boolean isReachable(int sx, int sy,
                               int dx, int dy, int n, int minute) {

        if (n == minute)
            return false;

        if (sx == dx && sy == dy) {
            return true;
        }
        n++;
        return isReachable(sx + 1, sy, dx, dy, n, minute) ||
                isReachable(sx, sy + 1, dx, dy, n, minute) ||
                isReachable(sx, sy - 1, dx, dy, n, minute) ||
                isReachable(sx - 1, sy, dx, dy, n, minute);
    }

}
