import java.io.*;
import java.util.*;

class Solution {
    public static BufferedReader reader;
    public static final int MAX = 1000000000;
    public static int[] bound;
    public static String result;

    public static int find(int x1, int y1, int dir) throws IOException {
        int x2, y2;
        switch (dir) {
            case 0:
                y2 = MAX;
                break;
            case 1:
                x2 = MAX;
                break;
            case 2:
                y2 = -MAX;
                break;
            case 3:
                x2 = -MAX;
                break;
            default:
                throw new IllegalArgumentException("Invalid direction");
        }

        if (dir == 0 || dir == 2) {
            System.out.println(x1 + " " + y2);
        } else {
            System.out.println(x2 + " " + y1);
        }
        System.out.flush();
        result = reader.readLine();

        if (result.charAt(0) == 'C') return 0;

        if (result.charAt(0) == 'H') {
            bound[0] = (dir == 0 || dir == 2) ? x1 : x2;
            bound[1] = (dir == 0 || dir == 2) ? y2 : y1;
            return 1;
        }

        if (dir == 0 || dir == 2) {
            while ((dir == 0 && y2 > y1 + 1) || (dir == 2 && y2 < y1 - 1)) {
                int y0 = (y1 + y2) / 2;
                System.out.println(x1 + " " + y0);
                System.out.flush();
                result = reader.readLine();

                if (result.charAt(0) == 'C') return 0;

                if (result.charAt(0) == 'H') {
                    y1 = y0;
                } else {
                    y2 = y0;
                }
            }
        } else {
            while ((dir == 1 && x2 > x1 + 1) || (dir == 3 && x2 < x1 - 1)) {
                int x0 = (x1 + x2) / 2;
                System.out.println(x0 + " " + y1);
                System.out.flush();
                result = reader.readLine();

                if (result.charAt(0) == 'C') return 0;

                if (result.charAt(0) == 'H') {
                    x1 = x0;
                } else {
                    x2 = x0;
                }
            }
        }

        bound[0] = x1;
        bound[1] = y1;
        return 2;
    }

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int t = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for (int test = 1; test <= t; test++) {
            int[] x = new int[16];
            int[] y = new int[16];

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    x[4 * i + j] = -MAX + MAX / 5 * (i + 1) * 2;
                    y[4 * i + j] = -MAX + MAX / 5 * (j + 1) * 2;
                }
            }

            bound = new int[2];

            for (int i = 0; i < 16; i++) {
                System.out.println(x[i] + " " + y[i]);
                System.out.flush();
                result = reader.readLine();

                if (result.charAt(0) == 'C') break;

                if (result.charAt(0) == 'H') {
                    int cx = x[i], cy = y[i];
                    int xt, yt, xb, yb, xl, yl, xr, yr;

                    if (find(cx, cy, 0) == 0) break;
                    xt = bound[0];
                    yt = bound[1];

                    if (find(cx, cy, 1) == 0) break;
                    xr = bound[0];
                    yr = bound[1];

                    if (find(cx, cy, 2) == 0) break;
                    xb = bound[0];
                    yb = bound[1];

                    if (find(cx, cy, 3) == 0) break;
                    xl = bound[0];
                    yl = bound[1];

                    cx = (xl + xr) / 2;
                    cy = (yt + yb) / 2;

                    System.out.println(cx + " " + cy);
                    System.out.flush();
                    result = reader.readLine();

                    if (result.charAt(0) == 'C') break;
                    else System.exit(0);
                }
            }
        }
    }
}