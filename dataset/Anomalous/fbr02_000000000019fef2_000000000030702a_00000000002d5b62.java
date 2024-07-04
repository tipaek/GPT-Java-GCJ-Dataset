import java.util.Scanner;

public class Solution {

    private String infS;

    private String dfs(int curX, int curY, int targetX, int targetY, int mul) {
        if (curX == targetX && curY == targetY) return "";
        if (Math.abs(curX) > 100 || Math.abs(curY) > 100) return infS;

        int jump = 1 << mul; // Equivalent to (int)Math.pow(2, mul)
        String moveRight = "E" + dfs(curX + jump, curY, targetX, targetY, mul + 1);
        String moveLeft = "W" + dfs(curX - jump, curY, targetX, targetY, mul + 1);
        String moveDown = "S" + dfs(curX, curY - jump, targetX, targetY, mul + 1);
        String moveUp = "N" + dfs(curX, curY + jump, targetX, targetY, mul + 1);

        String[] moves = {moveRight, moveLeft, moveDown, moveUp};
        String shortestMove = moveRight;

        for (String move : moves) {
            if (move.length() < shortestMove.length()) {
                shortestMove = move;
            }
        }

        return shortestMove;
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10001; i++) {
            sb.append('a');
        }
        infS = sb.toString();

        for (int t = 1; t <= T; t++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            if (X % 2 != 0 && Y % 2 != 0) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
                continue;
            }
            String res = dfs(0, 0, X, Y, 0);
            System.out.println("Case #" + t + ": " + res);
        }
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}