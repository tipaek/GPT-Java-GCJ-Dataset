import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            System.out.println("Case #" + i + ":");
            System.out.println(1 + " " + 1);
            n -= 1;
            int k = 2;

            while (n != 0) {
                if (n - (k - 1) >= 0) {
                    n -= (k - 1);
                    System.out.println(k + " " + 2);
                    k++;
                } else {
                    n -= 1;
                    System.out.println((k - 1) + " " + 1);
                    k++;
                }
            }
        }
        sc.close();
    }
}