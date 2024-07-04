import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            long L = scanner.nextLong();
            long R = scanner.nextLong();

            int steps = 0;
            long currentCustomer = 1;
            long difference = Math.abs(L - R);
            long triangularNumber = computeTriangularNumber(difference);

            if (L > R) {
                L -= sumOfFirstNTriangularNumbers(triangularNumber);
                steps += triangularNumber;
                currentCustomer += triangularNumber;
            } else {
                R -= sumOfFirstNTriangularNumbers(triangularNumber);
                steps += triangularNumber;
                currentCustomer += triangularNumber;
            }

            while (Math.max(L, R) >= currentCustomer) {
                if (L >= R) {
                    L -= currentCustomer;
                } else {
                    R -= currentCustomer;
                }
                steps++;
                currentCustomer++;
            }

            System.out.println("Case #" + testCase + ": " + steps + " " + L + " " + R);
        }
    }

    private static long computeTriangularNumber(long n) {
        long a = 1;
        long b = 1;
        long c = -2 * n;
        long discriminant = b * b - 4 * a * c;

        return (long) ((-b + Math.sqrt(discriminant)) / (2 * a));
    }

    private static long sumOfFirstNTriangularNumbers(long n) {
        return n * (n + 1) / 2;
    }
}