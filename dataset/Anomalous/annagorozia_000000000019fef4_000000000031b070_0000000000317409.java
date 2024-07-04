import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < testCases; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                String moves = scanner.nextLine();

                int result = calculateMoves(x, y, moves);
                System.out.println("Case #" + (i + 1) + ": " + (result == -1 ? "IMPOSSIBLE" : result));
            }
        }
    }

    private static int calculateMoves(int x, int y, String moves) {
        for (int i = 0; i < moves.length(); i++) {
            char move = moves.charAt(i);
            switch (move) {
                case 'S': y--; break;
                case 'N': y++; break;
                case 'E': x++; break;
                case 'W': x--; break;
            }
            if (isReachable(0, 0, x, y, 0, i + 1)) {
                return i + 1;
            }
        }
        return -1;
    }

    private static boolean isReachable(int startX, int startY, int destX, int destY, int steps, int limit) {
        if (steps == limit) return false;
        if (startX == destX && startY == destY) return true;

        steps++;
        return isReachable(startX + 1, startY, destX, destY, steps, limit) ||
               isReachable(startX, startY + 1, destX, destY, steps, limit) ||
               isReachable(startX, startY - 1, destX, destY, steps, limit) ||
               isReachable(startX - 1, startY, destX, destY, steps, limit);
    }
}