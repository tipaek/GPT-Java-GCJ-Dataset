import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        solve(new Scanner(System.in));
    }
    

    public static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String path = scanner.next();
            int result = solve(x, y, path);
            System.out.print("Case #" + (i + 1) + ": ");
            System.out.print(result >= 0 ? String.valueOf(result) : "IMPOSSIBLE");
            if (i != n - 1)
                System.out.println();
        }
    }

    private static int solve(int initX, int initY, String path) {
        int x = initX;
        int y = initY;
        for (int i = 0; i < path.length(); i++) {
            if (Math.abs(x) + Math.abs(y) <= i) {
                return i;
            }

            char dir = path.charAt(i);
            switch (dir) {
                case 'N':
                    y += 1;
                    break;
                case 'S':
                    y -= 1;
                    break;
                case 'E':
                    x += 1;
                    break;
                case 'W':
                    x -= 1;
                    break;
            }
        }

        if (Math.abs(x) + Math.abs(y) <= path.length()) {
            return path.length();
        }

        return -1;
    }
}
