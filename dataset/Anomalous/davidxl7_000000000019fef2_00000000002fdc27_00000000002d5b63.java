import java.util.Scanner;

public class Solution {
    static int A, B;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        A = in.nextInt();
        B = in.nextInt();
        
        for (int i = 0; i < T; i++) {
            solve(in);
        }
    }

    public static void solve(Scanner in) {
        int minx = 0, maxx = 1000000001;
        while (maxx > minx + 1) {
            int mid = (minx + maxx) / 2;
            String situation = query(in, mid, 0);
            if (situation.equals("CENTER")) return;
            if (situation.equals("MISS")) maxx = mid;
            else minx = mid;
        }
        int Ypos = minx;

        minx = -1000000000;
        maxx = 1;
        while (maxx > minx + 1) {
            int mid = (minx + maxx) / 2;
            String situation = query(in, mid, 0);
            if (situation.equals("CENTER")) return;
            if (situation.equals("MISS")) minx = mid;
            else maxx = mid;
        }
        int Yneg = maxx;

        int miny = 0, maxy = 1000000001;
        while (maxy > miny + 1) {
            int mid = (miny + maxy) / 2;
            String situation = query(in, 0, mid);
            if (situation.equals("CENTER")) return;
            if (situation.equals("MISS")) maxy = mid;
            else miny = mid;
        }
        int Xpos = miny;

        miny = -1000000000;
        maxy = 1;
        while (maxy > miny + 1) {
            int mid = (miny + maxy) / 2;
            String situation = query(in, 0, mid);
            if (situation.equals("CENTER")) return;
            if (situation.equals("MISS")) miny = mid;
            else maxy = mid;
        }
        int Xneg = maxy;

        int centerX = (Ypos + Yneg - 1) / 2;
        int centerY = (Xpos + Xneg - 1) / 2;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String situation = query(in, centerX + i, centerY + j);
                if (situation.equals("CENTER")) return;
            }
        }
    }

    public static String query(Scanner in, int x, int y) {
        System.out.println(x + " " + y);
        return in.next();
    }
}