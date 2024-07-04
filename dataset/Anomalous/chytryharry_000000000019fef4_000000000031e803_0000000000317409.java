import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String route = scanner.next();
            System.out.println("Case #" + i + ": " + calculateMinimumTime(x, y, route));
        }
    }

    public static String calculateMinimumTime(int startX, int startY, String route) {
        int routeLength = route.length();
        for (int i = 0; i < routeLength; i++) {
            char move = route.charAt(i);
            switch (move) {
                case 'N':
                    startY++;
                    break;
                case 'S':
                    startY--;
                    break;
                case 'E':
                    startX++;
                    break;
                case 'W':
                    startX--;
                    break;
            }

            if (startX == 0 && startY == 0) {
                return String.valueOf(i + 1);
            }

            if (Math.abs(startX) + Math.abs(startY) <= i + 1) {
                return String.valueOf(i + 1);
            }
        }

        return "IMPOSSIBLE";
    }
}