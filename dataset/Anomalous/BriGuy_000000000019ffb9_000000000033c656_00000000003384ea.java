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
                    ans = func(left, initDiff) ? left : right;
                    break;
                }
                ans = (left + right) / 2;
                if (func(ans, initDiff)) left = ans;
                else right = ans;
            }

            long leftover = 0, rightover = 0;
            if (L >= R) L -= ans * (ans + 1) / 2;
            else R -= ans * (ans + 1) / 2;

            long nextStep = ans + 1;
            if (nextStep % 2 == 0) {
                if (L < R) {
                    L += (nextStep / 2) * (nextStep / 2);
                    long temp = (long) Math.sqrt(L);
                    leftover = L - temp * temp;

                    temp = temp * 2 - 1;
                    rightover = R - (temp / 2) * (temp / 2 + 1) + (ans / 2 * (ans / 2 + 1));

                    if (rightover > temp + 1) {
                        rightover -= temp + 1;
                        temp++;
                    }

                    ans = temp;
                } else {
                    R += (nextStep / 2) * (nextStep / 2);
                    long temp = (long) Math.sqrt(R);
                    rightover = R - temp * temp;

                    temp = temp * 2 - 1;
                    leftover = L - (temp / 2) * (temp / 2 + 1) + (ans / 2 * (ans / 2 + 1));

                    if (leftover > temp + 1) {
                        leftover -= temp + 1;
                        temp++;
                    }

                    ans = temp;
                }
            } else {
                if (L < R) {
                    long a = 0, b = L, mid = (a + b) / 2;

                    while (a <= b) {
                        if (a == b) {
                            mid = a;
                            break;
                        }
                        if (a == b - 1) {
                            mid = func2(b, ans, L) ? b : a;
                            break;
                        }
                        mid = (a + b) / 2;
                        if (func2(mid, ans, L)) a = mid;
                        else b = mid;
                    }

                    leftover = L - (mid / 2) * (mid / 2 + 1) + (ans / 2 * (ans / 2 + 1));
                    rightover = R + (nextStep / 2) * (nextStep / 2) - (mid / 2) * (mid / 2);
                    if (rightover > mid + 1) {
                        rightover -= mid + 1;
                        mid++;
                    }

                    ans = mid;
                } else {
                    long a = 0, b = R, mid = (a + b) / 2;

                    while (a <= b) {
                        if (a == b) {
                            mid = a;
                            break;
                        }
                        if (a == b - 1) {
                            mid = func2(b, ans, R) ? b : a;
                            break;
                        }
                        mid = (a + b) / 2;
                        if (func2(mid, ans, R)) a = mid;
                        else b = mid;
                    }

                    rightover = R - (mid / 2) * (mid / 2 + 1) + (ans / 2 * (ans / 2 + 1));
                    leftover = L + (nextStep / 2) * (nextStep / 2) - (mid / 2) * (mid / 2);
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

    public static boolean func2(long a, long ans, long b) {
        return (b - (a / 2) * (a / 2 + 1) + (ans / 2 * (ans / 2 + 1)) >= 0);
    }

    public static boolean func(long a, long b) {
        return (a * (a + 1) / 2 >= b);
    }
}