import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noTests = scanner.nextInt();

        for (int t = 1; t <= noTests; t++) {
            int n = scanner.nextInt();
            System.out.println("Case #" + t + ":");

            if (n <= 500) {
                for (int i = 1; i <= n; i++) {
                    System.out.println(i + " 1");
                }
            } else if (n == 501) {
                System.out.println("1 1");
                System.out.println("2 1");
                System.out.println("3 1");
                System.out.println("3 2");
                System.out.println("3 3"); // sum = 6
                for (int i = 1; i <= n - 6; i++) {
                    System.out.println((i + 3) + " " + (i + 3));
                }
            }
        }
    }
}