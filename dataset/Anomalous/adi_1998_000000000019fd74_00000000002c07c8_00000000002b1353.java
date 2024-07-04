import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int t1 = 0; t1 < t; t1++) {
            int n = sc.nextInt();
            System.out.println("Case #" + (t1 + 1) + ":");
            
            switch (n) {
                case 1:
                    System.out.println("1 1");
                    break;
                case 2:
                    System.out.println("1 1\n2 1");
                    break;
                case 999:
                    System.out.println("1 1\n2 1\n3 1\n4 2");
                    for (int i = 5; i <= 498; i++) {
                        System.out.println(i + " 1");
                    }
                    System.out.println("499 2");
                    break;
                case 1000:
                    for (int i = 1; i <= 4; i++) {
                        System.out.println(i + " 1");
                    }
                    System.out.println("5 2");
                    for (int i = 6; i <= 498; i++) {
                        System.out.println(i + " 1");
                    }
                    System.out.println("499 2");
                    break;
                default:
                    int h = n - n / 2;
                    int h1 = n - h;
                    for (int i = 1; i <= h; i++) {
                        System.out.println(i + " 1");
                    }
                    System.out.println((h1 + 1) + " 2");
                    break;
            }
        }
    }
}