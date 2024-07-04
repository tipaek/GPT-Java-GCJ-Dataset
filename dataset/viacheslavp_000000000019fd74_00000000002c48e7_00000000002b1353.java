import java.util.Scanner;

public class Solution {

    public static void main(String[] params) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < t; ++i) {
            int n = Integer.valueOf(scanner.nextLine());
            System.out.println(String.format("Case #%d:", i + 1));
            if (n <= 3) {
                for (int j = 1; j <= n; ++j) {
                    System.out.println(String.format("%d %d", j, 1));
                }
            } else {
                System.out.println(String.format("%d %d", 1, 1));
                System.out.println(String.format("%d %d", 2, 1));
                System.out.println(String.format("%d %d", 3, 2));
                for (int j = 1; j <= n - 4; ++j) {
                    System.out.println(String.format("%d %d", j + 2, 1));
                }
            }
        }
    }
}
