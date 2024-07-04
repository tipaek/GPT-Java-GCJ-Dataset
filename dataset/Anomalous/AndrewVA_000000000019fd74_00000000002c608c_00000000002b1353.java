import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt() - 1;
            System.out.println("Case #" + i + ": ");
            System.out.println("1 1");

            double x = Math.sqrt(2 * n + 0.25) - 0.5;
            int a = (int) x;
            int j = 1;

            while (j <= a) {
                System.out.println((j + 1) + " 2");
                j++;
            }

            n -= (a * (a + 1) / 2);
            while (n > 1) {
                System.out.println((j + 1) + " 1");
                j++;
                n--;
            }

            if (n == 1) {
                System.out.println((j + 1) + " 1");
            }
        }
        
        scanner.close();
    }
}