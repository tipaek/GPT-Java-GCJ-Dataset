import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t1 = in.nextInt();
        for (int t = 1; t <= t1; t++) {
            long x = in.nextLong();
            long y = in.nextLong();
            int k1 = x < 0 ? -1 : 1;
            x *= k1;
            int k2 = y < 0 ? -1 : 1;
            y *= k2;
            if (x % 2 + y % 2 != 1) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                long p = 1;
                long p2 = 2;
                int n = 1;
                long s = x + y;
                while (p < s) {
                    p += p2;
                    p2 *= 2;
                    n++;
                }

                long[] minus = new long[n];
                int w = 1;
                for (int i = 0; i < n; i++) {
                    minus[i] = w;
                    w *= 2;
                }
                long q = (p - s) / 2;
                StringBuilder stringBuilder = new StringBuilder();
                while (q > 0) {
                    stringBuilder.append(q % 2);
                    q /= 2;
                }
                char[] chars = stringBuilder.toString().toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] == '1') {
                        minus[i] *= -1;
                    }
                }
                String result = "";
                long[] res = new long[n];
                for (int i = n - 1; i >= 0; i--) {
                    if (minus[i] > 0) {
                        if (x > y) {
                            x -= minus[i];
                            res[i] = minus[i];
                        } else {
                            y -= minus[i];
                        }
                    } else {
                        if (x < y) {
                            x -= minus[i];
                            res[i] = minus[i];
                        } else {
                            y -= minus[i];
                        }
                    }
                }
                result = findPath(minus, res, 0, k1, k2);

                /*for (int i = 0; i <= (n + 1) / 2; i++) {
                    long[] f = new long[n];
                    long[] res = findX(x, minus, f, i, 0);
                    if (res != null) {
                         result = findPath(minus, res, 0, k1, k2);
                         break;
                    }

                    f = new long[n];
                    res = findX(y, minus, f, i, 0);
                    if (res != null) {
                        result = findPath(minus, res, 1, k1, k2);
                        break;
                    }
                }*/

                System.out.println("Case #" + t + ": " + result);

            }


        }
    }

    static String findPath(long[] minus, long[] in, int isX, int k1, int k2) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] cx = {'W', 'E'};
        char[] cy = {'S', 'N'};

        for (int i = 0; i < minus.length; i++) {
            int turn = -1;
            int side = 0;
            if (in[i] != 0) {
                if (isX == 0) {
                    turn = 0;
                } else {
                    turn = 1;
                }
            } else {
                if (isX == 0) {
                    turn = 1;
                } else {
                    turn = 0;
                }
            }
            if (minus[i] > 0) {
                side = 1;
            } else {
                side = -1;
            }

            if (turn == 0) {
                if (side * k1 > 0) {
                    stringBuilder.append(cx[1]);
                } else {
                    stringBuilder.append(cx[0]);
                }
            } else {
                if (side * k2 > 0) {
                    stringBuilder.append(cy[1]);
                } else {
                    stringBuilder.append(cy[0]);
                }
            }
        }

        return stringBuilder.toString();
    }

    static long[] findX(long x, long[] minus, long[] in, int n, long s) {
        if (n == 0) {
            if (s == x) {
                return in;
            } else {
                return null;
            }
        } else {
            for (int i = 0; i < minus.length; i++) {
                if (in[i] == 0) {
                    in[i] = minus[i];
                    long[] res = findX(x, minus, in, n - 1, s + in[i]);
                    if (res != null) {
                        return res;
                    }
                    in[i] = 0;
                }
            }
        }
        return null;
    }
}