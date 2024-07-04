import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            if (k % n != 0) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                int d = k / n;
                System.out.println("Case #" + (t + 1) + ": POSSIBLE");
                d++;
                for (int i = 0; i < n; i++) {
                    int m = --d;
                    for (int j = 0; j < n; j++) {
                        System.out.print(((m % n == 0) ? n : (m % n)) + " ");
                        m++;
                    }
                    System.out.println();
                }
            }
        }
        sc.close();
    }
}