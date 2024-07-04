import java.util.Scanner;

public class Solution {

    private void solve(Scanner scanner) {
        long left = scanner.nextLong();
        long right = scanner.nextLong();
        long difference = Math.abs(left - right);

        long a = findMaxSteps(difference);

        boolean shouldSwap = right > left;

        if (shouldSwap) {
            long temp = left;
            left = right;
            right = temp;
        }

        left -= sumOfFirstNNumbers(a);

        if (left == right && shouldSwap) {
            shouldSwap = false;
        }

        long b = findMaxStepsForK(a + 1, left);
        long c = findMaxStepsForK(a + 2, right);

//        System.out.println(a + " " + b + " " + c);

        long totalSteps = a + b + c;

        long remainingLeft = left - sumOfKSteps(a + 1, b);
        long remainingRight = right - sumOfKSteps(a + 2, c);

        if (shouldSwap) {
            System.out.println(totalSteps + " " + remainingRight + " " + remainingLeft);
        } else {
            System.out.println(totalSteps + " " + remainingLeft + " " + remainingRight);
        }
    }

    private long sumOfFirstNNumbers(long n) {
        return n * (n + 1) / 2;
    }

    private long findMaxSteps(long n) {
        if (n == 0) {
            return 0;
        }

        long low = 0;
        long high = 1_000_000_000;

        while (low + 1 < high) {
            long mid = (low + high) / 2;
            long value = sumOfFirstNNumbers(mid);
            if (value > n) {
                high = mid;
            } else if (value < n) {
                low = mid;
            } else {
                return mid;
            }
        }

        return low;
    }

    private long findMaxStepsForK(long k, long n) {
        if (n == 0) {
            return 0;
        }

        long low = 0;
        long high = 1_000_000_000;

        while (low + 1 < high) {
            long mid = (low + high) / 2;
            long value = sumOfKSteps(k, mid);
            if (value > n) {
                high = mid;
            } else if (value < n) {
                low = mid;
            } else {
                return mid;
            }
        }

        return low;
    }

    private long sumOfKSteps(long k, long m) {
        return m * k + sumOfFirstNNumbers(m - 1) * 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            new Solution().solve(scanner);
        }
        scanner.close();
    }
}