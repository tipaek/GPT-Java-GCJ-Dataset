import java.util.Scanner;

public class Solution {

    private static final int BOUNDARY = 100;
    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private String infS;

    private String findPath(int curX, int curY, int destX, int destY, int step) {
        if (curX == destX && curY == destY) return "";
        if (Math.abs(curX) > BOUNDARY || Math.abs(curY) > BOUNDARY) return infS;

        int jump = 1 << step; // Equivalent to Math.pow(2, step)
        String moveEast = "E" + findPath(curX + jump, curY, destX, destY, step + 1);
        String moveWest = "W" + findPath(curX - jump, curY, destX, destY, step + 1);
        String moveNorth = "N" + findPath(curX, curY - jump, destX, destY, step + 1);
        String moveSouth = "S" + findPath(curX, curY + jump, destX, destY, step + 1);

        String[] moves = {moveEast, moveWest, moveNorth, moveSouth};
        String shortestMove = moveEast;

        for (String move : moves) {
            if (move.length() < shortestMove.length()) {
                shortestMove = move;
            }
        }
        return shortestMove;
    }

    private void solve() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= 10000; i++) {
            sb.append('a');
        }
        infS = sb.toString();

        for (int t = 1; t <= testCases; t++) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            if (X % 2 != 0 && Y % 2 != 0) {
                System.out.println("Case #" + t + ": " + IMPOSSIBLE);
                continue;
            }
            String result = findPath(0, 0, X, Y, 0);
            System.out.println("Case #" + t + ": " + result);
        }
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}