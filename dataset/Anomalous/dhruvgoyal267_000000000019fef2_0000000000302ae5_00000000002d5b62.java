import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();

            if ((Math.abs(x - y) % 2 == 0) || ((Math.abs(x) + Math.abs(y)) % 2 == 0)) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                long a = 1;

                while (a <= Math.abs(x) + Math.abs(y)) {
                    a *= 2;
                }
                a /= 2;

                while ((x != 0 || y != 0) && a > 0) {
                    if (Math.abs(x) >= Math.abs(y)) {
                        if (x < 0) {
                            x += a;
                            result.append("W");
                        } else {
                            x -= a;
                            result.append("E");
                        }
                    } else {
                        if (y < 0) {
                            y += a;
                            result.append("S");
                        } else {
                            y -= a;
                            result.append("N");
                        }
                    }
                    a /= 2;
                }
                System.out.println("Case #" + caseNumber + ": " + result.reverse());
            }
            caseNumber++;
        }
        scanner.close();
    }
}