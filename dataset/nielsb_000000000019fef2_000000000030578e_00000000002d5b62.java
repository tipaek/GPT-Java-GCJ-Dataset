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

    final long X, Y;

    public Solution(Scanner scanner) {
        X = scanner.nextInt();
        Y = scanner.nextInt();
    }

    private String solve() {
        long x = (X < 0) ? -X: X;
        long y = (Y < 0) ? -Y: Y;
        String route = "";
        for (int i = 0; i < 35; i++) {
            if (x == 0 && y == 0) {
                return swap(route);
            } else if (x % 2 == y % 2) {
                return "IMPOSSIBLE";
            } else if (x == 1 && y == 0) {
                return swap(route + "E");
            } else if (x == 0 && y == 1) {
                return swap(route + "N");
            } else if (x % 2 == 1 && (x >> 1) % 2 == (y >> 1) % 2) {
                route += "W";
                x++;
            } else if (x % 2 == 1) {
                route += "E";
                x--;
            } else if ((x >> 1) % 2 == (y >> 1) % 2) {
                route += "S";
                y++;
            } else {
                route += "N";
                y--;
            }
            x /= 2;
            y /= 2;
        }


        return "IMPOSSIBLE";
    }

    private String swap(String route) {
        if (X < 0) {
            route = route.replace("E", "T");
            route = route.replace("W", "E");
            route = route.replace("T", "W");
        }
        if (Y < 0) {
            route = route.replace("N", "T");
            route = route.replace("S", "N");
            route = route.replace("T", "S");
        }
        return route;
    }

}
