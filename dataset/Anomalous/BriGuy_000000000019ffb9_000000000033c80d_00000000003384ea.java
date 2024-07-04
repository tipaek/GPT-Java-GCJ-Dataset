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

            long initDiff = Math.abs(L - R);
            long left = 0, right = initDiff, ans = (left + right) / 2;

            while (left <= right) {
                if (left == right) break;
                if (left == right - 1) {
                    if (!isValid(left, initDiff)) ans = right;
                    break;
                }

                ans = (left + right) / 2;
                if (isValid(ans, initDiff)) left = ans;
                else right = ans;
            }

            long leftover = 0, rightover = 0;
            if (L >= R) L -= ans * (ans + 1) / 2;
            else R -= ans * (ans + 1) / 2;

            long x = ans + 1;
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
                    long a = 0, b = L, mid;
                    while (a <= b) {
                        if (a == b) {
                            mid = a;
                            break;
                        }

                        if (a == b - 1) {
                            if (isValid2(b, ans, L)) mid = b;
                            else mid = a;
                            break;
                        }

                        mid = (a + b) / 2;
                        if (isValid2(mid, ans, L)) a = mid;
                        else b = mid;
                    }

                    leftover = L - (mid / 2) * (mid / 2 + 1) + (ans / 2 * (ans / 2 + 1));
                    rightover = R + (x / 2) * (x / 2) - (mid / 2) * (mid / 2);
                    if (rightover > mid + 1) {
                        rightover -= mid + 1;
                        mid++;
                    }

                    ans = mid;
                } else {
                    long a = 0, b = R, mid;
                    while (a <= b) {
                        if (a == b) {
                            mid = a;
                            break;
                        }

                        if (a == b - 1) {
                            if (isValid2(b, ans, R)) mid = b;
                            else mid = a;
                            break;
                        }

                        mid = (a + b) / 2;
                        if (isValid2(mid, ans, R)) a = mid;
                        else b = mid;
                    }

                    rightover = R - (mid / 2) * (mid / 2 + 1) + (ans / 2 * (ans / 2 + 1));
                    leftover = L + (x / 2) * (x / 2) - (mid / 2) * (mid / 2);
                    if (leftover > mid + 1) {
                        leftover -= mid + 1;
                        mid++;
                    }

                    ans = mid;
                }
            }

            System.out.println("Case #" + t + ": " + ans + " " + leftover + " " + rightover);
        }
    }

    public static boolean isValid2(long a, long ans, long b) {
        return (b - (a / 2) * (a / 2 + 1) + (ans / 2 * (ans / 2 + 1)) >= 0);
    }

    public static boolean isValid(long a, long b) {
        return (a * (a + 1) / 2 >= b);
    }
}