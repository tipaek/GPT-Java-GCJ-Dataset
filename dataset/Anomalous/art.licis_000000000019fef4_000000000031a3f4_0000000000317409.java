import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            String path = scanner.next();

            String result = findMinimumMoves(startX, startY, path);
            System.out.printf("Case #%d: %s%n", testCase, result);
        }
        System.out.flush();
    }

    private static String findMinimumMoves(int x, int y, String path) {
        if (path.isEmpty()) return "IMPOSSIBLE";
        
        int currentX = x, currentY = y, moves = 0;
        
        for (int i = 0; i < path.length(); i++) {
            char direction = path.charAt(i);
            switch(direction) {
                case 'S': currentY--; break;
                case 'N': currentY++; break;
                case 'E': currentX++; break;
                case 'W': currentX--; break;
            }

            moves++;
            int currentDistance = Math.abs(currentX) + Math.abs(currentY);
            if (moves >= currentDistance) return String.valueOf(moves);
        }
        
        return "IMPOSSIBLE";
    }
}