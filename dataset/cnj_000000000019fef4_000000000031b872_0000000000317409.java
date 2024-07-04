import java.io.PrintStream;
import java.util.Scanner;

class Solution {

    PrintStream out = System.out;
    Scanner sc = new Scanner(System.in);

    private void solve() {
        int px = sc.nextInt();
        int py = sc.nextInt();
        int sx = 0, sy = 0;
        char[] m = sc.next().toCharArray();
        String sol = "IMPOSSIBLE";
        for (int i = 0; i < m.length; i++) {
            char move = m[i];
            switch (move) {
                case 'N':
                    py++;
                    break;
                case 'S':
                    py--;
                    break;
                case 'E':
                    px++;
                    break;
                case 'W':
                    px--;
                    break;
                default:
                    break;
            }
            int curD = distance(0, 0, px, py);
            if (curD <= i + 1) {
                sol = String.valueOf(i + 1);
                break;
            }
        }
        out.println(sol);

    }

    int distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }


    private void call() throws Exception {
        long t = sc.nextLong();
        for (long i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");
            solve();
        }
        sc.close();
        out.close();
    }

    public static void main(String args[]) throws Exception {
        new Solution().call();
    }
}