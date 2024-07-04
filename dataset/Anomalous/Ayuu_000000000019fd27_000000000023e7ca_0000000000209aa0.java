import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int m = 1; m <= t; m++) {
            int n = sc.nextInt();
            int d = sc.nextInt(); // Note: 'd' is read but never used
            int k = n + 1;

            if (n % 2 != 0) {
                System.out.println("Case #" + m + ": POSSIBLE");
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
            } else {
                System.out.println("Case #" + m + ": IMPOSSIBLE");
            }
        }

        sc.close();
    }
}