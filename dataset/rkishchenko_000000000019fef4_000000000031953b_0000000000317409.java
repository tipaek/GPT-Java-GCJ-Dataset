import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            String[] parameters = scanner.nextLine().split(" ");
            int x = Integer.parseInt(parameters[0]);
            int y = Integer.parseInt(parameters[1]);
            String path = parameters[2];
            String solution = solve(x, y, path);
            System.out.println("Case #" + (i + 1) + ": " + solution);
        }
    }

    private static String solve(int x, int y, String path) {
        if (x == 0 && y == 0) {
            return String.valueOf(0);
        }

        for (int i = 0; i < path.length(); i++) {
            char d = path.charAt(i);
            if (d == 'S') {
                y--;
            } else if (d == 'N') {
                y++;
            } else if (d == 'E') {
                x++;
            } else {
                x--;
            }
            int distance = Math.abs(x) + Math.abs(y);
            if (distance <= i + 1) {
                return String.valueOf(i + 1);
            }
        }

        return "IMPOSSIBLE";
    }

}
