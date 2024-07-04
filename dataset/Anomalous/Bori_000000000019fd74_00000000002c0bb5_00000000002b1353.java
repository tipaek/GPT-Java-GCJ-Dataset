import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noTests = scanner.nextInt();

        for (int t = 1; t <= noTests; t++) {
            int n = scanner.nextInt();
            System.out.println("Case #" + t + ":");

            if (n <= 500) {
                printSteps(n, 1, 1, 1, 0);
            } else if (n == 501) {
                printSpecialCase501();
                printSteps(n - 6, 4, 4, 1, 1);
            } else if (n > 521) {
                printSteps(9, 1, 1, 1, 0);
                printSteps(10, 10, 1, 0, 1);
                printSteps(n - 521, 11, 11, 1, 1);
            } else {
                printSteps(8, 1, 1, 1, 0);
                printSteps(9, 9, 1, 0, 1);
                printSteps(n - 264, 10, 10, 1, 1);
            }
        }
    }

    private static void printSteps(int steps, int startX, int startY, int dx, int dy) {
        for (int i = 0; i < steps; i++) {
            System.out.println(startX + " " + startY);
            startX += dx;
            startY += dy;
        }
    }

    private static void printSpecialCase501() {
        System.out.println("1 1");
        System.out.println("2 1");
        System.out.println("3 1");
        System.out.println("3 2");
        System.out.println("3 3");
    }
}