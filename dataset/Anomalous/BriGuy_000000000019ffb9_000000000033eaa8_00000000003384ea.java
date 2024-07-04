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
            long l = 0;
            long r = init;
            long ans = (l + r) / 2;

            while (l <= r) {
                if (l == r || l == r - 1) {
                    if (func(r, init, Math.max(L, R)) && ((ans * (ans + 1)) / 2 <= Math.max(L, R))) {
                        ans = r;
                    } else {
                        ans = l;
                    }
                    break;
                }

                ans = (l + r) / 2;
                if (func(ans, init, Math.max(L, R)) || !((ans * (ans + 1)) / 2 <= Math.max(L, R))) {
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

            if (ans * (ans + 1) / 2 >= init && Math.min(L, R) != 0) {
                if (x % 2 == 0) {
                    if (L < R) {
                        L += (x / 2) * (x / 2);
                        long temp = (long) Math.sqrt(L);
                        leftover = L - temp * temp;

                        temp *= 2;
                        temp--;
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

                        temp *= 2;
                        temp--;
                        leftover = L - (temp / 2) * (temp / 2 + 1) + (ans / 2 * (ans / 2 + 1));

                        if (leftover > temp + 1) {
                            leftover -= temp + 1;
                            temp++;
                        }

                        ans = temp;
                    }
                } else {
                    if (L < R) {
                        long mid = binarySearch(L, ans);
                        if (mid % 2 == 1) mid--;

                        leftover = L - (mid / 2) * (mid / 2 + 1) + (ans / 2 * (ans / 2 + 1));
                        rightover = R + (x / 2) * (x / 2) - (mid / 2) * (mid / 2);
                        if (rightover >= mid + 1) {
                            rightover -= mid + 1;
                            mid++;
                        }

                        ans = mid;
                    } else {
                        long mid = binarySearch(R, ans);
                        if (mid % 2 == 1) mid--;

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

    private static long binarySearch(long value, long ans) {
        long a = 0;
        long b = value;
        long mid = (a + b) / 2;

        while (a <= b) {
            if (a == b || a == b - 1) {
                if (func2(b, ans, value)) {
                    mid = b;
                } else {
                    mid = a;
                }
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

    public static boolean func2(long a, long ans, long b) {
        return (b - (a / 2) * (a / 2 + 1) + (ans / 2 * (ans / 2 + 1)) >= 0);
    }

    public static boolean func(long a, long b, long max) {
        long x = (a * (a + 1)) / 2;
        return (x >= b);
    }
}