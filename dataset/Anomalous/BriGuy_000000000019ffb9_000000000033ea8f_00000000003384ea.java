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

            long difference = Math.abs(L - R);
            long left = 0;
            long right = difference;
            long answer = (left + right) / 2;

            while (left <= right) {
                if (left == right) break;
                if (left == right - 1) {
                    if (isValid(right, difference, Math.max(L, R)) || !canSum(answer, Math.max(L, R))) {
                        answer = right;
                    } else {
                        answer = left;
                    }
                    break;
                }

                answer = (left + right) / 2;
                if (isValid(answer, difference, Math.max(L, R)) || !canSum(answer, Math.max(L, R))) {
                    right = answer;
                } else {
                    left = answer;
                }
            }

            long maxVal = Math.max(L, R);

            if (L >= R) {
                L -= sumTo(answer);
            } else {
                R -= sumTo(answer);
            }

            long leftover = L;
            long rightover = R;
            long next = answer + 1;

            if (sumTo(answer) >= difference) {
                if (next % 2 == 0) {
                    if (L < R) {
                        L += squareSum(next / 2);
                        long temp = (long) Math.sqrt(L);
                        leftover = L - temp * temp;
                        temp = adjustTemp(temp, answer, R, leftover);
                        answer = temp;
                    } else {
                        R += squareSum(next / 2);
                        long temp = (long) Math.sqrt(R);
                        rightover = R - temp * temp;
                        temp = adjustTemp(temp, answer, L, rightover);
                        answer = temp;
                    }
                } else {
                    if (L < R) {
                        long mid = binarySearch(L, answer);
                        if (mid % 2 == 1) mid--;
                        leftover = adjustLeftover(L, mid, answer);
                        rightover = adjustRightover(R, mid, next);
                        answer = adjustAnswer(mid, rightover);
                    } else {
                        long mid = binarySearch(R, answer);
                        if (mid % 2 == 1) mid--;
                        rightover = adjustRightover(R, mid, answer);
                        leftover = adjustLeftover(L, mid, next);
                        answer = adjustAnswer(mid, leftover);
                    }
                }
            }

            System.out.println("Case #" + t + ": " + answer + " " + leftover + " " + rightover);
        }
    }

    private static long sumTo(long n) {
        return (n * (n + 1)) / 2;
    }

    private static long squareSum(long n) {
        return (n * n);
    }

    private static boolean canSum(long n, long max) {
        return sumTo(n) <= max;
    }

    private static boolean isValid(long n, long diff, long max) {
        return sumTo(n) >= diff;
    }

    private static long binarySearch(long value, long answer) {
        long left = 0;
        long right = value;
        long mid = (left + right) / 2;

        while (left <= right) {
            if (left == right) {
                mid = left;
                break;
            }
            if (left == right - 1) {
                if (isValidMid(right, answer, value)) {
                    mid = right;
                } else {
                    mid = left;
                }
                break;
            }

            mid = (left + right) / 2;
            if (isValidMid(mid, answer, value)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return mid;
    }

    private static boolean isValidMid(long mid, long answer, long value) {
        return value - sumTo(mid / 2) + sumTo(answer / 2) >= 0;
    }

    private static long adjustLeftover(long L, long mid, long answer) {
        return L - sumTo(mid / 2) + sumTo(answer / 2);
    }

    private static long adjustRightover(long R, long mid, long next) {
        return R + squareSum(next / 2) - squareSum(mid / 2);
    }

    private static long adjustAnswer(long mid, long over) {
        if (over >= mid + 1) {
            over -= mid + 1;
            mid++;
        }
        return mid;
    }

    private static long adjustTemp(long temp, long answer, long value, long over) {
        temp *= 2;
        temp--;
        over = value - sumTo(temp / 2) + sumTo(answer / 2);
        if (over > temp + 1) {
            over -= temp + 1;
            temp++;
        }
        return temp;
    }
}