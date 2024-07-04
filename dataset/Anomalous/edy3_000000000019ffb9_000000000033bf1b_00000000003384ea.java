import java.util.Scanner;

class Solution {

    static void solve(long left, long right) {
        long i = 1;

        while (true) {
            if (left == right) {
                if (i > left) {
                    i--;
                    break;
                }
                left -= i;
            } else if (left > right) {
                if (i > left) {
                    i--;
                    break;
                }
                long pull = left - right + (i - 1) * i / 2;
                long likelyN = (long) Math.sqrt(pull * 2);
                long likelySum = (likelyN * (likelyN + 1)) / 2 - (i - 1) * i / 2;
                if (likelySum > (left - right)) {
                    likelyN--;
                }
                if (likelyN < i) {
                    likelyN = i;
                }
                likelySum = (likelyN * (likelyN + 1)) / 2 - (i - 1) * i / 2;

                left -= likelySum;
                i = likelyN;

            } else {
                if (i > right) {
                    i--;
                    break;
                }
                long pull = right - left + (i - 1) * i / 2;
                long likelyN = (long) Math.sqrt(pull * 2);
                long likelySum = (likelyN * (likelyN + 1)) / 2 - (i - 1) * i / 2;
                if (likelySum > (right - left)) {
                    likelyN--;
                }
                if (likelyN < i) {
                    likelyN = i;
                }
                likelySum = (likelyN * (likelyN + 1)) / 2 - (i - 1) * i / 2;

                right -= likelySum;
                i = likelyN;
            }

            i++;
        }

        System.out.printf("%d %d %d%n", i, left, right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            long left = scanner.nextLong();
            long right = scanner.nextLong();

            System.out.printf("Case #%d: ", i);
            solve(left, right);
        }
    }
}