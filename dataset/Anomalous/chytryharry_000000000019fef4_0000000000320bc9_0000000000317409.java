import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            String route = scanner.next();
            String result = calculateMinimumTime(startX, startY, route);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    public static String calculateMinimumTime(int startX, int startY, String route) {
        for (int i = 0; i < route.length(); i++) {
            char move = route.charAt(i);
            switch (move) {
                case 'N':
                    startY += 1;
                    break;
                case 'S':
                    startY -= 1;
                    break;
                case 'E':
                    startX += 1;
                    break;
                case 'W':
                    startX -= 1;
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