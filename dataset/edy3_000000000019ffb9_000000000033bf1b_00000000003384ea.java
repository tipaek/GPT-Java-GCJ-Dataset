import java.util.*;

class Solution {

    static void solve(long left, long right) {
        long i = 1;

        while (true) {
            if (left == right) {
                if (i > left) {
                    i -= 1;
                    break;
                }
                left -= i;
            }

            else if (left > right) {
                if (i > left) {
                    i -= 1;
                    break;
                }
                // how many to pulL?
                //left - right
                long pull = left - right;
                pull += (i - 1) * i / 2;
                long likelyN = (long) Math.sqrt(pull * 2);
                long likelySum = (likelyN * (likelyN + 1) ) / 2 - (i - 1) * i / 2;
                if (likelySum > (left - right)) {
                    --likelyN;
                }
                if (likelyN < i) {
                    likelyN = i;
                }
                likelySum = (likelyN * (likelyN + 1) ) / 2 - (i - 1) * i / 2;

                left -= likelySum;
                i = likelyN;

            }

            else if (right > left) {
                if (i > right) {
                    i -= 1;
                    break;
                }
                // how many to pulL?
                //left - right
                long pull = right - left;
                pull += (i - 1) * i / 2;
                long likelyN = (long) Math.sqrt(pull * 2);
                long likelySum = (likelyN * (likelyN + 1) ) / 2 - (i - 1) * i / 2;
                if (likelySum > (right - left)) {
                    --likelyN;
                }
                if (likelyN < i) {
                    likelyN = i;
                }
                likelySum = (likelyN * (likelyN + 1) ) / 2 - (i - 1) * i / 2;

                right -= likelySum;
                i = likelyN;
            }

            ++i;
        }

        System.out.println(String.format("%d %d %d", i, left, right));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for (int i = 1; i <= n; ++i) {
            long l = in.nextLong();
            long r = in.nextLong();

            System.out.print(String.format("Case #%d: ", i));
            solve(l, r);
        }
    }
}