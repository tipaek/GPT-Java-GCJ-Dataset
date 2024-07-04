import java.util.Scanner;

public class Solution {

    private Scanner scanner = new Scanner(System.in);

    private int solve(int x, int y, String moves) {
        int currentX = x, currentY = y;
        for (int i = 0; i < moves.length(); i++) {
            if (Math.abs(currentX) + Math.abs(currentY) <= i) {
                return i;
            }
            char move = moves.charAt(i);
            switch (move) {
                case 'S':
                    currentY--;
                    break;
                case 'N':
                    currentY++;
                    break;
                case 'E':
                    currentX++;
                    break;
                case 'W':
                    currentX--;
                    break;
            }
        }
        if (Math.abs(currentX) + Math.abs(currentY) <= moves.length()) {
            return moves.length();
        }
        return -1;
    }

    private void run() {
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String moves = scanner.next();
            int result = solve(x, y, moves);
            if (result == -1) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", t);
            } else {
                System.out.printf("Case #%d: %d%n", t, result);
            }
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}