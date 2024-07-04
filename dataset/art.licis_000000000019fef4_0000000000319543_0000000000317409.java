import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String path = sc.next();
            System.out.println(path);

            String s = solve(x, y, path);
            System.out.printf("Case #%d: %s%n", tc, s);
        }
        System.out.flush();
    }

    private static String solve(int x, int y, String path) {
        if (x == 0 && y == 0) return "0";
        if (path.length() == 0) return "IMPOSSIBLE";
        int currX = x, currY = y;
        int moves = 0;
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            switch(c) {
                case 'S': currY--; break;
                case 'N': currY++; break;
                case 'E': currX++; break;
                case 'W': currX--; break;
            }

            moves++;
            int currDist = Math.abs(currX) + Math.abs(currY);
            if (moves >= currDist) return "" + moves;
        }
        return "IMPOSSIBLE";
    }
}