import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            processTestCase(i + 1, scanner);
        }
    }

    private static void processTestCase(int caseId, Scanner scanner) {
        long left = scanner.nextInt();
        long right = scanner.nextInt();
        long customers = 0;

        if (left > right) {
            long delta = binarySearchSum(left - right);
            left -= calculateSum(delta);
            customers += delta;
        } else if (right > left) {
            long delta = binarySearchSum(right - left);
            right -= calculateSum(delta);
            customers += delta;
        }

        if (left >= right) {
            if (customers % 2 == 0) {
                long maxLeft = binarySearchOdd(left, customers / 2);
                long maxRight = binarySearchEven(left, customers / 2);
                left -= calculateOddSum(maxLeft) - calculateOddSum(customers / 2);
                right -= calculateEvenSum(maxRight) - calculateEvenSum(customers / 2);
                customers = maxLeft + maxRight;
            } else {
                long maxLeft = binarySearchEven(left, customers / 2);
                long maxRight = binarySearchOdd(left, customers / 2 + 1);
                left -= calculateEvenSum(maxLeft) - calculateEvenSum(customers);
                right -= calculateOddSum(maxRight) - calculateOddSum(customers + 1);
                customers = maxLeft + maxRight;
            }
        } else {
            if (customers % 2 == 1) {
                long maxLeft = binarySearchOdd(left, customers / 2 + 1);
                long maxRight = binarySearchEven(left, customers / 2);
                left -= calculateOddSum(maxLeft) - calculateOddSum(customers + 1);
                right -= calculateEvenSum(maxRight) - calculateEvenSum(customers);
                customers += maxLeft + maxRight;
            } else {
                long maxLeft = binarySearchEven(left, customers / 2);
                long maxRight = binarySearchOdd(left, customers / 2);
                left -= calculateEvenSum(maxLeft) - calculateEvenSum(customers + 1);
                right -= calculateOddSum(maxRight) - calculateOddSum(customers);
                customers += maxLeft + maxRight;
            }
        }

        System.out.println("Case #" + caseId + ": " + customers + " " + left + " " + right);
    }

    private static long calculateSum(long n) {
        return n * (n + 1) / 2;
    }

    private static long calculateOddSum(long n) {
        return n * n;
    }

    private static long calculateEvenSum(long n) {
        return n * (n + 1);
    }

    private static long binarySearchEven(long delta, long start) {
        long left = start;
        long right = 1L << 60;

        while (right >= left) {
            long mid = left + (right - left) / 2;
            long value = calculateEvenSum(mid) - calculateEvenSum(start);
            long nextValue = calculateEvenSum(mid + 1) - calculateEvenSum(start);

            if (value <= delta && nextValue > delta) {
                return mid;
            } else if (value > delta) {
                right = mid;
            } else {
                left = mid;
            }
        }

        throw new AssertionError();
    }

    private static long binarySearchOdd(long delta, long start) {
        long left = start;
        long right = 1L << 60;

        while (right >= left) {
            long mid = left + (right - left) / 2;
            long value = calculateOddSum(mid) - calculateOddSum(start);
            long nextValue = calculateOddSum(mid + 1) - calculateOddSum(start);

            if (value <= delta && nextValue > delta) {
                return mid;
            } else if (value > delta) {
                right = mid;
            } else {
                left = mid;
            }
        }

        throw new AssertionError();
    }

    private static long binarySearchSum(long delta) {
        long left = 1;
        long right = 1L << 60;

        while (right >= left) {
            long mid = left + (right - left) / 2;
            long value = calculateSum(mid);
            long prevValue = calculateSum(mid - 1);

            if (value >= delta && prevValue < delta) {
                return mid;
            } else if (value < delta) {
                left = mid;
            } else {
                right = mid;
            }
        }

        throw new AssertionError();
    }
}