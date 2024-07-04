import java.io.*;
import java.util.*;

public class Solution {

    private static String findMinimumTime(int startX, int startY, String movements) {
        int currentX = startX, currentY = startY;

        for (int i = 0; i < movements.length(); i++) {
            char move = movements.charAt(i);
            switch (move) {
                case 'S': currentY--; break;
                case 'N': currentY++; break;
                case 'W': currentX--; break;
                case 'E': currentX++; break;
            }

            int distance = Math.abs(currentX) + Math.abs(currentY);
            if (distance <= (i + 1)) {
                return Integer.toString(i + 1);
            }
        }

        return "IMPOSSIBLE";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            String movements = scanner.next().trim();

            System.out.println("Case #" + testCase + ": " + findMinimumTime(startX, startY, movements));
        }

        scanner.close();
    }
}