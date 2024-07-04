import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int a = in.nextInt();
        int b = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            solve(i, in, a, b);
        }
    }


    private static void solve(int caseNr, Scanner in, int a, int b) {
        int xStart, yStart;
        xStart = 0;
        yStart = 0;
        int[] points = {0, 0, -1, -1, -1, 1, 1, -1, 1, 1};

        for (int i = 0; i < points.length; i += 2) {
            xStart = 1000000000 / 2 * points[i];
            yStart = 1000000000 / 2 * points[i + 1];
            System.out.println(xStart + " " + yStart);
            System.out.flush();
            String response = in.nextLine();
            if (response.equals("CENTER")) {
                return;
            }
            if (response.equals("HIT")) {
                break;
            }
        }

        int xLeft, xRight;

        int xCenter;

        {
            // xstart, ystart inside the circle
            int xMin = -1000000001;
            int xMax = xStart;
            int y = yStart;

            while (xMin < xMax - 1) {
                int xMid = (xMin + xMax) / 2;
                System.out.println(xMid + " " + y);
                System.out.flush();
                String response = in.nextLine();
                if (response.equals("CENTER")) {
                    return;
                }
                if (response.equals("HIT")) {
                    xMax = xMid;
                } else {
                    xMin = xMid;
                }
            }

            xLeft = xMax;

            xMin = xStart;
            xMax = 1000000001;
            y = yStart;

            while (xMin < xMax - 1) {
                int xMid = (xMin + xMax) / 2;
                System.out.println(xMid + " " + y);
                System.out.flush();
                String response = in.nextLine();
                if (response.equals("CENTER")) {
                    return;
                }
                if (response.equals("HIT")) {
                    xMin = xMid;
                } else {
                    xMax = xMid;
                }
            }
            xRight = xMin;

            xCenter = (xLeft + xRight) / 2;
        }

        int yCenter;
        {
            // xstart, ystart inside the circle
            int yMin = -1000000001;
            int yMax = yStart;
            int x = xStart;

            while (yMin < yMax - 1) {
                int yMid = (yMin + yMax) / 2;
                System.out.println(x + " " + yMid);
                System.out.flush();
                String response = in.nextLine();
                if (response.equals("CENTER")) {
                    return;
                }
                if (response.equals("HIT")) {
                    yMax = yMid;
                } else {
                    yMin = yMid;
                }
            }

            int yLeft = yMax;

            yMin = yStart;
            yMax = 1000000001;
            x = xStart;

            while (yMin < yMax - 1) {
                int yMid = (yMin + yMax) / 2;
                System.out.println(x + " " + yMid);
                System.out.flush();
                String response = in.nextLine();
                if (response.equals("CENTER")) {
                    return;
                }
                if (response.equals("HIT")) {
                    yMin = yMid;
                } else {
                    yMax = yMid;
                }
            }
            int yRight = yMin;

            yCenter = (yLeft + yRight) / 2;

        }

        System.out.println(xCenter + " " + yCenter);
        System.out.flush();
        String response = in.nextLine();

    }
}