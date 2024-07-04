import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= t; i++) {
            String[] input = scanner.nextLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            String result = "IMPOSSIBLE";

            if (k % n == 0) {
                result = "POSSIBLE";
            }
            System.out.println("Case #" + i + ": " + result);

            if (k % n == 0) {
                int start = k / n;
                StringBuilder grid = new StringBuilder();
                for (int x = 1; x <= n * n; x++) {
                    if (x % n != 0) {
                        grid.append(start).append(" ");
                    } else {
                        grid.append(start);
                        System.out.println(grid.toString());
                        grid.setLength(0);
                        start = k / n + x / n - 1;
                    }
                    start = (start + 1) % n;
                    if (start == 0) {
                        start = n;
                    }
                }
            }
        }
        scanner.close();
    }
}