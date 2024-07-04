
import java.util.Scanner;

public class Solution {

    private Scanner sc = new Scanner(System.in);

    private long find(int dir) {
        long left = 0;
        long right = 1000000000;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (dir == 0) {
                System.out.println(String.format("%d %d", 0, mid));
            } else if (dir == 1) {
                System.out.println(String.format("%d %d", 0, -mid));
            } else {
                System.out.println(String.format("%d %d", mid, 0));
            }
            System.out.flush();

            String ret = sc.next();
            if (ret.equals("CENTER")) {
                break;
            } else if (ret.equals("HIT")) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private void solve() {
        long A = sc.nextInt();
        long B = sc.nextInt();

        long x1 = 0;
        long y1 = find(0);

        long x2 = 0;
        long y2 = -find(1);

        long x3 = find(2);
        long y3 = 0;

        long e = 2 * (x2 - x1);
        long f = 2 * (y2 - y1);
        long g = x2 * x2 - x1 * x1 + y2 * y2 - y1 * y1;
        long a = 2 * (x3 - x2);
        long b = 2 * (y3 - y2);
        long c = x3 * x3 - x2 * x2 + y3 * y3 - y2 * y2;

        long X = (g * b - c * f) / (e * b - a * f);
        long Y = (a * g - c * e) / (a * f - b * e);

        System.out.println(String.format("%d %d", X, Y));
        System.out.flush();

        sc.next();
    }

    private void run() {
        int T = sc.nextInt();
        for (int i = 1; i <= T; ++i) {
            solve();
        }
    }
    public static void main(String[] args) {
        new Solution().run();
    }
}
