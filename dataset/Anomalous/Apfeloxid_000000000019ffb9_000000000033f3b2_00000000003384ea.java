import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            long L = scanner.nextLong();
            long R = scanner.nextLong();
            int moves = 0;
            long currentCustomer = 1;

            long difference = Math.abs(L - R);
            long triangularNumber = calculateTriangularNumber(difference);

            if (L > R) {
                L -= triangularNumber * (triangularNumber + 1) / 2;
                moves += triangularNumber;
                currentCustomer += triangularNumber;
            } else {
                R -= triangularNumber * (triangularNumber + 1) / 2;
                moves += triangularNumber;
                currentCustomer += triangularNumber;
            }

            while (Math.max(L, R) >= currentCustomer) {
                if (L >= R) {
                    L -= currentCustomer;
                } else {
                    R -= currentCustomer;
                }
                moves++;
                currentCustomer++;
            }

            System.out.println("Case #" + testCase + ": " + moves + " " + L + " " + R);
        }
    }

    public static long calculateTriangularNumber(long n) {
        long a = 1;
        long b = 1;
        long c = -2 * n;
        long discriminant = b * b - 4 * a * c;

        double root = (-b + Math.sqrt(discriminant)) / 2;
        return (long) root;
    }
}