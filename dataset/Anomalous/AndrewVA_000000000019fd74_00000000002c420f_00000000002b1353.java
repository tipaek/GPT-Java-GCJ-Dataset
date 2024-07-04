import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt() - 1;
            System.out.println("Case #" + testCase + ": ");
            System.out.println("1 1");

            double x = Math.sqrt(2 * n + 0.25) - 0.5;
            int steps = (int) x;
            int row = 1;

            for (int i = 0; i < steps; i++) {
                System.out.println((i + 2) + " 2");
            }

            n -= steps * (steps + 1) / 2;

            while (n > 0) {
                System.out.println((steps + row + 1) + " 1");
                row++;
                n--;
            }
        }
    }
}