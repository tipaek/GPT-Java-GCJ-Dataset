import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//         int tests = 9 * 9;
//        for (int test = 0; test <= tests; ++test) {
//            long x = -4 + ( test % 9);
//            long y = -4 + (test / 9);
//            long oldX = x;
//            long oldY = y;
            int tests = in.nextInt();
            for (int test = 1; test <= tests; ++test) {
            long x = in.nextLong();
            long y = in.nextLong();
            boolean xInverse = x < 0;
            x = Math.abs(x);
            boolean yInverse = y < 0;
            y = Math.abs(y);

            StringBuilder sb = new StringBuilder();
            boolean imp = false;
            while (x != 0 || y != 0) {
                boolean curX = (x & 1) == 1;
                boolean curY = (y & 1) == 1;
                if (curX == curY) {
                    imp = true;
                    break;
                }
                boolean nextX = (x & 2) == 2;
                boolean nextY = (y & 2) == 2;
                if (nextX == nextY) {
                    if (curX) {
                        if (x !=1 || y != 0) {
                            sb.append(xInverse ? "E" : "W");
                            x += 1;
                        } else {
                            sb.append(xInverse ? "W" : "E");
                        }
                    } else {
                        if (y != 1 || x != 0) {
                            sb.append(yInverse ? "N" : "S");
                            y += 1;
                        } else {
                            sb.append(yInverse ? "S" : "N");
                        }

                    }
                } else {
                    if (curX)
                        sb.append(xInverse ? "W" : "E");
                    else
                        sb.append(yInverse ? "S" : "N");
                }
                x = x >> 1;
                y = y >> 1;
            }
//                if (imp)
//                    System.out.print("Case #" + test + " " + oldX + " " + oldY + ": IMPOSSIBLE");
//                else {
//
//                    System.out.print("Case #" + test + " " + oldX + " " + oldY +": " + sb.toString());
//                }
                if (imp)
                    System.out.print("Case #" + test + ": IMPOSSIBLE");
                else {

                    System.out.print("Case #" + test  +": " + sb.toString());
                }
            System.out.println();

        }
    }
}