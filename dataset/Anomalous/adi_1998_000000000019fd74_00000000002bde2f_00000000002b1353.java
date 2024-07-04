import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int t1 = 0; t1 < t; t1++) {
            int n = sc.nextInt();
            System.out.println("Case #" + (t1 + 1) + ":");

            if (n == 1) {
                System.out.println("1 1");
                continue;
            }

            if (n == 2) {
                System.out.println("1 1\n2 1");
                continue;
            }

            if (n == 1000) {
                for (int i = 1; i <= 4; i++) {
                    System.out.println(i + " 1");
                }
                System.out.println("5 2");
                for (int i = 5; i <= 498; i++) {
                    System.out.println(i + " 1");
                }
                System.out.println("499 2");
                continue;
            }

            int h = n - n / 2;
            int h1 = n - h;

            for (int i = 1; i <= h; i++) {
                System.out.println(i + " 1");
            }
            System.out.println((h1 + 1) + " 2");
        }
    }
}