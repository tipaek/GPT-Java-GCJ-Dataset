import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
                    if (func(l, init, Math.max(L, R)) && !((ans * (ans + 1)) / 2 <= Math.max(L, R))) ans = r;
                    else ans = l;
                    break;
                }

                ans = (l + r) / 2;
                if (func(ans, init, Math.max(L, R)) && !((ans * (ans + 1)) / 2 <= Math.max(L, R))) r = ans;
                else l = ans;
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
                    handleEvenCase(L, R, ans, x);
                } else {
                    handleOddCase(L, R, ans, x);
                }
            }
        }
    }

    private static void handleEvenCase(long L, long R, long ans, long x) {
        long leftover, rightover, temp;
        if (L < R) {
            L += (x / 2) * (x / 2);
            temp = (long) Math.sqrt(L);
            leftover = L - temp * temp;

            temp = updateTempForEvenCase(R, ans, temp);
            rightover = R - (temp / 2) * (temp / 2 + 1) + (ans / 2 * (ans / 2 + 1));
            ans = updateAnsForEvenCase(rightover, temp);
        } else {
            R += (x / 2) * (x / 2);
            temp = (long) Math.sqrt(R);
            rightover = R - temp * temp;

            temp = updateTempForEvenCase(L, ans, temp);
            leftover = L - (temp / 2) * (temp / 2 + 1) + (ans / 2 * (ans / 2 + 1));
            ans = updateAnsForEvenCase(leftover, temp);
        }
    }

    private static long updateTempForEvenCase(long value, long ans, long temp) {
        temp *= 2;
        temp--;
        return temp;
    }

    private static long updateAnsForEvenCase(long over, long temp) {
        if (over > temp + 1) {
            over -= temp + 1;
            temp++;
        }
        return temp;
    }

    private static void handleOddCase(long L, long R, long ans, long x) {
        long leftover, rightover, mid;
        if (L < R) {
            mid = binarySearch(0, L, ans, L);
            if (mid % 2 == 1) mid--;

            leftover = L - (mid / 2) * (mid / 2 + 1) + (ans / 2 * (ans / 2 + 1));
            rightover = R + (x / 2) * (x / 2) - (mid / 2) * (mid / 2);
            ans = updateAnsForOddCase(rightover, mid);
        } else {
            mid = binarySearch(0, R, ans, R);
            if (mid % 2 == 1) mid--;

            rightover = R - (mid / 2) * (mid / 2 + 1) + (ans / 2 * (ans / 2 + 1));
            leftover = L + (x / 2) * (x / 2) - (mid / 2) * (mid / 2);
            ans = updateAnsForOddCase(leftover, mid);
        }
    }

    private static long binarySearch(long a, long b, long ans, long value) {
        long mid = (a + b) / 2;
        while (a <= b) {
            if (a == b) {
                mid = a;
                break;
            }

            if (a == b - 1) {
                if (func2(b, ans, value)) mid = b;
                else mid = a;
                break;
            }

            mid = (a + b) / 2;
            if (func2(mid, ans, value)) {
                a = mid;
            } else {
                b = mid;
            }
        }
        return mid;
    }

    private static long updateAnsForOddCase(long over, long mid) {
        if (over >= mid + 1) {
            over -= mid + 1;
            mid++;
        }
        return mid;
    }

    public static boolean func2(long a, long ans, long b) {
        return (b - (a / 2) * (a / 2 + 1) + (ans / 2 * (ans / 2 + 1)) >= 0);
    }

    public static boolean func(long a, long b, long max) {
        long x = (a * (a + 1)) / 2;
        return (x >= b);
    }
}