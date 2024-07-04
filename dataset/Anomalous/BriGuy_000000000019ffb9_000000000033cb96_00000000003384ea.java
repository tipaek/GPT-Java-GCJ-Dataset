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
            long left = 0, right = initDiff, answer = (left + right) / 2;

            while (left <= right) {
                if (left == right) break;
                if (left == right - 1) {
                    answer = func(left, initDiff) ? left : right;
                    break;
                }

                answer = (left + right) / 2;
                if (func(answer, initDiff)) left = answer;
                else right = answer;
            }

            long leftover = 0, rightover = 0;
            if (L >= R) L -= answer * (answer + 1) / 2;
            else R -= answer * (answer + 1) / 2;

            long nextStep = answer + 1;
            if (nextStep % 2 == 0) {
                if (L < R) {
                    adjustForEvenStep(L, R, answer, nextStep);
                } else {
                    adjustForEvenStep(R, L, answer, nextStep);
                }
            } else {
                if (L < R) {
                    adjustForOddStep(L, R, answer, nextStep);
                } else {
                    adjustForOddStep(R, L, answer, nextStep);
                }
            }

            System.out.println("Case #" + t + ": " + answer + " " + leftover + " " + rightover);
        }
    }

    private static void adjustForEvenStep(long L, long R, long answer, long nextStep) {
        L += (nextStep / 2) * (nextStep / 2);
        long temp = (long) Math.sqrt(L);
        long leftover = L - temp * temp;

        temp *= 2;
        temp--;
        long rightover = R - (temp / 2) * (temp / 2 + 1) + (answer / 2 * (answer / 2 + 1));

        if (rightover > temp + 1) {
            rightover -= temp + 1;
            temp++;
        }

        answer = temp;
    }

    private static void adjustForOddStep(long L, long R, long answer, long nextStep) {
        long a = 0, b = L, mid = (a + b) / 2;

        while (a <= b) {
            if (a == b) {
                mid = a;
                break;
            }

            if (a == b - 1) {
                mid = func2(b, answer, L) ? b : a;
                break;
            }

            mid = (a + b) / 2;
            if (func2(mid, answer, L)) a = mid;
            else b = mid;
        }

        if (mid % 2 == 1) mid--;

        long leftover = L - (mid / 2) * (mid / 2 + 1) + (answer / 2 * (answer / 2 + 1));
        long rightover = R + (nextStep / 2) * (nextStep / 2) - (mid / 2) * (mid / 2);
        if (rightover > mid + 1) {
            rightover -= mid + 1;
            mid++;
        }

        answer = mid;
    }

    public static boolean func2(long a, long answer, long b) {
        return (b - (a / 2) * (a / 2 + 1) + (answer / 2 * (answer / 2 + 1)) >= 0);
    }

    public static boolean func(long a, long b) {
        return (a * (a + 1) / 2 >= b);
    }
}