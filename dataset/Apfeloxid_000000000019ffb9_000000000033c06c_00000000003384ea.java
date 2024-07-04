import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            long L = scanner.nextInt();
            long R = scanner.nextInt();

            int amount = 0;
            long currentCustomer = 1;

            long diff = Math.abs(L - R);
            long triangual = getTriangualNumber(diff);


            if (L > R) {
                L -= triangual * (triangual + 1) / 2;
                amount += triangual;
                currentCustomer += triangual;
            } else {
                R -= triangual * (triangual + 1) / 2;
                amount += triangual;
                currentCustomer += triangual;
            }

            while (Math.max(L, R) >= currentCustomer) {
                if (L >= R) {
                    L -= currentCustomer;
                } else {
                    R -= currentCustomer;
                }
                amount++;
                currentCustomer++;
            }
            
            



            System.out.println("Case #" + testCase + ": " + amount + " " + L + " " + R);
        }
    }


    public static long getTriangualNumber(long n) {
        int a = 1;
        int b = 1;
        long c = -2 * n;
        long d = b * b - 4 * a * c;

        double root1 = (-b + Math.sqrt(d)) / 2;

        return (long) root1;
    }
}
