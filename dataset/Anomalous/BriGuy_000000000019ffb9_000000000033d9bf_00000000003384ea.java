import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            long L = Long.parseLong(st.nextToken());
            long R = Long.parseLong(st.nextToken());

            long init = Math.abs(L - R);
            long l = 0, r = init, ans = (l + r) / 2;

            while (l <= r) {
                if (l == r) break;
                if (l == r - 1) {
                    if (isValid(l, init, Math.max(L, R)) && !((ans * (ans + 1)) / 2 <= Math.max(L, R))) {
                        ans = r;
                    } else {
                        ans = l;
                    }
                    break;
                }

                ans = (l + r) / 2;
                if (isValid(ans, init, Math.max(L, R)) && !((ans * (ans + 1)) / 2 <= Math.max(L, R))) {
                    r = ans;
                } else {
                    l = ans;
                }
            }

            long max = Math.max(L, R);

            if (L >= R) {
                L -= ans * (ans + 1) / 2;
            } else {
                R -= ans * (ans + 1) / 2;
            }

            long leftover = L;
            long rightover = R;
            long x = ans + 1;

            if (ans * (ans + 1) / 2 >= init) {
                if (x % 2 == 0) {
                    if (L < R) {
                        adjustValuesForEvenX(L, R, ans, x);
                    } else {
                        adjustValuesForEvenX(R, L, ans, x);
                    }
                } else {
                    if (L < R) {
                        adjustValuesForOddX(L, R, ans, x);
                    } else {
                        adjustValuesForOddX(R, L, ans, x);
                    }
                }
            }

            System.out.println("Case #" + t + ": " + ans + " " + leftover + " " + rightover);
        }
    }

    private static void adjustValuesForEvenX(long L, long R, long ans, long x) {
        L += (x / 2) * (x / 2);
        long temp = (long) Math.sqrt(L);
        long leftover = L - temp * temp;
        temp = updateTempAndRightover(R, ans, temp, leftover);
        ans = temp;
    }

    private static void adjustValuesForOddX(long L, long R, long ans, long x) {
        long a = 0, b = L, mid = (a + b) / 2;
        while (a <= b) {
            if (a == b) {
                mid = a;
                break;
            }
            if (a == b - 1) {
                if (isValidForOddX(b, ans, L)) mid = b;
                else mid = a;
                break;
            }
            mid = (a + b) / 2;
            if (isValidForOddX(mid, ans, L)) {
                a = mid;
            } else {
                b = mid;
            }
        }

        if (mid % 2 == 1) mid--;

        long leftover = L - (mid / 2) * (mid / 2 + 1) + (ans / 2 * (ans / 2 + 1));
        long rightover = R + (x / 2) * (x / 2) - (mid / 2) * (mid / 2);
        if (rightover >= mid + 1) {
            rightover -= mid + 1;
            mid++;
        }

        ans = mid;
    }

    private static long updateTempAndRightover(long R, long ans, long temp, long leftover) {
        temp *= 2;
        temp--;
        long rightover = R - (temp / 2) * (temp / 2 + 1) + (ans / 2 * (ans / 2 + 1));
        if (rightover > temp + 1) {
            rightover -= temp + 1;
            temp++;
        }
        return temp;
    }

    private static boolean isValidForOddX(long a, long ans, long b) {
        return (b - (a / 2) * (a / 2 + 1) + (ans / 2 * (ans / 2 + 1)) >= 0);
    }

    private static boolean isValid(long a, long b, long max) {
        long x = (a * (a + 1)) / 2;
        return (x >= b);
    }
}