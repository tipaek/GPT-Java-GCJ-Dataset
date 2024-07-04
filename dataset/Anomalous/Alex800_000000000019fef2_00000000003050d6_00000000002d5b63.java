import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    static int A = 0;
    static int B = 0;

    public static int[] findHor(int x, int y, Scanner in) {
        int lboundary = Math.max(x - 2 * A, -1000000000);
        int rboundary = x;
        int Left = binaryFind(lboundary, rboundary, y, in, 1);
        if (Left == 1000000001) {
            return new int[]{Left, Left};
        }

        rboundary = x;
        lboundary = Math.min(x + 2 * A, 1000000000);
        int Right = binaryFind(rboundary, lboundary, y, in, -1);
        if (Right == 1000000001) {
            return new int[]{Right, Right};
        }

        return new int[]{Left, Right};
    }

    public static int findVer(int x, int y, Scanner in) {
        int lboundary = Math.max(y - 2 * A, -1000000000);
        int rboundary = y;
        return binaryFindV(lboundary, rboundary, x, in, 1);
    }

    public static int binaryFindV(int lboundary, int rboundary, int y, Scanner in, int L) {
        if (lboundary == rboundary) return lboundary;

        int M = (lboundary + rboundary) / 2;
        System.out.println(y + " " + M);
        String res = in.next();

        if (res.equals("CENTER")) return 1000000001;
        if (res.equals("HIT")) {
            System.out.println(y + " " + (M - L));
            String res2 = in.next();

            if (res2.equals("HIT")) return binaryFindV(lboundary, M - L, y, in, L);
            if (res2.equals("MISS")) return M;
            if (res2.equals("CENTER")) return M - L;
        } else {
            System.out.println(y + " " + (M + L));
            String res2 = in.next();

            if (res2.equals("HIT") || res2.equals("CENTER")) return M + L;
            return binaryFindV(M + L, rboundary, y, in, L);
        }
        return 1000000001;
    }

    public static int binaryFind(int lboundary, int rboundary, int y, Scanner in, int L) {
        if (lboundary == rboundary) return lboundary;

        int M = (lboundary + rboundary) / 2;
        System.out.println(M + " " + y);
        String res = in.next();

        if (res.equals("CENTER")) return 1000000001;
        if (res.equals("HIT")) {
            System.out.println((M - L) + " " + y);
            String res2 = in.next();

            if (res2.equals("HIT")) return binaryFind(lboundary, M - L, y, in, L);
            if (res2.equals("CENTER")) return M - L;
            if (res2.equals("MISS")) return M;
        } else {
            System.out.println((M + L) + " " + y);
            String res2 = in.next();

            if (res2.equals("CENTER") || res2.equals("HIT")) return M + L;
            return binaryFind(M + L, rboundary, y, in, L);
        }
        return 1000000001;
    }

    public static void solve(String s, Scanner in) {
        int ind = s.indexOf(" ");
        int x = Integer.parseInt(s.substring(0, ind));
        int y = Integer.parseInt(s.substring(ind + 1));

        int[] hor = findHor(x, y, in);
        if (hor[0] == 1000000001) return;

        int lower = findVer(x, y, in);
        if (lower == 1000000001) return;

        int up = y + (x - hor[0]) * (hor[1] - x) / (y - lower);

        int centerX = (hor[0] + hor[1]) / 2;
        int centerY = (lower + up) / 2;

        System.out.println(centerX + " " + centerY);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();
        A = in.nextInt();
        B = in.nextInt();

        for (int t = 1; t <= T; ++t) {
            String[] guesses = {
                "0 0", "1000000000 1000000000",
                "-1000000000 1000000000", "1000000000 -1000000000",
                "-1000000000 -1000000000"
            };
            boolean hit = false;
            int count = 0;

            while (!hit) {
                String guess = guesses[count];
                System.out.println(guess);
                String s = in.next();
                if (s.equals("CENTER")) return;
                if (s.equals("HIT")) hit = true;
                count++;
            }

            solve(guesses[--count], in);
        }
        in.close();
    }
}