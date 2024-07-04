import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        int g = 1000000000;
        int[][] starts = { { -g / 2, -g / 2 }, { -g / 2, g / 2 }, { g / 2, -g / 2 }, { g / 2, g / 2 }, { 1, 1 } };
        for (int i = 1; i <= t; ++i) {
            boolean done = false;
            int[] start = { 0, 0 };

            for (int j = 0; j < starts.length; j++) {
                System.out.println(starts[j][0] + " " + starts[j][1]);

                System.out.flush();
                String res = in.nextLine();

                if (res.charAt(0) == 'C') {
                    done = true;
                    break;
                }
                if (res.charAt(0) == 'H') {
                    start = starts[j];
                    break;
                }
            }

            if (done)
                continue;
            int x2 = binarySearch(start[0], g, start[1], false, true, in);
            if (x2 == -1)
                continue;

            int x1 = binarySearch(-g, start[0], start[1], false, false, in);
            if (x1 == -1)
                continue;

            int y2 = binarySearch(start[1], g, start[0], true, true, in);
            if (y2 == -1)
                continue;

            int y1 = binarySearch(-g, start[1], start[0], true, false, in);
            if (y1 == -1)
                continue;

            System.out.println((x1 + (x2 - x1) / 2) + " " + (y1 + (y2 - y1) / 2));
            System.out.flush();
            String res = in.nextLine();

            if (res.charAt(0) != 'C')
                break;
        }
        in.close();
    }

    public static int binarySearch(int a, int b, int c, boolean vert, boolean sign, Scanner in) {
        if (b - a < 2) {
            return sign ? b : a;
        }
        int center = a + (b - a) / 2;
        String pair = vert ? (c + " " + center) : (center + " " + c);
        System.out.println(pair);

        System.out.flush();
        String res = in.nextLine();

        if (res.charAt(0) == 'C')
            return -1;
        if (res.charAt(0) == 'H') {
            if (sign) {
                return binarySearch(center + 1, b, c, vert, sign, in);
            } else {
                return binarySearch(a, center - 1, c, vert, sign, in);
            }
        }
        if (sign) {
            return binarySearch(a, center - 1, c, vert, sign, in);
        } else {
            return binarySearch(center + 1, b, c, vert, sign, in);
        }
    }
}