import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();

            for (int testCase = 1; testCase <= testCases; testCase++) {
                int startX = scanner.nextInt();
                int startY = scanner.nextInt();
                String path = scanner.next();
                System.out.println(path);

                String result = findMinimumMoves(startX, startY, path);
                System.out.printf("Case #%d: %s%n", testCase, result);
            }
        }
    }

    private static String findMinimumMoves(int x, int y, String path) {
        if (x == 0 && y == 0) {
            return "0";
        }
        if (path.isEmpty()) {
            return "IMPOSSIBLE";
        }

        int currentX = x, currentY = y;
        int moves = 0;

        for (int i = 0; i < path.length(); i++) {
            char direction = path.charAt(i);
            switch (direction) {
                case 'S': currentY--; break;
                case 'N': currentY++; break;
                case 'E': currentX++; break;
                case 'W': currentX--; break;
                default: break;
            }

            moves++;
            int currentDistance = Math.abs(currentX) + Math.abs(currentY);
            if (moves >= currentDistance) {
                return String.valueOf(moves);
            }
        }
        return "IMPOSSIBLE";
    }
}