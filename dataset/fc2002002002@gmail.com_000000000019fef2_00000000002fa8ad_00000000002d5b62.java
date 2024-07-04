
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        for (int i = 0; i < tc; i++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            String re = get(x, y);

            System.out.println("Case #" + (i+1) + ": " + re);
        }
    }
    private static StringBuilder sb;
    private static long targetX, targetY;
    private static String get(long x, long y) {
        //System.out.println(x + ", " + y);
        if ((x%2 == 0) && (y%2 == 0)) return "IMPOSSIBLE";
        if ((x%2 != 0) && (y%2 != 0)) return "IMPOSSIBLE";
        sb = new StringBuilder();
        targetX = x;
        targetY = y;
        doRecur(targetX, targetY);
        return sb.toString();
    }
    private static void doRecur(long x, long y) {
        //System.out.println("(" + x +", " + y + ")");
        if (x == 1 && y == 0) {
            sb.append('E');
            return;
        }
        if (x == 0 && y == 1) {
            sb.append('N');
            return;
        }
        if (x == -1 && y == 0) {
            sb.append('W');
            return;
        }
        if (x == 0 && y == -1) {
            sb.append('S');
            return;
        }
        if (x%2 != 0) {
            long nextxp = (x + 1)/2;
            long nextxm = (x-1) /2;
            long nexty = y/2;
            if ((nextxp%2 == 0 && nexty%2 != 0) || (nextxp%2 != 0 && nexty%2 == 0)) {
                sb.append('W');
                doRecur(nextxp, nexty);
            }
            if ((nextxm%2 == 0 && nexty%2 != 0) || (nextxm%2 != 0 && nexty%2 == 0)) {

                sb.append('E');
                doRecur(nextxm, nexty);

            }



        } else if (y%2 != 0) {
            long nextyp = (y + 1)/2;
            long nextym = (y-1) /2;
            long nextx = x/2;
            if ((nextyp%2 == 0 && nextx%2 != 0) || (nextyp%2 != 0 && nextx%2 == 0)) {

                sb.append('S');
                doRecur(nextx, nextyp);
            }
            if ((nextx%2 == 0 && nextym%2 != 0) || (nextx%2 != 0 && nextym%2 == 0)) {

                sb.append('N');
                doRecur(nextx, nextym);

            }

        }
    }


}
