import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt() - 1;
            System.out.println("Case #" + testCase + ": ");
            System.out.println("1 1");

            double x = Math.sqrt(2 * n + 0.25) - 0.5;
            int a = (int) x;
            int j = 1;

            for (int k = 1; k <= a; k++) {
                System.out.println((k + 1) + " 2");
            }

            n -= a * (a + 1) / 2;

            while (n > 1) {
                System.out.println((j + a + 1) + " 1");
                j++;
                n--;
            }

            if (n == 1) {
                System.out.println((j + a + 1) + " 1");
            }
        }
    }
}