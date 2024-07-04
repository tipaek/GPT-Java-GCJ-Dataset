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
                    if (isPossible(r, init, Math.max(L, R)) || !isSumPossible(ans, Math.max(L, R))) {
                        ans = r;
                    } else {
                        ans = l;
                    }
                    break;
                }

                ans = (l + r) / 2;
                if (isPossible(ans, init, Math.max(L, R)) || !isSumPossible(ans, Math.max(L, R))) {
                    r = ans;
                } else {
                    l = ans;
                }
            }

            long max = Math.max(L, R);
            if (L >= R) {
                L -= (ans * (ans + 1)) / 2;
            } else {
                R -= (ans * (ans + 1)) / 2;
            }

            long leftover = L, rightover = R;
            long x = ans + 1;

            if (ans * (ans + 1) / 2 >= init) {
                if (x % 2 == 0) {
                    if (L < R) {
                        L += (x / 2) * (x / 2);
                        long temp = (long) Math.sqrt(L);
                        leftover = L - temp * temp;

                        temp = adjustTemp(temp, ans, R);
                        rightover = R - (temp / 2) * (temp / 2 + 1) + (ans / 2 * (ans / 2 + 1));

                        if (rightover > temp + 1) {
                            rightover -= temp + 1;
                            temp++;
                        }
                        ans = temp;
                    } else {
                        R += (x / 2) * (x / 2);
                        long temp = (long) Math.sqrt(R);
                        rightover = R - temp * temp;

                        temp = adjustTemp(temp, ans, L);
                        leftover = L - (temp / 2) * (temp / 2 + 1) + (ans / 2 * (ans / 2 + 1));

                        if (leftover > temp + 1) {
                            leftover -= temp + 1;
                            temp++;
                        }
                        ans = temp;
                    }
                } else {
                    if (L < R) {
                        long mid = findMid(L, ans);
                        leftover = L - (mid / 2) * (mid / 2 + 1) + (ans / 2 * (ans / 2 + 1));
                        rightover = R + (x / 2) * (x / 2) - (mid / 2) * (mid / 2);

                        if (rightover >= mid + 1) {
                            rightover -= mid + 1;
                            mid++;
                        }
                        ans = mid;
                    } else {
                        long mid = findMid(R, ans);
                        rightover = R - (mid / 2) * (mid / 2 + 1) + (ans / 2 * (ans / 2 + 1));
                        leftover = L + (x / 2) * (x / 2) - (mid / 2) * (mid / 2);

                        if (leftover >= mid + 1) {
                            leftover -= mid + 1;
                            mid++;
                        }
                        ans = mid;
                    }
                }
            }
            System.out.println("Case #" + t + ": " + ans + " " + leftover + " " + rightover);
        }
    }

    private static boolean isPossible(long a, long b, long max) {
        return (a * (a + 1)) / 2 >= b;
    }

    private static boolean isSumPossible(long a, long max) {
        return (a * (a + 1)) / 2 <= max;
    }

    private static long adjustTemp(long temp, long ans, long R) {
        temp *= 2;
        temp--;
        return temp;
    }

    private static long findMid(long value, long ans) {
        long a = 0, b = value, mid = (a + b) / 2;
        while (a <= b) {
            if (a == b) {
                mid = a;
                break;
            }
            if (a == b - 1) {
                if (isFunc2Possible(b, ans, value)) {
                    mid = b;
                } else {
                    mid = a;
                }
                break;
            }
            mid = (a + b) / 2;
            if (isFunc2Possible(mid, ans, value)) {
                a = mid;
            } else {
                b = mid;
            }
        }
        if (mid % 2 == 1) mid--;
        return mid;
    }

    private static boolean isFunc2Possible(long a, long ans, long b) {
        return (b - (a / 2) * (a / 2 + 1) + (ans / 2 * (ans / 2 + 1))) >= 0;
    }
}