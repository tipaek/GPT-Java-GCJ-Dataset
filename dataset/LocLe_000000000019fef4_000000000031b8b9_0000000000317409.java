import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 1; i <= t; i++) {
            int x = s.nextInt();
            int y = s.nextInt();
            String route = s.nextLine();
            int ret = solve(x, y, route);
            if (ret == -1) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + ret);
            }

        }
    }

    public static int solve(int x, int y, String route) {
        int count = 0;
        if (x == 0 && y == 0) {
            return 0;
        }
        for (char ch: route.toCharArray()) {
            if (ch == ' ') {
                continue;
            }
            if (ch == 'S') {
                y -= 1;
            }

            if (ch == 'N') {
                y += 1;
            }

            if (ch == 'E') {
                x += 1;
            }

            if (ch == 'W') {
                x -= 1;
            }
            count++;
            if (canArriveAt(x, y, count)) {
                return count;
            }
        }
        return -1;
    }

    public static boolean canArriveAt(int x, int y, int time) {
        return Math.abs(x) + Math.abs(y) <= time;
    }

}
