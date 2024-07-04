/**
 * @author egaeus
 * @date 04/04/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Solution {
    static long[] result;

    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        long T = parseInt(st.nextToken());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        for (int t = 0; t < T; t++) {
            result = null;
            long[] hit = getHit(in);
            if (result == null) {
                long[] P1 = lastHitY1(in, hit[1], 1000000000, hit[0]);
                //System.out.println(Arrays.toString(P1));
                if (result == null) {
                    long[] P2 = lastHitY2(in, -1000000000, hit[1], hit[0]);
                    //System.out.println(Arrays.toString(P2));
                    if (result == null) {
                        long[] P3 = lastHitX(in, hit[0], 1000000000, hit[1]);
                        //System.out.println(Arrays.toString(P3));
                        if (result == null) {
                            double[] circulo = circulo3P(P1[0], P1[1], P2[0], P2[1], P3[0], P3[1]);
                            //System.out.println(Arrays.toString(circulo));
                            long[][] solutions = new long[][]{
                                    {(long) Math.floor(circulo[0]), (long) Math.floor(circulo[1])},
                                    {(long) Math.floor(circulo[0]), (long) Math.ceil(circulo[1])},
                                    {(long) Math.ceil(circulo[0]), (long) Math.floor(circulo[1])},
                                    {(long) Math.ceil(circulo[0]), (long) Math.ceil(circulo[1])}
                            };
                            for (int i = 0; i < solutions.length && result == null; i++) {
                                System.out.println(solutions[i][0]+" "+solutions[i][1]);
                                String L = in.readLine();
                                if(L.equals("CENTER"))
                                    result = solutions[i];
                            }

                        }
                    }
                }
            }
        }
    }

    static Random random = new Random();

    public static long[] lastHitX(BufferedReader in, long A, long B, long Y) throws Throwable {
        while (B - A > 1 && result == null) {
            long P = (A + B) / 2;
            System.out.println(P + " " + Y);
            String L = in.readLine();
            if (L.equals("HIT"))
                A = P;
            else if (L.equals("CENTER"))
                result = new long[]{P, Y};
            else
                B = P;
        }
        if (result == null) {
            System.out.println(B + " " + Y);
            if (in.readLine().equals("HIT"))
                return new long[]{B, Y};
            return new long[]{A, Y};
        }
        return null;
    }


    public static long[] lastHitY1(BufferedReader in, long A, long B, long X) throws Throwable {
        while (B - A > 1 && result == null) {
            long P = (A + B) / 2;
            System.out.println(X + " " + P);
            String L = in.readLine();
            if (L.equals("HIT"))
                A = P;
            else if (L.equals("CENTER"))
                result = new long[]{X, P};
            else
                B = P;
        }
        if (result == null) {
            System.out.println(X + " " + B);
            if (in.readLine().equals("HIT"))
                return new long[]{X, B};
            return new long[]{X, A};
        }
        return null;
    }

    public static long[] lastHitY2(BufferedReader in, long A, long B, long X) throws Throwable {
        while (B - A > 1 && result == null) {
            long P = (A + B) / 2;
            System.out.println(X + " " + P);
            String L = in.readLine();
            if (L.equals("HIT"))
                B = P;
            else if (L.equals("CENTER"))
                result = new long[]{X, P};
            else
                A = P;
        }
        if (result == null) {
            System.out.println(X + " " + B);
            if (in.readLine().equals("HIT"))
                return new long[]{X, B};
            return new long[]{X, A};
        }
        return null;
    }

    public static long[] getHit(BufferedReader in) throws Throwable {
        while (result == null) {
            long x = random.nextInt(2000000001) - 1000000000;
            long y = random.nextInt(2000000001) - 1000000000;
            System.out.println(x + " " + y);
            String L = in.readLine();
            if (L.equals("HIT"))
                return new long[]{x, y};
            else if (L.equals("CENTER")) {
                result = new long[]{x, y};
                return null;
            }
        }
        return null;
    }

    static double[] intLineas(double x1, double y1, double x2, double y2,
                              double x3, double y3, double x4, double y4) {
        double xa = x2 - x1, xb = x4 - x3, xc = x1 - x3, ya = y2 - y1, yb = y4 - y3, yc = y1 - y3, d = yb * xa - xb * ya, n = xb * yc - yb * xc;
        return Math.abs(d) < 1e-11 ? null : new double[]{x1 + xa * n / d, y1 + ya * n / d};
    }

    static double[] circulo3P(double x1, double y1, double x2, double y2, double x3, double y3) {
        double x4 = (x1 + x2) / 2, y4 = (y1 + y2) / 2, x5 = (x3 + x2) / 2, y5 = (y3 + y2) / 2;
        double c[] = intLineas(x4, y4, x4 + y2 - y1, y4 + x1 - x2, x5, y5, x5 + y2 - y3, y5 + x3 - x2), cx = c[0], cy = c[1];
        return new double[]{cx, cy, Math.sqrt((cx - x1) * (cx - x1) + (cy - y1) * (cy - y1))};
    }

}
