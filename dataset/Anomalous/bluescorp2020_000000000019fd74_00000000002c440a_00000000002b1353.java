import java.util.Scanner;

public class Solution {

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int total = 1;
        System.out.println("1 1");
        int i = 2;

        while (true) {
            if (total + (i - 1) <= n) {
                System.out.println(i + " " + (i - 1));
                total += (i - 1);
            } else {
                break;
            }
            i++;
        }

        i--;
        while (total < n) {
            System.out.println(i + " " + i);
            i++;
            total++;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int k = 1; k <= t; k++) {
                System.out.print("Case #" + k + ": ");
                solve(scanner);
            }
        }
    }
}