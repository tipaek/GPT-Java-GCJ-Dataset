import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalTests = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline character

        for (int i = 1; i <= totalTests; i++) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline character
            String path = scanner.nextLine().trim();
            String result = solve(X, Y, path);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String solve(int X, int Y, String path) {
        if (X == 0 && Y == 0) return "0";
        int step = 1;
        for (char ch : path.toCharArray()) {
            switch (ch) {
                case 'N': Y++; break;
                case 'S': Y--; break;
                case 'E': X++; break;
                case 'W': X--; break;
            }
            int dist = getDistance(X, Y);
            if (dist <= step) return String.valueOf(step);
            step++;
        }
        return "IMPOSSIBLE";
    }

    public static int getDistance(int X, int Y) {
        return Math.abs(X) + Math.abs(Y);
    }
}