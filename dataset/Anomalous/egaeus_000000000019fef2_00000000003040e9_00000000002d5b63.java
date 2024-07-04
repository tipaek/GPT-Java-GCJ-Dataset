import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class Solution {
    static long[] result;
    static Random random = new Random();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        long T = Integer.parseInt(st.nextToken());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        for (int t = 0; t < T; t++) {
            result = null;
            long[] hit = getHit(in);
            if (result == null) {
                long[] P1 = findLastHitY1(in, hit[1], 1000000000, hit[0]);
                if (result == null) {
                    long[] P2 = findLastHitY2(in, -1000000000, hit[1], hit[0]);
                    if (result == null) {
                        long[] P3 = findLastHitX(in, hit[0], 1000000000, hit[1]);
                        if (result == null) {
                            double[] circle = calculateCircle(P1[0], P1[1], P2[0], P2[1], P3[0], P3[1]);
                            searchCenter(in, circle);
                        }
                    }
                }
            }
        }
    }

    public static long[] findLastHitX(BufferedReader in, long A, long B, long Y) throws Exception {
        while (B - A > 1 && result == null) {
            long P = (A + B) / 2;
            System.out.println(P + " " + Y);
            String response = in.readLine();
            if (response.equals("HIT")) {
                A = P;
            } else if (response.equals("CENTER")) {
                result = new long[]{P, Y};
            } else {
                B = P;
            }
        }
        if (result == null) {
            System.out.println(B + " " + Y);
            if (in.readLine().equals("HIT")) {
                return new long[]{B, Y};
            }
            return new long[]{A, Y};
        }
        return null;
    }

    public static long[] findLastHitY1(BufferedReader in, long A, long B, long X) throws Exception {
        while (B - A > 1 && result == null) {
            long P = (A + B) / 2;
            System.out.println(X + " " + P);
            String response = in.readLine();
            if (response.equals("HIT")) {
                A = P;
            } else if (response.equals("CENTER")) {
                result = new long[]{X, P};
            } else {
                B = P;
            }
        }
        if (result == null) {
            System.out.println(X + " " + B);
            if (in.readLine().equals("HIT")) {
                return new long[]{X, B};
            }
            return new long[]{X, A};
        }
        return null;
    }

    public static long[] findLastHitY2(BufferedReader in, long A, long B, long X) throws Exception {
        while (B - A > 1 && result == null) {
            long P = (A + B) / 2;
            System.out.println(X + " " + P);
            String response = in.readLine();
            if (response.equals("HIT")) {
                B = P;
            } else if (response.equals("CENTER")) {
                result = new long[]{X, P};
            } else {
                A = P;
            }
        }
        if (result == null) {
            System.out.println(X + " " + B);
            if (in.readLine().equals("HIT")) {
                return new long[]{X, B};
            }
            return new long[]{X, A};
        }
        return null;
    }

    public static long[] getHit(BufferedReader in) throws Exception {
        while (result == null) {
            long x = random.nextInt(2000000001) - 1000000000;
            long y = random.nextInt(2000000001) - 1000000000;
            System.out.println(x + " " + y);
            String response = in.readLine();
            if (response.equals("HIT")) {
                return new long[]{x, y};
            } else if (response.equals("CENTER")) {
                result = new long[]{x, y};
                return null;
            }
        }
        return null;
    }

    static double[] intersectLines(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        double xa = x2 - x1, xb = x4 - x3, xc = x1 - x3;
        double ya = y2 - y1, yb = y4 - y3, yc = y1 - y3;
        double d = yb * xa - xb * ya, n = xb * yc - yb * xc;
        return Math.abs(d) < 1e-11 ? null : new double[]{x1 + xa * n / d, y1 + ya * n / d};
    }

    static double[] calculateCircle(double x1, double y1, double x2, double y2, double x3, double y3) {
        double x4 = (x1 + x2) / 2, y4 = (y1 + y2) / 2;
        double x5 = (x3 + x2) / 2, y5 = (y3 + y2) / 2;
        double[] c = intersectLines(x4, y4, x4 + y2 - y1, y4 + x1 - x2, x5, y5, x5 + y2 - y3, y5 + x3 - x2);
        double cx = c[0], cy = c[1];
        return new double[]{cx, cy, Math.sqrt((cx - x1) * (cx - x1) + (cy - y1) * (cy - y1))};
    }

    static void searchCenter(BufferedReader in, double[] circle) throws Exception {
        for (int i = 0; result == null; i++) {
            for (int j = -1; j < 2; j += 2) {
                for (int k = 0; k < 2; k++) {
                    long[][] solutions = {
                        {(long) Math.floor(circle[0] + j * i * k), (long) Math.floor(circle[1] + j * i * (k + 1) % 2)},
                        {(long) Math.floor(circle[0] + j * i * k), (long) Math.ceil(circle[1] + j * i * (k + 1) % 2)},
                        {(long) Math.ceil(circle[0] + j * i * k), (long) Math.floor(circle[1] + j * i * (k + 1) % 2)},
                        {(long) Math.ceil(circle[0] + j * i * k), (long) Math.ceil(circle[1] + j * i * (k + 1) % 2)}
                    };
                    for (long[] solution : solutions) {
                        if (result == null) {
                            System.out.println(solution[0] + " " + solution[1]);
                            String response = in.readLine();
                            if (response.equals("CENTER")) {
                                result = solution;
                            }
                        }
                    }
                }
            }
        }
    }
}