import java.util.Scanner;

public class Solution {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            String solution = new Solution(scanner).solve();
            System.out.println("Case #" + t + ": " + solution);
        }
    }

    final int X, Y;
    final String route;

    public Solution(Scanner scanner) {
        X = scanner.nextInt();
        Y = scanner.nextInt();
        route = scanner.next();
    }

    private String solve() {
        int x = X, y = Y;
        for (int i = 0; i < route.length(); i++) {
            switch (route.substring(i, i + 1)) {
                case "N":
                    y++;
                    break;
                case "S":
                    y--;
                    break;
                case "E":
                    x++;
                    break;
                case "W":
                    x--;
                    break;
                default:
                    break;
            }

            if (Math.abs(x) + Math.abs(y) <= i + 1) {
                return Integer.toString(i + 1);
            }
        }
        return "IMPOSSIBLE";
    }

}
