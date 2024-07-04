import java.util.Scanner;

public class Solution {

    private static final int BOUNDARY = 100;
    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private String infS;

    private String dfs(int curX, int curY, int targetX, int targetY, int step) {
        if (curX == targetX && curY == targetY) return "";
        if (Math.abs(curX) > BOUNDARY || Math.abs(curY) > BOUNDARY) return infS;

        int jump = 1 << step; // Equivalent to (int)Math.pow(2, step)
        String moveEast = "E" + dfs(curX + jump, curY, targetX, targetY, step + 1);
        String moveWest = "W" + dfs(curX - jump, curY, targetX, targetY, step + 1);
        String moveNorth = "N" + dfs(curX, curY - jump, targetX, targetY, step + 1);
        String moveSouth = "S" + dfs(curX, curY + jump, targetX, targetY, step + 1);

        String shortestPath = moveEast;
        if (moveWest.length() < shortestPath.length()) shortestPath = moveWest;
        if (moveNorth.length() < shortestPath.length()) shortestPath = moveNorth;
        if (moveSouth.length() < shortestPath.length()) shortestPath = moveSouth;

        return shortestPath;
    }

    private void solve() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        StringBuilder infiniteString = new StringBuilder();
        for (int i = 0; i < 10001; i++) {
            infiniteString.append('a');
        }
        infS = infiniteString.toString();

        for (int t = 1; t <= testCases; t++) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            if (X % 2 != 0 && Y % 2 != 0) {
                System.out.println(IMPOSSIBLE);
            } else {
                String result = dfs(0, 0, X, Y, 0);
                System.out.println(result);
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}