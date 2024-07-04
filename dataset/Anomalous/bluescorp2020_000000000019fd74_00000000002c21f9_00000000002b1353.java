import java.util.Scanner;

public class Solution {

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        if (n <= 500) {
            for (int i = 1; i <= n; i++) {
                System.out.println(i + " 1");
            }
        } else {
            System.out.println("1 1");
            System.out.println("2 1");
            System.out.println("3 2");
            System.out.println("3 1");
            for (int i = 1; i <= 496; i++) {
                System.out.println(i + " 1");
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int k = 1; k <= t; k++) {
                System.out.println("Case #" + k + ":");
                solve(scanner);
            }
        }
    }
}