import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            solve(i + 1, scanner);
        }
    }

    private static void solve(int caseId, Scanner scanner) {
        long L = scanner.nextInt();
        long R = scanner.nextInt();
        long customers = 0;

        if (L > R) {
            long diff = binarySearchSumAll(L - R);
            L -= sumAll(diff);
            customers += diff;
        } else if (R > L) {
            long diff = binarySearchSumAll(R - L);
            R -= sumAll(diff);
            customers += diff;
        }

        if (L >= R) {
            if (customers % 2 == 0) {
                long maxL = binarySearchSumOdd(L, customers / 2);
                long maxR = binarySearchSumEven(L, customers / 2);
                L -= sumOdd(maxL) - sumOdd(customers / 2);
                R -= sumEven(maxR) - sumEven(customers / 2);
                customers = maxL + maxR;
            } else {
                long maxL = binarySearchSumEven(L, customers / 2);
                long maxR = binarySearchSumOdd(L, customers / 2 + 1);
                L -= sumEven(maxL) - sumEven(customers);
                R -= sumOdd(maxR) - sumOdd(customers + 1);
                customers = maxL + maxR;
            }
        } else {
            if (customers % 2 == 1) {
                long maxL = binarySearchSumOdd(L, customers / 2 + 1);
                long maxR = binarySearchSumEven(L, customers / 2);
                L -= sumOdd(maxL) - sumOdd(customers + 1);
                R -= sumEven(maxR) - sumEven(customers);
                customers += maxL + maxR;
            } else {
                long maxL = binarySearchSumEven(L, customers / 2);
                long maxR = binarySearchSumOdd(L, customers / 2);
                L -= sumEven(maxL) - sumEven(customers + 1);
                R -= sumOdd(maxR) - sumOdd(customers);
                customers += maxL + maxR;
            }
        }

        System.out.println("Case #" + caseId + ": " + customers + " " + L + " " + R);
    }

    private static long sumAll(long n) {
        return n * (n + 1) / 2;
    }

    private static long sumOdd(long n) {
        return n * n;
    }

    private static long sumEven(long n) {
        return n * (n + 1);
    }

    private static long binarySearchSumEven(long delta, long start) {
        long left = start;
        long right = 1L << 60;

        while (right >= left) {
            long mid = left + (right - left) / 2;
            long value = sumEven(mid) - sumEven(start);
            long nextValue = sumEven(mid + 1) - sumEven(start);

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

    private static long binarySearchSumOdd(long delta, long start) {
        long left = start;
        long right = 1L << 60;

        while (right >= left) {
            long mid = left + (right - left) / 2;
            long value = sumOdd(mid) - sumOdd(start);
            long nextValue = sumOdd(mid + 1) - sumOdd(start);

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

    private static long binarySearchSumAll(long delta) {
        long left = 1;
        long right = 1L << 60;

        while (right >= left) {
            long mid = left + (right - left) / 2;
            long value = sumAll(mid);
            long previousValue = sumAll(mid - 1);

            if (value >= delta && previousValue < delta) {
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