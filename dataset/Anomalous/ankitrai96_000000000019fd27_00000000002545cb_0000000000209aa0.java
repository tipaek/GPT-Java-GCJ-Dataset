import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            if (k % n != 0) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                int d = k / n;
                System.out.println("Case #" + (t + 1) + ": POSSIBLE");
                int m = d + 1;

                for (int i = 0; i < n; i++) {
                    m--;
                    for (int j = 0; j < n; j++) {
                        System.out.print((m % n == 0 ? n : m % n) + " ");
                        m++;
                    }
                    System.out.println();
                }
            }
        }
        scanner.close();
    }
}