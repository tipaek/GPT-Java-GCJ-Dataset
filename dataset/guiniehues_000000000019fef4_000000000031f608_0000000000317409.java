import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + solve());
        }
    }

    private static String solve() {
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int steps = 0;
        for (char direction : scanner.nextLine().toCharArray()) {
            switch (direction) {
                case ' ': steps--; break;
                case 'N': y++; break;
                case 'S': y--; break;
                case 'E': x++; break;
                case 'W': x--; break;
            }
            steps++;
            if (Math.abs(x) + Math.abs(y) <= steps) {
                return "" + steps;
            }
        }

        return "IMPOSSIBLE";
    }

}
