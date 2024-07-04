import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class Solution {
    private static long[] result;
    private static final Random random = new Random();

    public static void main(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        long testCases = Integer.parseInt(tokenizer.nextToken());
        long A = Long.parseLong(tokenizer.nextToken());
        long B = Long.parseLong(tokenizer.nextToken());

        for (int t = 0; t < testCases; t++) {
            result = null;
            long[] hit = getHit(reader);
            if (result == null) {
                long[] P1 = findLastHitY1(reader, hit[1], 1000000000, hit[0]);
                if (result == null) {
                    long[] P2 = findLastHitY2(reader, -1000000000, hit[1], hit[0]);
                    if (result == null) {
                        long[] P3 = findLastHitX(reader, hit[0], 1000000000, hit[1]);
                        if (result == null) {
                            double[] circle = calculateCircle(P1[0], P1[1], P2[0], P2[1], P3[0], P3[1]);
                            long[][] solutions = {
                                    {(long) Math.floor(circle[0]), (long) Math.floor(circle[1])},
                                    {(long) Math.floor(circle[0]), (long) Math.ceil(circle[1])},
                                    {(long) Math.ceil(circle[0]), (long) Math.floor(circle[1])},
                                    {(long) Math.ceil(circle[0]), (long) Math.ceil(circle[1])}
                            };
                            for (long[] solution : solutions) {
                                if (result == null) {
                                    System.out.println(solution[0] + " " + solution[1]);
                                    String response = reader.readLine();
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
    }

    private static long[] findLastHitX(BufferedReader reader, long A, long B, long Y) throws Throwable {
        while (B - A > 1 && result == null) {
            long mid = (A + B) / 2;
            System.out.println(mid + " " + Y);
            String response = reader.readLine();
            if (response.equals("HIT")) {
                A = mid;
            } else if (response.equals("CENTER")) {
                result = new long[]{mid, Y};
            } else {
                B = mid;
            }
        }
        if (result == null) {
            System.out.println(B + " " + Y);
            if (reader.readLine().equals("HIT")) {
                return new long[]{B, Y};
            }
            return new long[]{A, Y};
        }
        return null;
    }

    private static long[] findLastHitY1(BufferedReader reader, long A, long B, long X) throws Throwable {
        while (B - A > 1 && result == null) {
            long mid = (A + B) / 2;
            System.out.println(X + " " + mid);
            String response = reader.readLine();
            if (response.equals("HIT")) {
                A = mid;
            } else if (response.equals("CENTER")) {
                result = new long[]{X, mid};
            } else {
                B = mid;
            }
        }
        if (result == null) {
            System.out.println(X + " " + B);
            if (reader.readLine().equals("HIT")) {
                return new long[]{X, B};
            }
            return new long[]{X, A};
        }
        return null;
    }

    private static long[] findLastHitY2(BufferedReader reader, long A, long B, long X) throws Throwable {
        while (B - A > 1 && result == null) {
            long mid = (A + B) / 2;
            System.out.println(X + " " + mid);
            String response = reader.readLine();
            if (response.equals("HIT")) {
                B = mid;
            } else if (response.equals("CENTER")) {
                result = new long[]{X, mid};
            } else {
                A = mid;
            }
        }
        if (result == null) {
            System.out.println(X + " " + B);
            if (reader.readLine().equals("HIT")) {
                return new long[]{X, B};
            }
            return new long[]{X, A};
        }
        return null;
    }

    private static long[] getHit(BufferedReader reader) throws Throwable {
        while (result == null) {
            long x = random.nextInt(2000000001) - 1000000000;
            long y = random.nextInt(2000000001) - 1000000000;
            System.out.println(x + " " + y);
            String response = reader.readLine();
            if (response.equals("HIT")) {
                return new long[]{x, y};
            } else if (response.equals("CENTER")) {
                result = new long[]{x, y};
                return null;
            }
        }
        return null;
    }

    private static double[] calculateCircle(double x1, double y1, double x2, double y2, double x3, double y3) {
        double xMid1 = (x1 + x2) / 2, yMid1 = (y1 + y2) / 2;
        double xMid2 = (x3 + x2) / 2, yMid2 = (y3 + y2) / 2;
        double[] center = findIntersection(xMid1, yMid1, xMid1 + y2 - y1, yMid1 + x1 - x2, xMid2, yMid2, xMid2 + y2 - y3, yMid2 + x3 - x2);
        double cx = center[0], cy = center[1];
        return new double[]{cx, cy, Math.sqrt((cx - x1) * (cx - x1) + (cy - y1) * (cy - y1))};
    }

    private static double[] findIntersection(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        double dx1 = x2 - x1, dx2 = x4 - x3, dx3 = x1 - x3;
        double dy1 = y2 - y1, dy2 = y4 - y3, dy3 = y1 - y3;
        double denominator = dy2 * dx1 - dx2 * dy1;
        double numerator = dx2 * dy3 - dy2 * dx3;
        return Math.abs(denominator) < 1e-11 ? null : new double[]{x1 + dx1 * numerator / denominator, y1 + dy1 * numerator / denominator};
    }
}