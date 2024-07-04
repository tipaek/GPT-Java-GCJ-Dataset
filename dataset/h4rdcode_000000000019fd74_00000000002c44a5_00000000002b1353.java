import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            System.out.println(String.format("Case #%d:", i + 1));
            if (n <= 501) {
                if (n == 501 ) {
                    System.out.println("1 1\n2 1\n3 2\n3 3");
                    for (int j = 4; j <= 500; j++) {
                        System.out.println(j + " " + j);
                    }
                } else {
                    for (int j = 1; j <= n; j++) {
                        System.out.println(j + " " + j);
                    }
                }
            } else if (n <= 1000) {
                int sum = 2;
                System.out.println("1 1\n2 1");
                int q = 3;
                int x = 2;
                while (sum + x <= n) {
                    sum += x;
                    x++;
                    System.out.println(q + " " + (q - 1));
                    q++;
                }
                x = 1;
                while (sum + x <= n) {
                    sum += x;
                    System.out.println(q + " " + (q));
                    q++;
                }
            }
        }
    }
}