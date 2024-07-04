import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    
    private static final char NORTH = 'N';
    private static final char SOUTH = 'S';
    private static final char EAST = 'E';
    private static final char WEST = 'W';
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    private static String findSolution(int catX, int catY, String catMoves) {
        if (catX == 0 && catY == 0) {
            return "0";
        }

        int time = 0;
        int currentX = catX;
        int currentY = catY;

        for (int i = 0; i < catMoves.length(); i++) {
            char move = catMoves.charAt(i);
            switch (move) {
                case NORTH:
                    currentY++;
                    break;
                case SOUTH:
                    currentY--;
                    break;
                case EAST:
                    currentX++;
                    break;
                case WEST:
                    currentX--;
                    break;
            }

            time++;

            if (Math.abs(currentX) + Math.abs(currentY) <= time) {
                return String.valueOf(time);
            }
        }

        return IMPOSSIBLE;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int catX = scanner.nextInt();
            int catY = scanner.nextInt();
            String moves = scanner.next();
            System.out.println("Case #" + i + ": " + findSolution(catX, catY, moves));
        }
    }
}