import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            int k = n + 1;

            if (n % 2 == 0) {
                System.out.println("Case #" + testCase + ": POSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }

            for (int i = 1; i <= n; i++) {
                int temp = k;

                while (temp <= n) {
                    System.out.print(temp + " ");
                    temp++;
                }

                for (int j = 1; j < k; j++) {
                    System.out.print(j + " ");
                }

                k--;
                System.out.println();
            }
        }
        scanner.close();
    }
}