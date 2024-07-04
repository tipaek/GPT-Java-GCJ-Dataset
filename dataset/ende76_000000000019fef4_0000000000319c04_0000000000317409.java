import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static int manhattan(int x0, int y0, int x1, int y1) {
        return Math.abs(x1 - x0) + Math.abs(y1 - y0);
    }

    private static int solve(int X, int Y, String M) {
        int len = M.length();

        int xp = X;
        int yp = Y;

        for (int min = 0; min < len; min += 1) {
            char step = M.charAt(min);
            switch (step) {
                case 'N':
                    yp += 1;
                    break;
                case 'S':
                    yp -= 1;
                    break;
                case 'E':
                    xp += 1;
                    break;
                case 'W':
                    xp -= 1;
                    break;
            }
            //System.out.printf("xp: %d, yp: %d, manhattan: %d, min: %d\n", xp, yp, manhattan(0, 0, xp, yp), min);
            if (manhattan(0, 0, xp, yp) <= min + 1) return min + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();

        for (int t = 1; t <= T; t += 1) {
            int X = s.nextInt();
            int Y = s.nextInt();
            String M = s.nextLine().trim();


            int result = solve(X, Y, M);


            System.out.printf("Case #%d: %s\n", t, result == -1 ? "IMPOSSIBLE" : result);
        }
    }
}
