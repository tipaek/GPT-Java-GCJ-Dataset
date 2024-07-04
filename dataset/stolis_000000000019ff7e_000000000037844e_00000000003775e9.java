import java.awt.Point;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t=1; t<=T; t++) {
            int N = in.nextInt();
            if (N != 2) return;
            int D = in.nextInt();
            Point p1 = new Point(in.nextInt(), in.nextInt());
            Point p2 = new Point(in.nextInt(), in.nextInt());
            p2.x -= p1.x;
            p2.y -= p1.y;
            p2.x = Math.abs(p2.x);
            p2.y = Math.abs(p2.y);
            int x;
            int y;
            if (p2.x < p2.y) {
                x = p2.y;
                y = p2.x;
            } else {
                x = p2.x;
                y = p2.y;
            }
            long up;
            long down;
            if (x + y >= 2*D) {
                up = 0;
                down = 1;
            } else {
                long realalpha = 2*D-x-y; // /2
                long alpha = Math.min(realalpha, D); // / 2
                long beta = realalpha + 2*y; // /2
                long area = (alpha + beta)*(alpha + beta) - alpha*alpha - beta*beta; // /4
                long total = 16*D*D - area; // /4
                long good = 3*area;
                up = good;
                down = total;
            }
            long gcd = gcd(down, up);
            up /= gcd;
            down /= gcd;
            System.out.printf("Case #%d: %d %d\n", t, up, down);
        }
    }

    static long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a%b);
    }

}
