import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = scanner.nextInt();

            for (int caseId = 1; caseId <= t; caseId++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                String moves = scanner.next();
                int result = findMinimumMoves(x, y, 0, 0, 0, moves);
                String output = result == -1 ? "IMPOSSIBLE" : String.valueOf(result);
                System.out.println("Case #" + caseId + ": " + output);
            }
        }
    }

    private static int findMinimumMoves(int targetX, int targetY, int currentX, int currentY, int moveCount, String remainingMoves) {
        if (targetX == currentX && targetY == currentY) {
            return moveCount;
        }

        if (remainingMoves.isEmpty() || (Math.abs(targetX - currentX) + Math.abs(targetY - currentY)) > 2 * remainingMoves.length()) {
            return -1;
        }

        char direction = remainingMoves.charAt(0);
        String nextMoves = remainingMoves.substring(1);

        int nextX = currentX;
        int nextY = currentY;

        switch (direction) {
            case 'N':
                nextY += 1;
                break;
            case 'S':
                nextY -= 1;
                break;
            case 'E':
                nextX += 1;
                break;
            case 'W':
                nextX -= 1;
                break;
        }

        int stay = findMinimumMoves(targetX, targetY, nextX, nextY, moveCount + 1, nextMoves);
        int north = findMinimumMoves(targetX, targetY, nextX, nextY + 1, moveCount + 1, nextMoves);
        int south = findMinimumMoves(targetX, targetY, nextX, nextY - 1, moveCount + 1, nextMoves);
        int east = findMinimumMoves(targetX, targetY, nextX + 1, nextY, moveCount + 1, nextMoves);

        return IntStream.of(stay, north, south, east)
                .filter(i -> i >= 0)
                .min()
                .orElse(-1);
    }
}